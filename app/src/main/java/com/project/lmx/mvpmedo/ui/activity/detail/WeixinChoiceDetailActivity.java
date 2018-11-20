package com.project.lmx.mvpmedo.ui.activity.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.view.View;

import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.utils.DisplayUtils;
import com.project.lmx.sdk.utils.ResourcesUtils;
import com.project.lmx.sdk.utils.StatusBarUtils;
import com.project.lmx.mvpmedo.R;
import com.project.lmx.mvpmedo.constant.BundleKeyConstant;
import com.project.lmx.mvpmedo.contract.detail.WeixinDetailContract;
import com.project.lmx.mvpmedo.presenter.detail.WeixinDetailPresenter;

/**
 * Created by Administrator on 2017/9/21.
 * <p>
 */

public class WeixinChoiceDetailActivity extends BaseWebViewLoadActivity<WeixinDetailContract
        .WeixinDetailPresenter> implements WeixinDetailContract.IWeixinDetailView {

    private String mTitle, mUrl, mImageUrl, mCopyright;

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUrl = bundle.getString(BundleKeyConstant.ARG_KEY_WEIXIN_DETAIL_URL);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_WEIXIN_DETAIL_TITLE);
            mImageUrl = bundle.getString(BundleKeyConstant.ARG_KEY_WEIXIN_DETAIL_IMAGE_URL);
            mCopyright = bundle.getString(BundleKeyConstant.ARG_KEY_WEIXIN_DETAIL_COPYRIGHT);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        //微信精选内部已经有Title等信息，直接显示webview内容
        //tvDetailTitle.setText(mTitle);
        //tvDetailcopyright.setText(mCopyright);
        //Glide.with(mContext).load(mImageUrl).crossFade().into(ivDetail);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) appBar.getChildAt(0)
                .getLayoutParams();
        // 控件的高强制设成56dp+状态栏高度
        params.height = DisplayUtils.dp2px(56) + StatusBarUtils.getStatusBarHeight
                (mContext);
    }

    @Override
    public void showWeixinChoiceDetail(String url) {
        flNetView.setVisibility(View.GONE);
        nswvDetailContent.loadUrl(url);
    }

    @Override
    protected void loadDetail() {
        mPresenter.loadWeixinChoiceDetail(mUrl);
    }

    @Override
    protected String getToolbarTitle() {
        return ResourcesUtils.getString(R.string.weixin_detail_title);
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return WeixinDetailPresenter.newInstance();
    }
}
