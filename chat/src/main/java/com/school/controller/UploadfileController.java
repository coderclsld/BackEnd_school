package com.school.controller;

import com.school.config.OSSProperties;
import com.school.util.UploadFIleToOss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ZKJ
 * @create 2021-03-14 21:15
 */
@Controller
public class UploadfileController {

    @Autowired
    private OSSProperties ossProperties;

    @ResponseBody
    @RequestMapping("/create/upload/return/picture.json")
    public String uploadReturnPicture( @RequestParam("file") MultipartFile returnPicture,@RequestParam("user") String user) throws IOException {

        System.out.println("用户{"+user+"}上传了图片......");
        System.out.println("我被执行。。。。");
        // 1.执行文件上传
        String uploadReturnPicResultEntity = UploadFIleToOss.uploadFileToOss(
                ossProperties.getEndPoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret(), returnPicture.getInputStream(), ossProperties.getBucketName(), ossProperties.getBucketDomain(), returnPicture.getOriginalFilename());
        // 2.返回上传的结果
        return uploadReturnPicResultEntity;
    }
}
