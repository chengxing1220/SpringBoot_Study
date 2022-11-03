package com.tellhow.review.spring_annotation.beanaddcontainer.config;

import com.tellhow.review.common.factory.MyFactoryBean;
import com.tellhow.review.common.pojo.UnitedPojo;
import com.tellhow.review.spring_annotation.beanaddcontainer.filter.MyTypeFilter;
import com.tellhow.review.common.pojo.AvenueBranchPojo;
import com.tellhow.review.common.pojo.WorldPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author wujianghao
 * @date 2022年10月27日 16:25
 */

/**
 * @Configuration注解用来标识这是一个配置类 proxyBeanMethods属性是用来设置MyConfig配置类是否被代理。
 * true的话通过调用MyConfig方法获取对象时(非从容器中取)，每次取出来的都是同一个。
 * false的话通过调用MyConfig方法获取对象时(非从容器中取)，每次取出来的都不是同一个。
 * 当配置类的中的bean之间存在依赖关系时，用proxyBeanMethods设置为true,没依赖关系设置为false
 */
@Configuration(proxyBeanMethods = true)
@Slf4j
/**
 * @ComponentScan注解包扫描，会将指定包下标注了@Component、@Controller、@Service、@Resposity的组件加载到容器中去
 * basePackages属性：指定要扫描的包
 * useDefaultFilters:是否使用默认的过滤器，默认是true。想自己指定过滤规则时要将该属性设置为false
 * includeFilters属性：指定满足被扫描的包下的组件要满足哪些条件才能被加到容器中，它是一个@Filter集合
 *                    @Filter过滤注解。它的常用属性如下：
 *                    1、type属性指定根据什么过滤 1）FilterType.ANNOTATION根据注解类型过滤
 *                                            2）FilterType.ASSIGNABLE_TYPE根据组件的类型过滤
 *                                            3）FilterType.ASPECTJ根据ASPECTJ表达式过滤
 *                                            4）FilterType.REGEX根据正则表达式过滤(基本不用、我也不太会)
 *                                            5）FilterType.CUSTOM自定义过滤规则
 */
@ComponentScan(basePackages ={ "com.tellhow.review.spring_annotation"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})})
@Import(value = {UnitedPojo.class,MyImportSector.class,MyImportBeanDefinitionRegistrar.class})
public class MyConfig {
    /**
     *
     * ConfigurableBeanFactory.SCOPE_PROTOTYPE//多例模式(每次从容器中获取的对象都不是相同的)，在调用该对象时，才会创建对象
     * ConfigurableBeanFactory.SCOPE_SINGLETON //单例模式(每次从容器中获取的对象都是相同的),项目在开始运行的时侯，就会创建对象
     * org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST//同一个请求域下(不用该作用域)
     * org.springframework.web.context.WebApplicationContext.SCOPE_SESSION//同一个Session下(不用该作用域)
     */
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)//多例模式
    @Bean("worldPojo")
    public WorldPojo worldPojo() {
        log.info("--------传武世界WorldPojo(多例)对象开始创建---------");
        WorldPojo worldPojo = new WorldPojo();
        worldPojo.setName("传武世界");
        return worldPojo;
    }

    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)//多例模式
    @Bean("myFactoryBean")
    public MyFactoryBean myFactoryBean() {
        log.info("--------传武世界myFactoryBean(多例)对象开始创建---------");
        MyFactoryBean myFactoryBean = new MyFactoryBean();
        return myFactoryBean;
    }

    @Lazy//懒加载，在单例模式下，项目开始运行就调用下面的方法并创建出该对象。我们想在用到该对象才创建，只需要加一个@Lazy注解
    @Bean("creationBranch")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//这个bean的作用域
    @Conditional(value = {MyCondition.class})//条件装配注解
    public AvenueBranchPojo creationBranch() {
        log.info("----------万物道AvenueBranchPojo单例对象开始创建(懒加载)----------");
        return new AvenueBranchPojo();
    }



    @Lazy
    @Bean("spiritsBranch")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)//作用域
    public AvenueBranchPojo spiritsBranch() {
        log.info("---------鬼神道avenueBranchPojo单例对象开始创建----------");
        return new AvenueBranchPojo();
    }

}
