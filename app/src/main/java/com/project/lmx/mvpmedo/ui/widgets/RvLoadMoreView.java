package com.project.lmx.mvpmedo.ui.widgets;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.project.lmx.mvpmedo.R;

/**
 * Created by Administrator on 2017/9/12.
 * <p>
 * 加载更多item view
 */

public class RvLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.item_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
