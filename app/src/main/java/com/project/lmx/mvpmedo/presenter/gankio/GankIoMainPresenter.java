package com.project.lmx.mvpmedo.presenter.gankio;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.gankio.GankIoMainContract;
import com.project.lmx.mvpmedo.model.gankio.GankIoMainModel;

/**
 * Created by Administrator on 2017/10/7.
 * <p>
 */

public class GankIoMainPresenter extends GankIoMainContract.GankIoMainPresenter{

    @NonNull
    public static GankIoMainPresenter newInstance() {
        return new GankIoMainPresenter();
    }

    @Override
    public void getTabList() {
        if (mIView == null || mIModel == null)
            return;

        mIView.showTabList(mIModel.getTabs());
    }

    @Override
    protected GankIoMainContract.IGankIoMainModel getModel() {
        return GankIoMainModel.newInstance();
    }

    @Override
    public void onStart() {
        //getTabList();
    }
}
