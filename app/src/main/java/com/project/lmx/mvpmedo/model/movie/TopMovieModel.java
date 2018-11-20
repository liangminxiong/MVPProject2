package com.project.lmx.mvpmedo.model.movie;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.DoubanApi;
import com.project.lmx.mvpmedo.contract.movie.TopMovieContract;
import com.project.lmx.mvpmedo.model.bean.douban.movie.HotMovieBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/18.
 * <p>
 */

public class TopMovieModel extends BaseModel implements TopMovieContract.ITopMovieModel {

    @NonNull
    public static TopMovieModel newInstance() {
        return new TopMovieModel();
    }

    @Override
    public Observable<HotMovieBean> getTopMovieList(int start, int count) {
        return RetrofitCreateHelper.createApi(DoubanApi.class, DoubanApi.HOST).getMovieTop250
                (start, count).compose(RxHelper.<HotMovieBean>rxSchedulerHelper());
    }
}
