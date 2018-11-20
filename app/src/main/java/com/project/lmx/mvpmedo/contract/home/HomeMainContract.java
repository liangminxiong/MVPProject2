package com.project.lmx.mvpmedo.contract.home;

import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.base.IBaseFragment;
import com.project.lmx.sdk.base.IBaseModel;

/**
 * Created by Administrator on 2017/9/11.
 * <p>
 * 主页Contract
 */

public interface HomeMainContract {
    //主页接口
    abstract class HomeMainPresenter extends BasePresenter<IHomeMainModel, IHomeMainView> {
        public abstract void getTabList();
    }

    interface IHomeMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IHomeMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }
}
