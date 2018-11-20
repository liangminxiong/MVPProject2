package com.project.lmx.mvpmedo.contract.book;

import com.project.lmx.sdk.base.BasePresenter;
import com.project.lmx.sdk.base.IBaseActivity;
import com.project.lmx.sdk.base.IBaseModel;
import com.project.lmx.mvpmedo.model.bean.douban.book.BookDetailBean;
import com.project.lmx.mvpmedo.model.bean.douban.book.BookItemBean;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/10/23.
 * <p>
 */

public interface BookDeatilContract {
    abstract class BookDetailPresenter extends BasePresenter<IBookDetailModel, IBookDetailView> {
        /**
         * 加载书籍详情
         *
         * @param id 书籍id
         */
        public abstract void loadBookDetail(String id);

        /**
         * header点击事件
         *
         * @param bean bean
         */
        public abstract void onHeaderClick(BookItemBean bean);
    }

    interface IBookDetailModel extends IBaseModel {
        /**
         * 获取书籍详情
         *
         * @param id 书籍id
         * @return 书籍详情
         */
        Observable<BookDetailBean> getBookDetail(String id);
    }

    interface IBookDetailView extends IBaseActivity {
        /**
         * 显示书籍详情
         *
         * @param bean 书籍详情bean
         */
        void showBookDetail(BookDetailBean bean);

        /**
         * 显示网络错误
         */
        void showNetworkError();
    }
}
