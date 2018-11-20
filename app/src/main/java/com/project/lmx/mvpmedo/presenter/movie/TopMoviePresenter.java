package com.project.lmx.mvpmedo.presenter.movie;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.project.lmx.mvpmedo.contract.movie.TopMovieContract;
import com.project.lmx.mvpmedo.model.bean.douban.movie.HotMovieBean;
import com.project.lmx.mvpmedo.model.bean.douban.movie.child.SubjectsBean;
import com.project.lmx.mvpmedo.model.movie.TopMovieModel;
import com.project.lmx.mvpmedo.ui.activity.detail.MovieDetailActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2017/10/18.
 * <p>
 */

public class TopMoviePresenter extends TopMovieContract.TopMoivePresenter {

    private int mStart;
    private int mCount = 30;
    private boolean isLoading;

    @NonNull
    public static TopMoviePresenter newInstance() {
        return new TopMoviePresenter();
    }

    @Override
    public void loadTopMovieList() {
        if (mIModel == null || mIView == null)
            return;

        mStart = 0;
        //一次加载20条数据
        mRxManager.register(mIModel.getTopMovieList(mStart, mCount).subscribe(new Consumer<HotMovieBean>() {
            @Override
            public void accept(HotMovieBean hotMovieBean) throws Exception {
                if (mIView == null)
                    return;

                mStart += mCount;
                mIView.updateContentList(hotMovieBean.getSubjects());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mIView == null)
                    return;

                if (mIView.isVisiable())
                    mIView.showToast("Network error.");

                mIView.showNetworkError();
            }
        }));
    }

    @Override
    public void loadMoreTopMovie() {
        if (!isLoading) {
            isLoading = true;
            //一次加载20条数据
            mRxManager.register(mIModel.getTopMovieList(mStart, mCount).subscribe(new Consumer<HotMovieBean>() {
                @Override
                public void accept(HotMovieBean hotMovieBean) throws
                        Exception {
                    isLoading = false;
                    if (mIView == null)
                        return;

                    if (hotMovieBean != null && hotMovieBean.getSubjects() != null &&
                            hotMovieBean.getSubjects().size() > 0) {
                        mStart += mCount;
                        mIView.updateContentList(hotMovieBean.getSubjects());
                    } else {
                        mIView.showNoMoreData();
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
    public void onItemClick(int position, SubjectsBean item, ImageView imageView) {
        //        Logger.e("position " + position + " is clicked.");
        MovieDetailActivity.start(mIView.getBindActivity(), item, imageView);
    }

    @Override
    protected TopMovieModel getModel() {
        return TopMovieModel.newInstance();
    }

    @Override
    public void onStart() {

    }
}
