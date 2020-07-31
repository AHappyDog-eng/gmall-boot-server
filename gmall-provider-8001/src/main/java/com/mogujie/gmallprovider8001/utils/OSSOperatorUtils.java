package com.mogujie.gmallprovider8001.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author WN
 * @date 2020/7/30 16:15
 */

@PropertySource("classpath:ProperConfig/OSSProperties.properties")
@Component
public class OSSOperatorUtils {
    @Value("${java4all.file.endpoint}")
    private String endpoint;

    @Value("${java4all.file.keyid}")
    private String accessKeyId;

    @Value("${java4all.file.keysecret}")
    private String accessKeySecret;

    @Value("${java4all.file.filehost}")
    private String filedir;

    @Value("${java4all.file.bucketname1}")
    private String bucketName;


    private Logger log = LoggerFactory.getLogger(OSSOperatorUtils.class);

    public String uploadImg2Oss(MultipartFile file) {
        // 判断 图片的大小如果太大了 直接放弃操作
        if (file.getSize() > 1024 * 1024 * 20) {
            /// RestResultGenerator.createErrorResult(ResponseEnum.PHOTO_TOO_MAX);
            return "图片太大";
        }
        // 或得文件名称
        String originalFilename = file.getOriginalFilename();
        // 把文件名称做进一步的处理
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        // 构建随机名称
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            // 获取文件输入流
            InputStream inputStream = file.getInputStream();
            /// RestResultGenerator.createSuccessResult(name);
            // 调用方法上传
            return this.uploadFile2OSS(inputStream, name);
        } catch (Exception e) {
            /// RestResultGenerator.createErrorResult(ResponseEnum.PHOTO_UPLOAD);
            return "上传失败";
        }
    }

    /**
     * 上传图片获取fileUrl
     *
     * @param instream
     * @param fileName
     * @return
     */
    private String uploadFile2OSS(InputStream instream, String fileName) throws IOException {
        String ret = "";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // 获取当前时间点 如果容器不存在就直接创建
            String dateStr = format.format(new Date());
            if (!ossClient.doesBucketExist(bucketName)) {
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }

            // 创建上传Object的Metadata 设置一些上传对象类的参数
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            String fileUrl = filedir + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + fileName);
            //上传文件 /blog/2020-07-31/db400c62c66e47cf8524f2e983521d0f-1596164287088.jpg
            PutObjectResult putResult = ossClient.putObject(bucketName, fileUrl, instream, objectMetadata);
            ret = fileUrl;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public static String getcontentType(String fileNameExtension) {
        String bmp = ".bmp";
        String gif = ".gif";
        String jpg = ".jpg";
        String jpeg = ".jpeg";
        String png = ".png";
        String html = ".html";
        String txt = ".txt";
        String vsd = ".vsd";
        String pptx = ".pptx";
        String ppt = ".ppt";
        String xls = ".xls";
        String xlsx = ".xlsx";
        String docx = ".docx";
        String doc = ".doc";
        String xml = ".xml";
        if (bmp.equalsIgnoreCase(fileNameExtension)) {
            return "image/bmp";
        }

        if (gif.equalsIgnoreCase(fileNameExtension)) {
            return "image/gif";
        }

        if (jpeg.equalsIgnoreCase(fileNameExtension) ||
                jpg.equalsIgnoreCase(fileNameExtension) ||
                png.equalsIgnoreCase(fileNameExtension)) {
            return "image/jpg";
        }
        if (html.equalsIgnoreCase(fileNameExtension)) {
            return "text/html";
        }
        if (txt.equalsIgnoreCase(fileNameExtension)) {
            return "text/plain";
        }
        if (vsd.equalsIgnoreCase(fileNameExtension)) {
            return "application/vnd.visio";
        }
        if (pptx.equalsIgnoreCase(fileNameExtension) ||
                ppt.equalsIgnoreCase(fileNameExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (xls.equalsIgnoreCase(fileNameExtension) ||
                xlsx.equalsIgnoreCase(fileNameExtension)) {
            return "application/vnd.ms-excel";
        }
        if (docx.equalsIgnoreCase(fileNameExtension) ||
                doc.equalsIgnoreCase(fileNameExtension)) {
            return "application/msword";
        }
        if (xml.equalsIgnoreCase(fileNameExtension)) {
            return "text/xml";
        }
        return "image/jpg";
    }

    /**
     * 获取图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        if (fileUrl != null) {
            String[] split = fileUrl.split("/");
            String url = this.getUrl(this.filedir + split[split.length - 1]);
            return url;
        }
        return null;
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return java.lang.String
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }
    /**
     * 获取文件地址
     *
     */
    public String getImgUrlByLocal(String fileEndName){
        String str = "http://java4all-file-oos.oss-cn-beijing.aliyuncs.com/"+fileEndName;
        return str;
    }

    /**
     * 多图片上传
     *
     * @param fileList
     * @return java.lang.String
     */
    public Map checkList(List<MultipartFile> fileList) {
        String fileUrl = "";
        String str = "";
        String photoUrl = "";
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < fileList.size(); i++) {
            fileUrl = uploadImg2Oss(fileList.get(i));
            log.info("上传数据成功"+i+"个图片"+"文件地址为： "+fileUrl);
            str = getImgUrl(fileUrl);
            map.put(i, str.trim());
        }
        return map;
    }

    /**
     * 单个图片上传
     *
     * @param file
     * @return java.lang.String
     */
    public String uploadImg(MultipartFile file) {

        String fileUrl = uploadImg2Oss(file);
        String str = getImgUrlByLocal(fileUrl);
        return str.trim();
    }
}
