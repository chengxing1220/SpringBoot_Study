package com.tellhow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j//日志系统采用  slf4j+logback
public class SpringBootStudyApplication {
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStudyApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String ip = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostAddress();
        } catch (UnknownHostException e) {
            log.error("获取本机地址失败");
            log.error(e.getLocalizedMessage());
        }
        String port = environment.getProperty("server.port");//端口号
        String path = environment.getProperty("server.servlet.context-path");//项目路径
        log.info("项目访问路径为:" + ip + ":" + port + path);
    }

}
