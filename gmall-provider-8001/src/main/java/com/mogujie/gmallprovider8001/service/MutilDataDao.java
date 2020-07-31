package com.mogujie.gmallprovider8001.service;

import com.mogujie.gmallapi.pojo.multidata.MultiData;

/**
 * @author WN
 * @date 2020/7/12 16:59
 */
public interface MutilDataDao {
    /**
     * 获取首页全部数据一次性
     * @return MultiData 全部数据的封装实体类型
     */
    MultiData getMultiData();
}
