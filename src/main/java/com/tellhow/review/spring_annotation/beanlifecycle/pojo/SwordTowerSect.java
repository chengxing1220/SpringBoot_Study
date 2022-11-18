package com.tellhow.review.spring_annotation.beanlifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author wujianghao
 * @date 2022年11月09日 9:33
 *        剑楼
 */
@Slf4j
@Component
public class SwordTowerSect implements DisposableBean ,InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {//创建对象以后，进行初始化
        log.info("招剑楼弟子");
    }
    @Override
    public void destroy() throws Exception {    //容器销毁之前调用此方法
        log.info("剑楼被灭");
    }

    public SwordTowerSect() {
        log.info("创建剑楼");
    }
}
