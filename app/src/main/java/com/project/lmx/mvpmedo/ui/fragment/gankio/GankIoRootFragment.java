package com.project.lmx.mvpmedo.ui.fragment.gankio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project.lmx.sdk.base.fragment.BaseCompatFragment;
import com.project.lmx.mvpmedo.R;
import com.project.lmx.mvpmedo.ui.fragment.gankio.child.GankIoFragment;

/**
 * Created by Administrator on 2017/10/8.
 * <p>
 */

public class GankIoRootFragment extends BaseCompatFragment {

    public static GankIoRootFragment newInstance() {
        Bundle args = new Bundle();
        GankIoRootFragment fragment = new GankIoRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank_io;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(GankIoFragment.class) == null) {
            loadRootFragment(R.id.fl_container, GankIoFragment.newInstance());
        }
    }
}
