package com.project.lmx.mvpmedo.model.movie;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.DoubanApi;
import com.project.lmx.mvpmedo.contract.movie.MovieMainContract;
import com.project.lmx.mvpmedo.model.bean.douban.movie.HotMovieBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/16.
 * <p>
 */

public class MovieMainModel extends BaseModel implements MovieMainContract.IMovieMainModel {

    @NonNull
    public static MovieMainModel newInstance() {
        return new MovieMainModel();
    }

    @Override
    public Observable<HotMovieBean> getHotMovieList() {
        return RetrofitCreateHelper.createApi(DoubanApi.class, DoubanApi.HOST).getHotMovie()
                .compose(RxHelper.<HotMovieBean>rxSchedulerHelper());
    }
}
