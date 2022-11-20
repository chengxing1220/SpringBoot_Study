package com.tellhow.review.Aop;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wujianghao
 * @date 2022年11月18日 17:22
 * 切面日志类
 *
 * 使用Aop增强步骤。
 * 1、导入切面包--》spring-aspects
 * 2、编写切面类和逻辑类
 * 3、在切面类通过切入点表达式，指定对逻辑类什么方法增强。并给切面类标注@Aspect注解，说明它是一个切面类
 * 4、在配置类上使用@EnableAspectJAutoProxy注解开启对注解版切面的支持（开启切面代理支持，切面的底层是代理）
 *
 *
 *    */
@Component
@Slf4j
@Aspect//告诉spring这是一个切面类
public class LogAop {

    /**
     * 切入点表达式格式：    访问修饰符(可省略)  返回值类型 方法的类路径.方法名(参数类1,参数类型2)
     */
    @Pointcut("execution(public * com.tellhow.review.Aop.Function.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")//目标方法执行之前通知
    public void testbefore() {
        log.info("前置通知,去青罗司接任务" );
    }
    @After("com.tellhow.review.Aop.LogAop.pointcut()")
    public void testAfter(){
        log.info("后置通知"+"任务完成，通知青罗司验收");
    }

    /**
     * 发生异常，走异常通知后也会走后置通知
     * @AfterReturning的属性信息 1、value指定切入点表达式。2、returning将目标方法的返回值与通知方法的参数绑定
     * @param joinPoint 切入点信息（包括方法名、参数等信息）
     */
    @AfterReturning(value = "execution(public * com.tellhow.review.Aop.Function.GhostInfestation(String,String))",returning = "result")//返回通知
    public void testReturn(JoinPoint joinPoint,String result){
        String name = joinPoint.getSignature().getName();//获取方法名
        log.info("返回通知"+"返回值是:"+result);
    }

    /**
     * JoinPoint一定要放参数表的第一位
     * @AfterThrowing的 value属性指定切入点表达式 throwing属性将抛出的异常绑定到的通知签名中的参数的名称
     * @param exception
     */
    @AfterThrowing(value="pointcut()",throwing = "exception")//异常通知
    public void testException(JoinPoint joinPoint,Exception exception){
        log.info("异常通知");
    }

    /**
     *
     * @param proceedingJoinPoint procedingjoinpoint公开proceed(..)方法，以支持@AspectJ方面的around通知,proceedingJoinPoint.proceed(args)可以修改参数的值
     * @throws Throwable
     */
    @Around(value="pointcut()")
    public void testAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("前置环绕通知");
        Object[] args = proceedingJoinPoint.getArgs();
        proceedingJoinPoint.proceed(args);
        log.info("后置环绕通知");
    }
}
