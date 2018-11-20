package com.project.lmx.mvpmedo.model.book;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.mvpmedo.contract.book.BookMainContract;

/**
 * Created by Administrator on 2017/10/21.
 * <p>
 */

public class BookMainModel extends BaseModel implements BookMainContract.IBookMainModel {

    @NonNull
    public static BookMainModel newInstance() {
        return new BookMainModel();
    }

    @Override
    public String[] getTabs() {
        return new String[]{"文学", "文化", "生活"};
    }
}
