package com.mogujie.gmallprovider8001.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static com.mogujie.gmallprovider8001.configuration.ConstantProperties.*;

/**
 * OSS 上传文件 并获取url
 * @author WN
 * @date 2020/7/30 13:56
 * @version 1.0
 */

@Component
public class OSSUploadUtils {
    private static Logger logger = LoggerFactory.getLogger(OSSUploadUtils.class);

    private static String endPoint;
    private static String keyid;
    private static String keysecret;
    private static String filehost;
    private static String bucketname;
    private static OSSClient ossClient;

    static {
        endPoint = JAVA4ALL_END_POINT;
        keyid = JAVA4ALL_ACCESS_KEY_ID;
        keysecret = JAVA4ALL_ACCESS_KEY_SECRET;
        filehost = JAVA4ALL_FILE_HOST;
        bucketname = JAVA4ALL_BUCKET_NAME1;
        ossClient = new OSSClient(endPoint, keyid, keysecret);
    }
//    /**
//     * 初始化 ossClient
//     */
//    public static void init() {
//        endPoint = JAVA4ALL_END_POINT;
//        keyid = JAVA4ALL_ACCESS_KEY_ID;
//        keysecret = JAVA4ALL_ACCESS_KEY_SECRET;
//        filehost = JAVA4ALL_FILE_HOST;
//        bucketname = JAVA4ALL_BUCKET_NAME1;
//        ossClient = new OSSClient(endPoint, keyid, keysecret);
//    }

    /**
     *<p>
     *     静态upload方法，用来上传文件并获取url
     *</p>
     *
     * @param file 文件流从网站上传输的就是File 类型
     * @return java.lang.String
     */
    public static String upload(File file) {
        /// OSSUploadUtils.init();
        try {
            //容器不存在，就创建
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = dateFormat.format(new Date());
            if (!ossClient.doesBucketExist(bucketname)) {
                ossClient.createBucket(bucketname);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketname);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = filehost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketname, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);
            if (null != result) {
                logger.info("==========>OSS文件上传成功,OSS地址：" + fileUrl);
                String imgUrl = "https://"+bucketname+"."+"oss-cn-beijing.aliyuncs.com"+"/"+fileUrl;
                return imgUrl;
            }
        } catch (OSSException oe) {
            logger.error(oe.getMessage());
        } catch (ClientException ce) {
            logger.error(ce.getMessage());
        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }

}
