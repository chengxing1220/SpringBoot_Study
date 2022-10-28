package com.tellhow.review.spring_annotation.filter;

import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * @author wujianghao
 * @date 2022年10月28日 10:30
 */
//自定义类型过滤器
public class MyTypeFilter implements TypeFilter {
    /**
     * 确定此筛选器是否与给定元数据所描述的类匹配。
     * @param metadataReader 目标类(被扫描类扫描的类)的元数据读取器
     * @param metadataReaderFactory 为其他类(如超类和接口)获取元数据读取器的工厂
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        if (classMetadata.getClassName().contains("Service")){//如果被加到容器中的类名包括Service，就不添加到容器中
            return false;
        }
        return true;
    }
}
