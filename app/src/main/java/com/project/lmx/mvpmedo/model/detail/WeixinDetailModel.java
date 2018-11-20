package com.project.lmx.mvpmedo.model.detail;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.mvpmedo.contract.detail.WeixinDetailContract;

/**
 * Created by Administrator on 2017/9/21.
 * <p>
 */

public class WeixinDetailModel extends BaseModel implements WeixinDetailContract.IWeixinDetailModel {
    @NonNull
    public static WeixinDetailModel newInstance() {
        return new WeixinDetailModel();
    }
}
