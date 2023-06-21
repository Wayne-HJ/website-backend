package com.wayne.blog.strategy.impl;

import com.alibaba.fastjson.JSON;
import com.wayne.blog.exception.BizException;
import com.wayne.blog.strategy.UploadStrategy;
import com.wayne.blog.util.FileUtils;
import com.wayne.blog.util.HttpClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * 抽象上传模板
 *
 * @author wayne
 * @date 2021/07/28
 */
@Service
public abstract class AbstractUploadStrategyImpl implements UploadStrategy {

    @Override
    public String uploadFile(MultipartFile file, String path, String type) {
        try {
            // 获取文件md5值
            String md5 = FileUtils.getMd5(file.getInputStream());
            // 获取文件扩展名
            String extName = FileUtils.getExtName(file.getOriginalFilename());
            // 重新生成文件名
            String fileName = md5 + extName;
            if (type.contains("minio")){
                // 判断文件是否已存在
                if (!exists(path+fileName)) {
                    upload(path, fileName, file);
                }
            }else {
                // 判断文件是否已存在
                if (!exists(path + fileName)) {
                    // 不存在则继续上传
                    upload(path, fileName, file.getInputStream());
                }

            }
            // 返回文件访问路径
            String fileAccessUrl = getFileAccessUrl(path + fileName);
            if (fileAccessUrl.contains("false") || fileAccessUrl.contains("true")){
                Map jsonMap =JSON.parseObject(fileAccessUrl);
                if (jsonMap.get("success").toString().equals("true")){
                    String result = jsonMap.get("result").toString();
                    String[] split = result.split("]");
                    result = split[0].substring(1).replace("\"","");
                    return result;

                }else {
                    throw new BizException("文件上传失败");
                }


            }else {
                return fileAccessUrl;

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("文件上传失败");
        }
    }

    @Override
    public String uploadFile(String fileName, InputStream inputStream, String path) {
        try {
            // 上传文件
            upload(path, fileName, inputStream);
            // 返回文件访问路径
            return getFileAccessUrl(path + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("文件上传失败");
        }
    }

    /**
     * 判断文件是否存在
     *
     * @param filePath 文件路径
     * @return {@link Boolean}
     */
    public abstract Boolean exists(String filePath);

    /**
     * 上传
     *
     * @param path        路径
     * @param fileName    文件名
     * @param inputStream 输入流
     * @throws IOException io异常
     */
    public abstract void upload(String path, String fileName, InputStream inputStream) throws IOException;
    /**
     * 上传
     *
     * @param path        路径
     * @param fileName    文件名
     * @param file        文件
     * @throws IOException io异常
     */
    public abstract void upload(String path, String fileName, MultipartFile file) throws IOException;

    /**
     * 获取文件访问url
     *
     * @param filePath 文件路径
     * @return {@link String}
     */
    public abstract String getFileAccessUrl(String filePath);

}
