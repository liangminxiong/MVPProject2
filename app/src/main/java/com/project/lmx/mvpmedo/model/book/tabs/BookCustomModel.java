package com.project.lmx.mvpmedo.model.book.tabs;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.sdk.helper.RetrofitCreateHelper;
import com.project.lmx.sdk.helper.RxHelper;
import com.project.lmx.mvpmedo.api.DoubanApi;
import com.project.lmx.mvpmedo.contract.book.tabs.BookCustomContract;
import com.project.lmx.mvpmedo.model.bean.douban.book.BookListBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/21.
 * <p>
 */

public class BookCustomModel extends BaseModel implements BookCustomContract.IBookCustomModel {
    @NonNull
    public static BookCustomModel newInstance() {
        return new BookCustomModel();
    }

    @Override
    public Observable<BookListBean> getBookListWithTag(String tag, int start, int count) {
        return RetrofitCreateHelper.createApi(DoubanApi.class, DoubanApi.HOST).getBookListWithTag
                (tag, start, count).compose(RxHelper.<BookListBean>rxSchedulerHelper());
    }
}
