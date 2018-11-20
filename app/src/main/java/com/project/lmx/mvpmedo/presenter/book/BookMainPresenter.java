package com.project.lmx.mvpmedo.presenter.book;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.book.BookMainContract;
import com.project.lmx.mvpmedo.model.book.BookMainModel;

/**
 * Created by Administrator on 2017/10/21.
 * <p>
 */

public class BookMainPresenter extends BookMainContract.BookMainPresenter {
    @NonNull
    public static BookMainPresenter newInstance() {
        return new BookMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected BookMainContract.IBookMainModel getModel() {
        return BookMainModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
