package com.project.lmx.mvpmedo.cache;

import com.project.lmx.sdk.utils.SpUtils;
import com.project.lmx.mvpmedo.model.bean.douban.movie.child.SubjectsBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17.
 * <p>
 */

public class Cache {
    /**
     * 获取豆瓣电影hot cache
     *
     * @return 豆瓣电影hot cache
     */
    public static List<SubjectsBean> getHotMovieCache() {
        return SpUtils.getDataList("hot_movie_cache", SubjectsBean.class);
    }

    /**
     * 保存豆瓣电影hot cache
     */
    public static void saveHotMovieCache(List<SubjectsBean> list) {
        SpUtils.setDataList("hot_movie_cache", list);
    }
}
