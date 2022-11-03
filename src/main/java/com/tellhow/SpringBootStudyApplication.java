package com.tellhow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

//scanBasePackages属性:指定包扫描路径
//exclude属性:如果发现不需要的特定自动配置类正在被应用可以使用@SpringBootApplication的exclude属性属性来禁用它们
@SpringBootApplication(scanBasePackages = {"com.tellhow"})
@Slf4j//日志系统采用  slf4j+logback
public class SpringBootStudyApplication {
    public static void main(String[] args) {
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
        String runName = ManagementFactory.getRuntimeMXBean().getName();
        log.info("\n--------------------------------------------------------------------------------------------------------------------------------------\n" +
                "\t项目访问网址: http://" + ip + ":" + port + path + "\n" +
                "\tRuntimeMXBean object for the Java virtual machine is(项目在虚拟机运行的进程为):" + runName +
                "\n----------------------------------------------------------------------------------------------------------------------------------------");
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info(beanDefinitionName);
        }
    }


}
