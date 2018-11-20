package com.project.lmx.mvpmedo.model.book;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.DoubanApi;
import com.project.lmx.mvpmedo.contract.book.BookDeatilContract;
import com.project.lmx.mvpmedo.model.bean.douban.book.BookDetailBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/23.
 * <p>
 */

public class BookDetailModel extends BaseModel implements BookDeatilContract.IBookDetailModel {

    @NonNull
    public static BookDetailModel newInstance() {
        return new BookDetailModel();
    }

    @Override
    public Observable<BookDetailBean> getBookDetail(String id) {
        return RetrofitCreateHelper.createApi(DoubanApi.class, DoubanApi.HOST).getBookDetail(id)
                .compose(RxHelper.<BookDetailBean>rxSchedulerHelper());
    }
}
