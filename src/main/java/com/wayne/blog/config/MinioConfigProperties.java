package com.wayne.blog.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio配置属性
 *
 * @author wayne
 * @date 2021/07/28
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "upload.minio")
public class MinioConfigProperties {
    /**
     * 访问路径前缀
     */
    private String url;
    /**
     * minio域名
     */
    private String endpoint;

    /**
     * 访问密钥id
     */
    private String accessKeyId;

    /**
     * 访问密钥密码
     */
    private String accessKeySecret;

    /**
     * bucket名称
     */
    private String bucketName;
    @Bean
    public MinioClient minioClient()  {
        MinioClient build = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKeyId, accessKeySecret)
                .build();
        return build;
    }

}
