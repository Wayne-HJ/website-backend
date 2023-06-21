package com.wayne.blog;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 博客启动类
 *
 * @author wayne
 * @date 2021/08/14
 */
@MapperScan("com.wayne.blog.dao")
@Slf4j
@SpringBootApplication
@EnableScheduling
public class BlogApplication {

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("start-------------");

        ConfigurableApplicationContext application = SpringApplication.run(BlogApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application blog is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port  + "/\n\t" +
                "External: \thttp://" + ip + ":" + port  + "/\n\t" +
                "api-doc: \thttp://" + ip + ":" + port  + "/doc.html\n\t" +
                 "\n-----------页面请部署blog-vue项目----------------------------");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
