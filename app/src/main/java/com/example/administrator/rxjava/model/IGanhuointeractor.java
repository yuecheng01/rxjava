package com.example.administrator.rxjava.model;

import com.example.administrator.rxjava.http.ICommonInteractorCallback;

/**
 * Created by Administrator on 2017/12/24.
 */

public interface IGanhuointeractor {
     void getBannerPageData(int page, ICommonInteractorCallback l);
     void getGuessYouLikeData(ICommonInteractorCallback l);
}
