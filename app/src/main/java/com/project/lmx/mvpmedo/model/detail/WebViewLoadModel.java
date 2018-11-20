package com.project.lmx.mvpmedo.model.detail;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.mvpmedo.contract.detail.WebViewLoadConaract;

/**
 * Created by Administrator on 2017/10/20.
 * <p>
 */

public class WebViewLoadModel extends BaseModel implements
        WebViewLoadConaract.IWebViewLoadModel {

    @NonNull
    public static WebViewLoadModel newInstance() {
        return new WebViewLoadModel();
    }
}
