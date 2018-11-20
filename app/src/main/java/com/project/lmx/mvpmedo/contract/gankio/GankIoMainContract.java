package com.project.lmx.mvpmedo.contract.gankio;

import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.base.IBaseFragment;
import com.project.lmx.sdk.base.IBaseModel;

/**
 * Created by Administrator on 2017/10/7.
 * <p>
 */

public interface GankIoMainContract {
    //主页接口
    abstract class GankIoMainPresenter extends BasePresenter<IGankIoMainModel, IGankIoMainView> {
        public abstract void getTabList();
    }

    interface IGankIoMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IGankIoMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }
}
