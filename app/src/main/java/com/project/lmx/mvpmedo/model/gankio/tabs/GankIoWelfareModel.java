package com.project.lmx.mvpmedo.model.gankio.tabs;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.GankioApi;
import com.project.lmx.mvpmedo.contract.gankio.tabs.GankIoWelfareContract;
import com.project.lmx.mvpmedo.model.bean.gankio.GankIoWelfareListBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/16.
 * <p>
 */

public class GankIoWelfareModel extends BaseModel implements GankIoWelfareContract
        .IGankIoWelfareModel {

    @NonNull
    public static GankIoWelfareModel newInstance() {
        return new GankIoWelfareModel();
    }

    @Override
    public Observable<Boolean> recordItemIsRead(String key) {
        //不记录
        return null;
    }

    @Override
    public Observable<GankIoWelfareListBean> getWelfareList(int pre_page, int page) {
        return RetrofitCreateHelper.createApi(GankioApi.class, GankioApi.HOST)
                .getGankIoWelfareList(pre_page, page).compose(RxHelper
                        .<GankIoWelfareListBean>rxSchedulerHelper());
    }
}
