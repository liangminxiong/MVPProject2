package com.project.lmx.mvpmedo.presenter.detail;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.detail.WeixinDetailContract;
import com.project.lmx.mvpmedo.model.detail.WeixinDetailModel;

/**
 * Created by Administrator on 2017/9/21.
 * <p>
 */

public class WeixinDetailPresenter extends WeixinDetailContract.WeixinDetailPresenter{
    @NonNull
    public static WeixinDetailPresenter newInstance() {
        return new WeixinDetailPresenter();
    }

    @Override
    public void loadWeixinChoiceDetail(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showWeixinChoiceDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    protected WeixinDetailContract.IWeixinDetailModel getModel() {
        return WeixinDetailModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
