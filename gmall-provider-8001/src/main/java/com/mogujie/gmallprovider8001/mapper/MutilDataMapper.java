package com.mogujie.gmallprovider8001.mapper;

import com.mogujie.gmallapi.pojo.multidata.MultiData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author WN
 * @date 2020/7/12 16:57
 */
@Mapper
@Repository
public interface MutilDataMapper {
    /**
     * 获取首页全部数据一次性
     * @return MultiData 全部数据的封装实体类型
     */
    MultiData getMultiData();
}
