package com.project.lmx.mvpmedo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.project.lmx.sdk.utils.StringUtils;
import com.project.lmx.mvpmedo.R;
import com.project.lmx.mvpmedo.model.bean.douban.movie.child.PersonBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 * <p>
 */

public class MovieDetailAdapter extends BaseCompatAdapter<PersonBean, BaseViewHolder> {
    public MovieDetailAdapter(@LayoutRes int layoutResId, @Nullable List<PersonBean> data) {
        super(layoutResId, data);
    }

    public MovieDetailAdapter(@Nullable List<PersonBean> data) {
        super(data);
    }

    public MovieDetailAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, PersonBean item) {
        helper.setText(R.id.tv_person_name, item.getName());
        helper.setText(R.id.tv_person_type, item.getType());
        try {
            //避免空指针异常
            if (StringUtils.isEmpty(item.getAvatars().getLarge()))
                return;

            Glide.with(mContext).load(item.getAvatars().getLarge()).crossFade().into((ImageView)
                    helper.getView(R.id.iv_avatar_photo));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
