package com.project.lmx.mvpmedo.model.detail;

import android.support.annotation.NonNull;

import com.project.lmx.sdk.base.BaseModel;
import com.project.lmx.mvpmedo.contract.detail.GankIoDetailContract;

/**
 * Created by Administrator on 2017/10/11.
 * <p>
 */

public class GankIoDetailModel extends BaseModel implements GankIoDetailContract
        .IGankIoDetailModel {

    @NonNull
    public static GankIoDetailModel newInstance() {
        return new GankIoDetailModel();
    }
}
