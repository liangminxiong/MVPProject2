package com.project.lmx.mvpmedo.model.home.tabs;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.config.DBConfig;
import com.project.lmx.sdk.config.ItemState;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.sdk.utils.AppUtils;
import com.project.lmx.sdk.utils.DBUtils;
import com.project.lmx.mvpmedo.api.ZhihuApi;
import com.project.lmx.mvpmedo.contract.home.tabs.ZhihuContract;
import com.project.lmx.mvpmedo.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by Administrator on 2017/9/12.
 * <p>
 */

public class ZhihuModel extends BaseModel implements ZhihuContract.IZhihuModel {

    @NonNull
    public static ZhihuModel newInstance() {
        return new ZhihuModel();
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList(String date) {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getDailyListWithDate
                (date).compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<ZhihuDailyListBean> getDailyList() {
        return RetrofitCreateHelper.createApi(ZhihuApi.class, ZhihuApi.HOST).getLastDailyList()
                .compose(RxHelper.<ZhihuDailyListBean>rxSchedulerHelper());
    }

    @Override
    public Observable<Boolean> recordItemIsRead(final String key) {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(DBUtils.getDB(AppUtils.getContext()).insertRead(DBConfig
                        .TABLE_ZHIHU, key, ItemState.STATE_IS_READ));
                emitter.onComplete();
            }
        }).compose(RxHelper.<Boolean>rxSchedulerHelper());
    }
}
