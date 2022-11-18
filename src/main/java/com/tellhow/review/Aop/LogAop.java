package com.tellhow.review.Aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author wujianghao
 * @date 2022年11月18日 17:22
 * 切面日志类
 */
@Component
@Slf4j
@EnableAspectJAutoProxy
public class LogAop {

    public void pointcut(){}

    @Before("")
    public void testbefore() {

    }
}
