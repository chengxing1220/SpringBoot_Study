package com.tellhow.review.common.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//门派
@Data
@Slf4j
public class UnitedPojo {
    private String name;//门派名字
    private String avenueId;//门派修习道的编号

    public UnitedPojo() {
        log.info("通过无参构造创建门派");
    }

    public UnitedPojo(String name, String avenueId) {
        log.info("通过有参构造创建门派");
        this.name = name;
        this.avenueId = avenueId;
    }
}
