package com.project.lmx.mvpmedo.model.detail;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.WangyiApi;
import com.project.lmx.mvpmedo.contract.detail.WangyiDetailContract;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2017/9/19.
 * <p>
 */

public class WangyiDetailModel extends BaseModel implements WangyiDetailContract
        .IWangyiDetailModel {

    @NonNull
    public static WangyiDetailModel newInstance() {
        return new WangyiDetailModel();
    }

    @Override
    public Observable<ResponseBody> getNewsDetail(String id) {
        return RetrofitCreateHelper.createApi(WangyiApi.class, WangyiApi.HOST).getNewsDetail(id)
                .compose(RxHelper.<ResponseBody>rxSchedulerHelper());
    }
}
