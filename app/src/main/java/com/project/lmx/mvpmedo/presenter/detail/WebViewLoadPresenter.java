package com.project.lmx.mvpmedo.presenter.detail;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.detail.WebViewLoadConaract;
import com.project.lmx.mvpmedo.model.detail.WebViewLoadModel;

/**
 * Created by Administrator on 2017/10/20.
 * <p>
 */

public class WebViewLoadPresenter extends WebViewLoadConaract.WebViewLoadPresenter {

    @NonNull
    public static WebViewLoadPresenter newInstance() {
        return new WebViewLoadPresenter();
    }

    @Override
    public void loadUrl(String url) {
        if (mIView == null)
            return;

        try {
            mIView.showUrlDetail(url);
        } catch (Exception e) {
            mIView.showNetworkError();
            e.printStackTrace();
        }
    }

    @Override
    protected WebViewLoadConaract.IWebViewLoadModel getModel() {
        return WebViewLoadModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
