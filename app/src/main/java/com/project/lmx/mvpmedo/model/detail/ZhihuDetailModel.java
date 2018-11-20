package com.project.lmx.mvpmedo.model.detail;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.ZhihuApi;
import com.project.lmx.mvpmedo.contract.detail.ZhihuDetailContract;
import com.project.lmx.mvpmedo.model.bean.zhihu.ZhihuDailyDetailBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/13.
 * <p>
 */

public class ZhihuDetailModel extends BaseModel implements ZhihuDetailContract.IZhihuDetailModel {

    @NonNull
    public static ZhihuDetailModel newInstance() {
        return new ZhihuDetailModel();
    }

    @Override
    public Observable<ZhihuDailyDetailBean> getDailyDetail(String id) {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getZhihuDailyDetail
                (id).compose(RxHelper.<ZhihuDailyDetailBean>rxSchedulerHelper());
    }
}
