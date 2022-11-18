package com.tellhow.review.spring_annotation.di.pojo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author wujianghao
 * @date 2022年11月18日 9:28
 * 武器类
 */
@Component("ghost")
@Profile("test")
@Primary
public class SkillPojo {
    private String name="以身饲鬼术";//武器名称
    private String type="召唤类";//武器功能

    @Override
    public String toString() {
        return "SkillPojo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
