package com.project.lmx.mvpmedo.presenter.detail;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.detail.GankIoDetailContract;
import com.project.lmx.mvpmedo.model.detail.GankIoDetailModel;

/**
 * Created by Administrator on 2017/10/11.
 * <p>
 */

public class GankIoDetailPresenter extends GankIoDetailContract.GankIoDetailPresenter{
    @NonNull
    public static GankIoDetailPresenter newInstance() {
        return new GankIoDetailPresenter();
    }

    @Override
    public void loadGankIoDetail(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showGankIoDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    protected GankIoDetailContract.IGankIoDetailModel getModel() {
        return GankIoDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
