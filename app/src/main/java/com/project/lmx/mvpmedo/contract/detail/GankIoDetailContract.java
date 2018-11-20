package com.project.lmx.mvpmedo.contract.detail;

import com.project.lmx.mvpmedo.presenter.detail.BaseWebViewLoadPresenter;

/**
 * Created by Administrator on 2017/10/11.
 * <p>
 */

public interface GankIoDetailContract {
    abstract class GankIoDetailPresenter extends BaseWebViewLoadPresenter<IGankIoDetailModel,
                IGankIoDetailView> {
        /**
         * 加载GankIo详情
         *
         * @param url url
         */
        public abstract void loadGankIoDetail(String url);
    }

    interface IGankIoDetailModel extends BaseWebViewLoadContract.IBaseWebViewLoadModel {
    }

    interface IGankIoDetailView extends BaseWebViewLoadContract.IBaseWebViewLoadView {
        /**
         * 显示GankIo详细内容
         *
         * @param url url
         */
        void showGankIoDetail(String url);
    }
}
