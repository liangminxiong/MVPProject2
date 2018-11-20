package com.project.lmx.mvpmedo.presenter.gankio.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.constant.BundleKeyConstant;
import com.project.lmx.mvpmedo.contract.gankio.tabs.GankIoWelfareContract;
import com.project.lmx.mvpmedo.model.bean.gankio.GankIoWelfareItemBean;
import com.project.lmx.mvpmedo.model.bean.gankio.GankIoWelfareListBean;
import com.project.lmx.mvpmedo.model.gankio.tabs.GankIoWelfareModel;
import com.project.lmx.mvpmedo.ui.activity.pic.ImageBrowseActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/10/16.
 * <p>
 */

public class GankIoWelfarePresenter extends GankIoWelfareContract.GankIoWelfarePresenter {
    private int mCurrentPage;
    private boolean isLoading;

    @NonNull
    public static GankIoWelfarePresenter newInstance() {
        return new GankIoWelfarePresenter();
    }

    @Override
    public void loadLatestList() {
        if (mIModel == null || mIView == null)
            return;

        mCurrentPage = 1;
        mRxManager.register(mIModel.getWelfareList(10, mCurrentPage).subscribe(new Consumer<GankIoWelfareListBean>() {
            @Override
            public void accept(GankIoWelfareListBean gankIoWelfareListBean) throws Exception {
                if (mIView == null)
                    return;

                if (gankIoWelfareListBean.isError()) {
                    mIView.showNetworkError();
                } else {
                    mCurrentPage++;
                    mIView.updateContentList(gankIoWelfareListBean.getResults());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView != null) {
                    if (mIView.isVisiable())
                        mIView.showToast("Network error.");
                    mIView.showNetworkError();
                }
            }
        }));
    }

    @Override
    public void loadMoreList() {
        if (!isLoading) {
            isLoading = true;
            //一次加载20条数据
            mRxManager.register(mIModel.getWelfareList(10, mCurrentPage).subscribe(new Consumer<GankIoWelfareListBean>() {
                @Override
                public void accept(GankIoWelfareListBean gankIoWelfareListBean) throws
                        Exception {
                    isLoading = false;
                    if (mIView == null)
                        return;

                    if (gankIoWelfareListBean.isError()) {
                        mIView.showNetworkError();
                    } else {
                        if (gankIoWelfareListBean.getResults().size() > 0) {
                            mCurrentPage++;
                            mIView.updateContentList(gankIoWelfareListBean.getResults());
                        } else {
                            mIView.showNoMoreData();
                        }
                    }
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    isLoading = false;
                    if (mIView != null) {
                        mIView.showLoadMoreError();
                    }
                }
            }));
        }
    }

    @Override
    public void onItemClick(int position, GankIoWelfareItemBean item) {
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_IMAGE_BROWSE_URL, item.getUrl());
        mIView.startNewActivity(ImageBrowseActivity.class, bundle);
    }


    @Override
    protected GankIoWelfareContract.IGankIoWelfareModel getModel() {
        return GankIoWelfareModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
