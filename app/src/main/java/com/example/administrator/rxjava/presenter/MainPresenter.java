package com.example.administrator.rxjava.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.rxjava.adapter.FuliAdapter;
import com.example.administrator.rxjava.model.GanHuoInteractorImpl;
import com.example.administrator.rxjava.model.bean.GankDataBean;
import com.example.administrator.rxjava.http.ICommonInteractorCallback;
import com.example.administrator.rxjava.model.bean.GuessYouLike;
import com.example.administrator.rxjava.model.IGanhuointeractor;
import com.example.administrator.rxjava.view.IMainView;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/12/24.
 */

public class MainPresenter {
    private IGanhuointeractor mInteractor;
    private IMainView mView;
    private FuliAdapter mAdapter;

    public MainPresenter(IMainView iMainView) {
        this.mView = iMainView;
        mInteractor = new GanHuoInteractorImpl();
        mAdapter = new FuliAdapter((Context) mView);
    }

    public void loadData(int page){
        mInteractor.getBannerPageData(page,new ICommonInteractorCallback(){
            @Override
            public void loadSuccess(Object object) {
                GankDataBean mGankDataBean = (GankDataBean) object;
                mAdapter.addItems(mGankDataBean.getResults());
            }
            @Override
            public void loadFailed() {

            }

            @Override
            public void loadCompleted() {

            }

            @Override
            public void addDisaposed(Disposable disposable) {

            }
        });
    }

    public FuliAdapter getAdapter() {
        return mAdapter;
    }

    public void guessyoulike() {
        mInteractor.getGuessYouLikeData(new ICommonInteractorCallback() {
            @Override
            public void loadSuccess(Object object) {
                GuessYouLike gs = (GuessYouLike)object;
                Log.d("GuessYouLike---->",gs.toString());
                Toast.makeText((Context) mView,gs.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void loadFailed() {

            }

            @Override
            public void loadCompleted() {

            }

            @Override
            public void addDisaposed(Disposable disposable) {

            }
        });
    }
}
