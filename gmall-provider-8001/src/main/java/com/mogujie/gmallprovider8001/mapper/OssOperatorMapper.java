package com.mogujie.gmallprovider8001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DB层 映射mapper 文件进行数据库查询
 * @author WN
 * @date 2020/7/31 8:58
 */
@Mapper
@Repository
public interface OssOperatorMapper {
    /**
     * 上传单个文件
     *
     * @param imgUrl 从Dao层传输的文件流
     */
    void upload(String imgUrl);

    /**
     * 上传多个文件
     * @see org.springframework.web.multipart;
     * @param imgUrls 多个MultipartFile文件集合
     */
    void uploadFiles(@Param(value = "imgUrls") List<String> imgUrls);
}
