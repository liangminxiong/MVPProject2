package com.project.lmx.mvpmedo.contract.book;

import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.base.IBaseFragment;
import com.project.lmx.sdk.base.IBaseModel;

/**
 * Created by Administrator on 2017/10/21.
 * <p>
 */

public interface BookMainContract {
    //book主页接口
    abstract class BookMainPresenter extends BasePresenter<IBookMainModel, IBookMainView> {
        public abstract void getTabList();
    }

    interface IBookMainModel extends IBaseModel {
        String[] getTabs();
    }

    interface IBookMainView extends IBaseFragment {
        void showTabList(String[] tabs);
    }
}
