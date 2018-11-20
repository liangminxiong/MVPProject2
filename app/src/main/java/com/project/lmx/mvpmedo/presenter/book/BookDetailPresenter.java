package com.project.lmx.mvpmedo.presenter.book;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.constant.BundleKeyConstant;
import com.project.lmx.mvpmedo.contract.book.BookDeatilContract;
import com.project.lmx.mvpmedo.model.bean.douban.book.BookDetailBean;
import com.project.lmx.mvpmedo.model.bean.douban.book.BookItemBean;
import com.project.lmx.mvpmedo.model.book.BookDetailModel;
import com.project.lmx.mvpmedo.ui.activity.detail.WebViewLoadActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/10/23.
 * <p>
 */

public class BookDetailPresenter extends BookDeatilContract.BookDetailPresenter {

    @NonNull
    public static BookDetailPresenter newInstance() {
        return new BookDetailPresenter();
    }

    @Override
    public void loadBookDetail(String id) {
        if (mIView == null || mIModel == null)
            return;

        mRxManager.register(mIModel.getBookDetail(id).subscribe(new Consumer<BookDetailBean>() {
            @Override
            public void accept(BookDetailBean bean) throws Exception {
                if (mIView == null)
                    return;

                mIView.showBookDetail(bean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView == null)
                    return;
                mIView.showToast("Network error.");
                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public void onHeaderClick(BookItemBean bean) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_WEB_VIEW_LOAD_TITLE, bean.getTitle());
        bundle.putString(BundleKeyConstant.ARG_KEY_WEB_VIEW_LOAD_URL, bean.getAlt());
        mIView.startNewActivity(WebViewLoadActivity.class, bundle);
    }

    @Override
    protected BookDeatilContract.IBookDetailModel getModel() {
        return BookDetailModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
