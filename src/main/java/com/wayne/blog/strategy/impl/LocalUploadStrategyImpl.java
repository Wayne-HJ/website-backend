package com.wayne.blog.strategy.impl;

import com.alibaba.fastjson.JSON;
import com.wayne.blog.enums.FileExtEnum;
import com.wayne.blog.exception.BizException;
import com.wayne.blog.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 本地上传策略
 *
 * @author wayne
 * @date 2021/07/28
 */
@Service("localUploadStrategyImpl")
public class LocalUploadStrategyImpl extends AbstractUploadStrategyImpl {

    /**
     * 本地路径
     */
    @Value("${upload.local.path}")
    private String localPath;

    /**
     * 访问url
     */
    @Value("${upload.local.url}")
    private String localUrl;

    /**
     * 图床API地址
     */
    @Value("${upload.local.picBedAPI}")
    private String picBedAPI;
    /**
     * 是否上传图床标识
     */
    @Value("${upload.local.isPicBed}")
    private Boolean isPicBed;
    /**
     * 图床图片地址
     */
    private String filePath;

    @Override
    public Boolean exists(String filePath) {
        return new File(localPath + filePath).exists();
    }

    @Override
    public void upload(String path, String fileName, InputStream inputStream) throws IOException {
        // 判断目录是否存在
        File directory = new File(localPath + path);
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new BizException("创建目录失败");
            }
        }
        // 写入文件
        File file = new File(localPath + path + fileName);
        String ext = "." + fileName.split("\\.")[1];
        switch (Objects.requireNonNull(FileExtEnum.getFileExt(ext))) {
            case MD:
            case TXT:
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                while (reader.ready()) {
                    writer.write((char) reader.read());
                }
                writer.flush();
                writer.close();
                reader.close();
                break;
            default:
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(file.toPath()));
                byte[] bytes = new byte[1024];
                int length;
                while ((length = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, length);
                }
                bos.flush();
                bos.close();
                bis.close();
                break;
        }
        if (isPicBed){
            String filePath = localPath+path+fileName;
            //图片存入图床
            HashMap<String, List<String>> map = new HashMap<>();
            map.put("list",new ArrayList<String>());
            map.get("list").add(filePath);
            String postJson = HttpClientUtil.doPostJson(picBedAPI, JSON.toJSONString(map));
            if (postJson.contains("false")){
                this.filePath = null;
            }else {
                this.filePath = postJson;
            }
        //    删除本地存储照片
            File deleteFile = new File(filePath);
            deleteFile.delete();
        }

        inputStream.close();
    }

    @Override
    public void upload(String path, String fileName, MultipartFile file) throws IOException {

    }


    @Override
    public String getFileAccessUrl(String filePath) {
        if (this.filePath!=null){
            return this.filePath;
        }else {
            return localUrl + filePath;
        }
    }


}
