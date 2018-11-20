package com.project.lmx.mvpmedo.presenter.home.tabs;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.orhanobut.logger.Logger;
import com.project.lmx.mvpmedo.constant.BundleKeyConstant;
import com.project.lmx.mvpmedo.contract.home.tabs.ZhihuContract;
import com.project.lmx.mvpmedo.model.bean.zhihu.ZhihuDailyItemBean;
import com.project.lmx.mvpmedo.model.bean.zhihu.ZhihuDailyListBean;
import com.project.lmx.mvpmedo.model.home.tabs.ZhihuModel;
import com.project.lmx.mvpmedo.ui.activity.detail.ZhihuDailyDetailActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/9/12.
 * <p>
 */

public class ZhihuPresenter extends ZhihuContract.ZhihuPresenter {

    /**
     * 日报日期
     */
    private String mDate;

    @NonNull
    public static ZhihuPresenter newInstance() {
        return new ZhihuPresenter();
    }

    @Override
    public void loadLatestList() {
        if (mIModel == null)
            return;

        mRxManager.register(mIModel.getDailyList().subscribe(new Consumer<ZhihuDailyListBean>() {
            @Override
            public void accept(ZhihuDailyListBean zhihuDailyListBean) throws Exception {
                mDate = zhihuDailyListBean.getDate();
                //Logger.e("mDate = " + mDate);

                if (mIView != null)
                    mIView.updateContentList(zhihuDailyListBean.getStories());
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
        if (mIModel == null)
            return;
        mRxManager.register(mIModel.getDailyList(mDate).subscribe(new Consumer<ZhihuDailyListBean>() {
            @Override
            public void accept(ZhihuDailyListBean zhihuDailyListBean) throws Exception {
                if (mDate.equals(zhihuDailyListBean.getDate()))
                    return;

                mDate = zhihuDailyListBean.getDate();
                //Logger.e("mdate = " + mDate);
                if (mIView != null)
                    mIView.updateContentList(zhihuDailyListBean.getStories());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView != null) {
                    mIView.showLoadMoreError();
                }
            }
        }));
    }

    @Override
    public void onItemClick(final int position, final ZhihuDailyItemBean item) {
        //        Logger.e("item.getId() = " + item.getId());
        mRxManager.register(mIModel.recordItemIsRead(item.getId()).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (mIView == null)
                    return;

                if (aBoolean) {
                    mIView.itemNotifyChanged(position);
                } else {
                    Logger.e("写入点击状态值失败");
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        }));

        if (mIView == null)
            return;

        Bundle bundle = new Bundle();
        bundle.putString(BundleKeyConstant.ARG_KEY_ZHIHU_DETAIL_ID, item.getId());
        bundle.putString(BundleKeyConstant.ARG_KEY_ZHIHU_DETAIL_TITLE, item.getTitle());
        mIView.startNewActivity(ZhihuDailyDetailActivity.class, bundle);
    }

    @Override
    protected ZhihuContract.IZhihuModel getModel() {
        return ZhihuModel.newInstance();
    }

    @Override
    public void onStart() {
    }
}
