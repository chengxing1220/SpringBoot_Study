package com.tellhow.review.spring_annotation.lifecycle.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

//天灾
@Slf4j
public class NaturalDisasterPojo {

    private String name;

    public void init(){
        log.info(name+"选择修习道路，并修炼成天灾");
    }

    public NaturalDisasterPojo() {
        log.info("天灾坑位留出");
    }



    public void destory(){
        log.info(name+"陨落");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
