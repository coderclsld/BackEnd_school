package com.school.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author ZKJ
 * @create 2021-03-14 21:35
 */
public class UploadFIleToOss {

    public static String  uploadFileToOss(String endpoint, String accessKeyId, String accessKeySecret,
                                          InputStream inputStream, String bucketName, String bucketDomain, String originalName) {

        // 创建 OSSClient 实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 生成上传文件的目录(当天上传的文件目录)
        String folderName = new SimpleDateFormat("yyyyMMdd").format(new Date());

        // 生成上传文件在 OSS 服务器上保存时的文件名  为什么不用一个文件名 同个文件上传多次会把会覆盖
        // 原始文件名：beautfulgirl.jpg
        // 生成文件名：wer234234efwer235346457dfswet346235.jpg
        // 使用 UUID 生成文件主体名称
        String fileMainName = UUID.randomUUID().toString().replace("-", "");

        // 从原始文件名中获取文件扩展名
        String extensionName = originalName.substring(originalName.lastIndexOf("."));
        // 使用目录、文件主体名称、文件扩展名称拼接得到对象名称
        String objectName = folderName + "/" + fileMainName + extensionName;

        try {
            // 调用 OSS 客户端对象的方法上传文件并获取响应结果数据
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, objectName,inputStream);

            // 从响应结果中获取具体响应消息
            ResponseMessage responseMessage = putObjectResult.getResponse();

            // 根据响应状态码判断请求是否成功
            if(responseMessage == null) {
                // 拼接访问刚刚上传的文件的路径
                String ossFileAccessPath = bucketDomain + "/" + objectName;
                // 当前方法返回成功
                return ossFileAccessPath;
            } else {
                // 获取响应状态码
                int statusCode = responseMessage.getStatusCode();
                // 如果请求没有成功，获取错误消息
                String errorMessage = responseMessage.getErrorResponseAsString();
                // 当前方法返回失败
                return " 当 前 响 应 状 态 码 ="+statusCode+" 错 误 消 息="+errorMessage;
            }

        } catch (Exception e) {
            e.printStackTrace();
            // 当前方法返回失败
            return e.getMessage();
        } finally {
            if(ossClient != null) {
                // 关闭 OSSClient。
                ossClient.shutdown();
            }
        }
    }

}
