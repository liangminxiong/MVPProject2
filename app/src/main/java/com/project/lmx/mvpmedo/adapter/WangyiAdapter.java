package com.project.lmx.mvpmedo.adapter;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.lmx.sdk.config.DBConfig;
import com.project.lmx.sdk.config.ItemState;
import com.project.lmx.sdk.utils.DBUtils;
import com.project.lmx.sdk.utils.SpUtils;
import com.project.lmx.mvpmedo.R;
import com.project.lmx.mvpmedo.model.bean.wangyi.WangyiNewsItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/18.
 * <p>
 * 网易新闻Adapter
 */

public class WangyiAdapter extends BaseCompatAdapter<WangyiNewsItemBean, BaseViewHolder> {

    public WangyiAdapter(@LayoutRes int layoutResId, @Nullable List<WangyiNewsItemBean> data) {
        super(layoutResId, data);
    }

    public WangyiAdapter(@Nullable List<WangyiNewsItemBean> data) {
        super(data);
    }

    public WangyiAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, WangyiNewsItemBean item) {
        if (DBUtils.getDB(mContext).isRead(DBConfig.TABLE_WANGYI, item.getDocid(), ItemState
                .STATE_IS_READ)) {
            helper.setTextColor(R.id.tv_item_title, Color.GRAY);
        } else {
            if (SpUtils.getNightModel(mContext)) {
                helper.setTextColor(R.id.tv_item_title, Color.WHITE);
            } else {
                helper.setTextColor(R.id.tv_item_title, Color.BLACK);
            }
        }
        helper.setText(R.id.tv_item_title, item.getTitle());
        helper.setText(R.id.tv_item_who, item.getSource());
        helper.setText(R.id.tv_item_time, item.getPtime());
        Glide.with(mContext).load(item.getImgsrc()).crossFade().into((ImageView) helper.getView(R
                .id.iv_item_image));
    }
}
