package com.example.administrator.rxjava.http;

import com.example.administrator.rxjava.App;
import com.example.administrator.rxjava.model.bean.GankDataBean;
import com.example.administrator.rxjava.model.bean.GuessYouLike;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import utils.NetWorkUtil;

/**
 * Created by Administrator on 2017/12/23.
 */

public interface ApiService {


    @GET("data/{type}/{page}/{current_page}")
    Observable<GankDataBean>  getGankIoData(@Path("type") String id,@Path("page") int page,@Path("current_page") int currentpage);

    @POST("mobile/Mobiledata/guessLike")
    Observable<GuessYouLike> getGuessYouLike(@Query("page") int page);
    /**
     * Create new Apiservice
     */
    class Factory{
        public static ApiService createService(String baseUrl){
            //ok的配置
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(15, TimeUnit.SECONDS);
            builder.connectTimeout(15,TimeUnit.SECONDS);
            //这里你可以拦截添加个公共参数什么的等等,干啥都行
            builder.addInterceptor(getInterceptor());

            OkHttpClient client = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    //Gson的转换工厂
                    .addConverterFactory(GsonConverterFactory.create())
                    //Observable的适配
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }
        //拦截器
        public static Interceptor getInterceptor(){
            return new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response mResponse = chain.proceed(chain.request());
                    if (NetWorkUtil.isNetWorkAvailable(App.getContext())) {
                        int maxAge = 60; // 在线缓存在1分钟内可读取
                        return mResponse.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .build();
                    } else {
                        // 离线时缓存保存1天
                        int maxStale = 60 * 60 * 24 * 1;
                        return mResponse.newBuilder()
                                .removeHeader("Pragma")
                                .removeHeader("Cache-Control")
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .build();
                    }
                }
            };
        }
    }
}
