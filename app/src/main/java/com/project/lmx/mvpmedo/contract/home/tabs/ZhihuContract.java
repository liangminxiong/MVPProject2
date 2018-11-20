package com.project.lmx.mvpmedo.contract.home.tabs;

import com.project.lmx.mvpmedo.model.bean.zhihu.ZhihuDailyItemBean;
import com.project.lmx.mvpmedo.model.bean.zhihu.ZhihuDailyListBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/9/12.
 * <p>
 * 知乎头条接口
 */

public interface ZhihuContract {

    abstract class ZhihuPresenter extends BaseTabsContract.BaseTabsPresenter<IZhihuModel,
            IZhihuView, ZhihuDailyItemBean> {
    }

    interface IZhihuModel extends BaseTabsContract.IBaseTabsModel {
        /**
         * 根据日期获取日报list --> 20170910
         *
         * @param date 日期
         * @return Observable
         */
        Observable<ZhihuDailyListBean> getDailyList(String date);

        /**
         * 获取日报list
         *
         * @return Observable
         */
        Observable<ZhihuDailyListBean> getDailyList();
    }

    interface IZhihuView extends BaseTabsContract.IBaseTabsView<ZhihuDailyItemBean> {
    }
}
