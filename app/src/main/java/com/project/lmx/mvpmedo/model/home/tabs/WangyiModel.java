package com.project.lmx.mvpmedo.model.home.tabs;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.config.DBConfig;
import com.project.lmx.sdk.config.ItemState;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.sdk.utils.AppUtils;
import com.project.lmx.sdk.utils.DBUtils;
import com.project.lmx.mvpmedo.api.WangyiApi;
import com.project.lmx.mvpmedo.contract.home.tabs.WangyiContract;
import com.project.lmx.mvpmedo.model.bean.wangyi.WangyiNewsListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Administrator on 2017/9/18.
 * <p>
 */

public class WangyiModel implements WangyiContract.IWangyiModel {
    @NonNull
    public static WangyiModel newInstance() {
        return new WangyiModel();
    }

    @Override
    public Observable<WangyiNewsListBean> getNewsList(int id) {
        return RetrofitCreateHelper.createApi(WangyiApi.class, WangyiApi.HOST).getNewsList(id)
                .compose(RxHelper.<WangyiNewsListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_WANGYI, key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
