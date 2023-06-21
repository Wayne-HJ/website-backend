package com.wayne.blog.strategy.impl;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wayne.blog.config.MinioConfigProperties;
import com.wayne.blog.util.MinioUtil;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.wayne.blog.util.MinioUtil.doesFolderExist;

/**
 * minio上传策略
 *
 * @author wayne
 * @date 2021/07/28
 */
@Service("minioUploadStrategyImpl")
public class MinioUploadStrategyImpl extends AbstractUploadStrategyImpl {
    @Autowired
    private MinioConfigProperties minioConfigProperties;

    /**
     * 查看存储bucket是否存在
     * @return boolean
     */
    @Override
    public Boolean exists(String filePath) {
        Boolean found = true;
        found = MinioUtil.doesObjectExist(minioConfigProperties.getBucketName(),filePath);
        //try {
        //    minioConfigProperties.minioClient().statObject(StatObjectArgs.builder().bucket(minioConfigProperties.getBucketName()).object(filePath).build());
        //} catch (Exception e) {
        //    return false;
        //}
        return found;
    }

    @Override
    public void upload(String path, String fileName, InputStream inputStream) throws IOException {

    }

    @Override
    public void upload(String path, String filename, MultipartFile file) {
        //new MinioUtil(minioConfigProperties.minioClient());
        try {
            //if (!MinioUtil.doesFolderExist(minioConfigProperties.getBucketName(),path)){
            ////    如果路径不存在创建路径
            //    MinioUtil.putDirObject(minioConfigProperties.getBucketName(),path);
            //}
            PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(minioConfigProperties.getBucketName()).object(path+filename)
                    .stream(file.getInputStream(), file.getSize(), -1).contentType(file.getContentType()).build();
            //文件名称相同会覆盖
            minioConfigProperties.minioClient().putObject(objectArgs);
        } catch (Exception e) {
            e.printStackTrace();
            //return null;
        }
        //return objectName;
    }

    /**
     * 预览
     * @param fileName
     * @return
     */
    @Override
    public String getFileAccessUrl(String fileName){
        // 查看文件地址
        //new GetPresignedObjectUrlArgs();
        //GetPresignedObjectUrlArgs build = GetPresignedObjectUrlArgs
        //        .builder()
        //        .bucket(minioConfigProperties.getBucketName())
        //        .object(fileName)
        //        .method(Method.GET)
        //        .build();
        //try {
        //    String url = minioConfigProperties.minioClient().getPresignedObjectUrl(build);
        //    return url;
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //return null;
        return minioConfigProperties.getUrl()+minioConfigProperties.getBucketName()+"/"+fileName;
    }

    /**
     * 获取minioClient
     *
     * @return {@link MinioClient} minioClient
     */
    //private MinioClient getMinioClient() {
    //    MinioClient build = MinioClient.builder()
    //            .endpoint(minioConfigProperties.getEndpoint())
    //            .credentials(minioConfigProperties.getAccessKeyId(), minioConfigProperties.getAccessKeySecret())
    //            .build();
    //    return build;
    //}


}
