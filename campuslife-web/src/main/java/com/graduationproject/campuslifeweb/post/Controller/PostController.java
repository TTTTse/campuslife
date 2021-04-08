package com.graduationproject.campuslifeweb.post.Controller;

import com.graduationproject.campuslifecommon.constant.TencentCosConfig;
import com.graduationproject.campuslifecommon.constant.TencentCosProperties4Pic;
import com.graduationproject.campuslifecommon.response.ResponseResult;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-04-08 01:02
 **/
@RestController
@RequestMapping("post")
public class PostController {

    @Resource
    private TencentCosProperties4Pic tencentCosProperties4Pic;

    @Resource
    private TencentCosConfig tencentCosConfig;

    @Resource
    @Qualifier(TencentCosConfig.COS_IMAGE)
    private COSClient cosClient4Picture;

    @PostMapping(value = "upload")
    public ResponseResult uploadPic(@RequestParam("file") MultipartFile multipartFile) {
        if (multipartFile == null) {
            return ResponseResult.builder().data(null).build();
        }
        File localFile = null;
        String originalFilename = multipartFile.getOriginalFilename();
        String[] filename = originalFilename.split("\\.");
        try {
            localFile=File.createTempFile(filename[0], filename[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            multipartFile.transferTo(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        localFile.deleteOnExit();
        String bucketName = tencentCosProperties4Pic.getBucketName()+tencentCosProperties4Pic.getAppId();
        String key = "postResources/"+new Date().getTime() + ".png";
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上的路径
        COSClient cosClient = tencentCosConfig.getCoSClient4Picture();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);

        return ResponseResult.builder().data(url).build();
    }
}
