package com.project.lmx.sdk.base.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;
import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.base.IBaseActivity;
import com.project.lmx.sdk.utils.ToastUtils;

/**
 * Created by Administrator on 2017/4/6.
 * <p>
 * Mvp Activity基类
 */
public abstract class BaseMVPCompatActivity<P extends BasePresenter> extends
        BaseCompatActivity implements IBaseActivity {
    /**
     * presenter 具体的presenter由子类确定
     */
    protected P mPresenter;

    /**
     * 初始化数据
     * <p>
     * 子类可以复写此方法初始化子类数据
     */
    protected void initData() {
        super.initData();
        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
                mPresenter.attachMV(this);
            Logger.d("attach M V success.");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
            //Logger.d("detach M V success.");
        }
    }

    @Override
    public void showWaitDialog(String msg) {
        showProgressDialog(msg);
    }

    @Override
    public void hideWaitDialog() {
        hideProgressDialog();
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz) {
        startActivity(clz);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {
        startActivity(clz, bundle);
    }

    @Override
    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {
        startActivityForResult(clz, bundle, requestCode);
    }

    @Override
    public void hideKeybord() {
        hiddenKeyboard();
    }

    @Override
    public void back() {
        super.onBackPressedSupport();
    }
}
