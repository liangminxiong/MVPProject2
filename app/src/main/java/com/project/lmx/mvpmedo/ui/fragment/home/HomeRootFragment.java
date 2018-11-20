package com.project.lmx.mvpmedo.ui.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project.lmx.sdk.base.fragment.BaseCompatFragment;
import com.project.lmx.mvpmedo.R;
import com.project.lmx.mvpmedo.ui.fragment.home.child.HomeFragment;

/**
 * Created by Administrator on 2017/9/7.
 * <p>
 */

public class HomeRootFragment extends BaseCompatFragment {

    public static HomeRootFragment newInstance() {
        Bundle args = new Bundle();
        HomeRootFragment fragment = new HomeRootFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        if (findChildFragment(HomeFragment.class) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance());
        }
    }
}
