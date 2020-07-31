package com.mogujie.gmallprovider8001.service;

import com.alibaba.fastjson.JSON;
import com.mogujie.gmallprovider8001.enums.ResponseEnum;
import com.mogujie.gmallprovider8001.mapper.OssOperatorMapper;
import com.mogujie.gmallprovider8001.utils.OSSOperatorUtils;
import com.mogujie.gmallprovider8001.utils.RestResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author WN
 * @date 2020/7/31 8:57
 */
@Service
public class OssOperatorDaoImpl implements OssOperatorDao {
    private Logger logger = LoggerFactory.getLogger(OssOperatorDaoImpl.class);
    @Autowired
    private OssOperatorMapper mapper;
    /**
     * 注入文件上传工具
     */
    @Autowired
    private OSSOperatorUtils operatorUtils;

    public String upload(MultipartFile imgFiles) {

        // 上传图片 具体的业务逻辑
        String uploadImg = operatorUtils.uploadImg(imgFiles);

        try {
            mapper.upload(uploadImg);
        } catch (Exception e) {
            logger.info("上传图片失败 抛出异常");
            return JSON.toJSONString(RestResultGenerator.createResult("文件上传失败", ResponseEnum.UPLOAD_ERROR.getVal()));
        }
        return JSON.toJSONString(RestResultGenerator.createResult("文件上传成功", ResponseEnum.SUCCESS.getVal()));
    }

    public String uploadFiles(List<MultipartFile> imgFiles) {
        Map map = operatorUtils.checkList(imgFiles);
        List<String> imgFilesUrl = new ArrayList<String>();
        for (int i = 0; i < map.size(); i++) {
            imgFilesUrl.add((String) map.get(1));
        }
        /*try {*/
            mapper.uploadFiles(imgFilesUrl);
        /*} catch (Exception e) {
            logger.info("上传图片失败 抛出异常");
            return JSON.toJSONString(RestResultGenerator.createResult("文件上传失败", ResponseEnum.UPLOAD_ERROR.getVal()));
        }*/
        return JSON.toJSONString(RestResultGenerator.createResult("文件上传成功", ResponseEnum.SUCCESS.getVal()));
    }
}
