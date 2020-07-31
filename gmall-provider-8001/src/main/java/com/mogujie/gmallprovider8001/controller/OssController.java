package com.mogujie.gmallprovider8001.controller;

import com.alibaba.fastjson.JSON;
import com.mogujie.gmallprovider8001.enums.ResponseEnum;
import com.mogujie.gmallprovider8001.service.OssOperatorDaoImpl;
import com.mogujie.gmallprovider8001.utils.MutipartFileToFile;
import com.mogujie.gmallprovider8001.utils.OSSUploadUtils;
import com.mogujie.gmallprovider8001.utils.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author WN
 * @date 2020/7/30 14:36
 */
@RestController
public class OssController {

    @Autowired
    private OssOperatorDaoImpl operatorDao;

    @RequestMapping("/upload")
    public String upload(@RequestParam("imgFiles") MultipartFile imgFile) throws IOException {
        if (imgFile == null) {
            return "error";
        }
        File file = MutipartFileToFile.mutipartFileToFile(imgFile);
        return OSSUploadUtils.upload(file);
    }

    @RequestMapping("/upload/operator")
    public String uploadOperator(@RequestParam("imgFiles") MultipartFile imgFiles) {
        //http://java4all-file-oos.oss-cn-beijing.aliyuncs.com/blog1596163301725.jpg?Expires=1911523302&OSSAccessKey
        //Id=LTAI4Ff8KHCLHakno99akbZt&Signature=vpW57%2BesLwaCQYqpgWEq516Nogw%3D
        if (imgFiles == null) {
            return JSON.toJSONString(new RestResultGenerator("文件为空，请重新传输", ResponseEnum.PARAM_ERROR.getVal()));
        }
        return operatorDao.upload(imgFiles);
    }

    @RequestMapping("/upload/muchoperator")
    public String uploadOperatorMuch(@RequestParam("imgFiles") List<MultipartFile> imgFiles) {
        if (imgFiles.size()==0){
            return JSON.toJSONString(new RestResultGenerator("没有文件",ResponseEnum.PARAM_ERROR.getVal()));
        }
        return operatorDao.uploadFiles(imgFiles);
    }

}
