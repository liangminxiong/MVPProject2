package com.project.lmx.sdk.base.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.base.IBaseFragment;
import com.project.lmx.sdk.base.activity.BaseCompatActivity;
import com.project.lmx.sdk.utils.ToastUtils;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2017/9/6.
 * <p>
 * Mvp Fragment基类
 * <p>
 * 实现IBaseView方法、绑定butterknife
 */

public abstract class BaseMVPCompatFragment<P extends BasePresenter> extends
        BaseCompatFragment implements IBaseFragment {
    public P mPresenter;

    /**
     * 在监听器之前把数据准备好
     */
    public void initData() {
        super.initData();

        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
                mPresenter.attachMV(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
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
        ToastUtils.showToast(mContext, msg, Toast.LENGTH_SHORT);
    }

    @Override
    public void back() {
        this.onBackPressedSupport();
    }

    @Override
    public void startNewFragment(@NonNull SupportFragment supportFragment) {
        start(supportFragment);
    }

    @Override
    public void startNewFragmentWithPop(@NonNull SupportFragment supportFragment) {
        startWithPop(supportFragment);
    }

    @Override
    public void startNewFragmentForResult(@NonNull SupportFragment supportFragment, int
            requestCode) {
        startForResult(supportFragment, requestCode);
    }

    @Override
    public void popToFragment(Class<?> targetFragmentClass, boolean includeTargetFragment) {
        popTo(targetFragmentClass, includeTargetFragment);
    }

    @Override
    public void hideKeybord() {
        hideSoftInput();
    }

    @Override
    public void setOnFragmentResult(int ResultCode, Bundle data) {
        setFragmentResult(ResultCode, data);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz) {
        ((BaseCompatActivity) mActivity).startActivity(clz);
    }

    @Override
    public void startNewActivity(@NonNull Class<?> clz, Bundle bundle) {
        ((BaseCompatActivity) mActivity).startActivity(clz, bundle);
    }

    @Override
    public void startNewActivityForResult(@NonNull Class<?> clz, Bundle bundle, int requestCode) {
        ((BaseCompatActivity) mActivity).startActivityForResult(clz, bundle, requestCode);
    }

    @Override
    public boolean isVisiable() {
        return isSupportVisible();
    }

    @Override
    public Activity getBindActivity() {
        return mActivity;
    }
}