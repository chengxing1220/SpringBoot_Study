package com.tellhow.review.common.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PersonPojo {
    private String personName;//人名
    private String uintedName;//所属的门派

    public PersonPojo(String personName, String uintedName) {
       log.info("通过有参构造创建人物对象");
        this.personName = personName;
        this.uintedName = uintedName;
    }

    public PersonPojo() {
        log.info("通过无参构造创建人物对象");
    }
}
