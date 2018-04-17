package com.example.administrator.rxjava.model;

import com.example.administrator.rxjava.http.ApiService;
import com.example.administrator.rxjava.http.Constants;
import com.example.administrator.rxjava.http.ICommonInteractorCallback;
import com.example.administrator.rxjava.model.bean.GankDataBean;
import com.example.administrator.rxjava.model.bean.GuessYouLike;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/23.
 */

public class GanHuoInteractorImpl implements IGanhuointeractor {
    public void getBannerPageData(int page, final ICommonInteractorCallback l){
        ApiService.Factory.createService(Constants.API_Ganhuo)
                .getGankIoData("福利",10,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        l.addDisaposed(d);
                    }

                    @Override
                    public void onNext(GankDataBean gankDataBean) {
//                        Log.e("response",gankDataBean.toString());
                        l.loadSuccess(gankDataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        l.loadFailed();
                    }

                    @Override
                    public void onComplete() {
                        l.loadCompleted();
                    }
                });
    }
    public void getGuessYouLikeData(final ICommonInteractorCallback l){
        ApiService.Factory.createService(Constants.API_JINGO)
                .getGuessYouLike(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GuessYouLike>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        l.addDisaposed(d);
                    }

                    @Override
                    public void onNext(GuessYouLike guessYouLike) {
                        l.loadSuccess(guessYouLike);
                    }

                    @Override
                    public void onError(Throwable e) {
                        l.loadFailed();
                    }

                    @Override
                    public void onComplete() {
                        l.loadCompleted();
                    }
                });
    }
}
