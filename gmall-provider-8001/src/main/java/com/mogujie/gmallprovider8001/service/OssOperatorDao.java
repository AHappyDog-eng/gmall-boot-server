package com.mogujie.gmallprovider8001.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * OSS 文件上传获取url等 多文件上传
 *
 * @author WN
 * @date 2020/7/31 8:50
 */
public interface OssOperatorDao {
    /**
     * 上传单个文件
     *
     * @param imgFiles 代表从前台传输的MultipartFile 文件
     * @return java.lang.String
     */
    String upload(MultipartFile imgFiles);

    /**
     * 上传多个文件
     * @see org.springframework.web.multipart;
     * @param imgFiles 多个MultipartFile文件集合
     * @return java.lang.String
     */
    String uploadFiles(List<MultipartFile> imgFiles);
}
