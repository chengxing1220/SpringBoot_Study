package com.tellhow.review.spring_annotation.di.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author wujianghao
 * @date 2022年11月18日 9:26
 * 人物类
 * <p>
 * 将容器的组件注入到javaBean的属性中
 * 1、属性注入
 * 1)、spring提供的方式
 * a、将@Autowired注解放到JavaBean对应类的属性上，该属性的值会在JavaBean对应类创建实例之前，去看容器中是不是存在属性对应类型的组件，有的话就从容器中取，并给该属性注入。
 * 如果不存在就报错，要想没有不报错，可以使用@Autowired的一个属性require=false。如果容器中存在多个同类型的组件，那么就会根据属性的名字去匹配。
 * b、@Autowired还可以与@Qualifier的注解联用。通过@Qualifier的value,直接根据组件的名称去注入
 * c、@Autowired还可以适配@Primary注解，在按类型注入时，优先注入被@Primary修饰的属性
 * 2)、jdk提供的方式
 * 使用@Resource，可以通过name属性按照组件的名称注入。不适配@Primary注解
 * 3)、第三方提供的方式，要先导jar包
 * 使用@Inject,适配@Primary
 * 可以与@Qualifier的注解联用。通过@Qualifier的value,直接根据组件的名称去注入
 * 2、方法注入
 * 将@Autowired方法标在方法上，方法的参数就会去Spring容器中去取。
 * 若类只有一个有参构造，有参构造的参数值默认会从容器中去取
 */
@Component("qinglong")
@Profile("test")
@Primary
public class PersonPojo {
    private String title = "青龙";//称号
    private String name = "宁仲";//真实姓名
    //@Resource
    //@Inject
    //@Qualifier("ghost")
    @Autowired
    private SkillPojo skillPojo;//武器类

    @Override
    public String toString() {
        return "PersonPojo{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", skillPojo=" + skillPojo +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillPojo getSkillPojo() {
        return skillPojo;
    }

    // @Autowired
    public void setSkillPojo(SkillPojo skillPojo) {
        this.skillPojo = skillPojo;
    }


    //类只有一个有参构造器时，构造器的参数值从容器中获取
  /*
  public PersonPojo(SkillPojo skillPojo) {
        this.skillPojo = skillPojo;
        this.name=name;
    }
    */

    public PersonPojo() {
    }
}
