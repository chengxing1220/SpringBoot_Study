package com.tellhow.review.spring_annotation.di.controller;

import com.tellhow.review.spring_annotation.di.service.DynastyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * 一、组件注入之属性注入
 * 组件之间相互存在依赖关系，将被依赖的组件注入到组件属性的方式
 * 1、使用@Autowired注解。这种注入方式是spring的方式
 * 1）将@Autowired注解标注在属性中，Spring容器在启动时会看容器中是不是有这个类型的属性，有的话就将它注入到属性中。
 * 2）如果容器中有多个这种类型的组件。那么接下来会根据属性的名字注入【将属性名当组件名】。要想指定组件注入的优先级，只需要在将bean作为组件注入到容器时在bean加@Primary注解，
 * 加上这个注解以后在进行属性注入时这个组件就会比同类型的组件优先注入
 * 3）容器中不存在这样的组件就会报错，要想不报错。可以使用@Autowired注解的required属性，将required设置为false。例如：@Autowired(required=false)
 * 4）@Autowired注解还可以与@Qualifier连用，可以根据组件名注入到属性中
 * 5）@Autowired还可以放在方法上，容器创建当前对象时，就会调用方法，完成赋值
 * 2、使用@Resource。这种是jdk自带的方法
 * 1）可以通过name属性指定组件名字注入
 * 2）不能和@Primary一起用。指定组件注册的优先级
 * 3、使用 @Inject注解。第三方需要导入外部依赖
 * 1）能和@Primary一起用。指定组件注册的优先级
 * 2）不能指定组件名称注入
 */


@Controller
@Slf4j
public class DynastyController {

    private DynastyService dynastyService;

    public DynastyService getDynastyService() {
        return this.dynastyService;
    }

   // @Autowired 放有参构造器上只有一个有参构造时，构造器的参数也是从容器中获取的
    public DynastyController(DynastyService dynastyService) {
        log.info("DynastyService"+"有参构造");
        this.dynastyService = dynastyService;
    }

    // @Autowired
    public void setDynastyService(DynastyService dynastyService) {
        this.dynastyService = dynastyService;
    }
}
