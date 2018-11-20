package com.project.lmx.mvpmedo.ui.fragment.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project.lmx.sdk.base.fragment.BaseCompatFragment;
import com.project.lmx.mvpmedo.R;
import com.project.lmx.mvpmedo.ui.fragment.book.child.BookFragment;

/**
 * Created by Administrator on 2017/10/21.
 * <p>
 */

public class BookRootFragment extends BaseCompatFragment{

    public static BookRootFragment newInstance() {
        Bundle args = new Bundle();
        BookRootFragment fragment = new BookRootFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_book;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(BookFragment.class) == null) {
            loadRootFragment(R.id.fl_container, BookFragment.newInstance());
        }
    }
}
