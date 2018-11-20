package com.project.lmx.mvpmedo.presenter.home;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.home.HomeMainContract;
import com.project.lmx.mvpmedo.model.home.HomeMainModel;

/**
 * Created by Administrator on 2017/9/11.
 * <p>
 */

public class HomeMainPresenter extends HomeMainContract.HomeMainPresenter {

    @NonNull
    public static HomeMainPresenter newInstance() {
        return new HomeMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected HomeMainContract.IHomeMainModel getModel() {
        return HomeMainModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
