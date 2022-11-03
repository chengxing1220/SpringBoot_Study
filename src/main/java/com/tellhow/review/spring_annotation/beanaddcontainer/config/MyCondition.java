package com.tellhow.review.spring_annotation.beanaddcontainer.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 自定义条件装配
 *
 * @author wujianghao
 * @date 2022年10月28日 17:45
 */
public class MyCondition implements Condition {
    /**
     *
     * @param context 环境条件
     * @param metadata 被检查的类的方法或元数据
     * @return 是否满足匹配条件
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getRegistry().containsBeanDefinition("worldPojo")?true:false;
    }
}
