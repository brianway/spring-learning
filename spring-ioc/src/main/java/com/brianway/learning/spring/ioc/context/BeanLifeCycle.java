package com.brianway.learning.spring.ioc.context;

import com.brianway.learning.spring.ioc.beanfactory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Brian on 2016/5/13.
 * 该类装载的Bean的xml配置文件: com/brianway/learning/spring/ioc/context/beans-singleton.xml
 * 自动识别和注册 MyBeanFactoryPostProcessor 和 MyBeanPostProcessor,并应用到上下文
 */
public class BeanLifeCycle {
    public static void lifeCycleInApplicationContext(String xmlPath, String beanId) {
        //装载配置文件并启动容器
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        //第一次从容器中获取car，将触发容器实例化该Bean,这将引发Bean生命周期方法调用
        Car car1 = (Car) context.getBean(beanId);
        car1.introduce();
        car1.setColor("红色");

        System.out.println("第二次从容器中获取car");
        //第二次从容器中获取car
        Car car2 = (Car) context.getBean(beanId);
        car2.introduce();
        System.out.println("car1==car2：" + (car1 == car2));

    }

}

/*
#log4j.rootLogger=DEBUG, stdout
log4j.rootLogger=INFO, stdout
输出：
调用BeanFactoryPostProcessor.postProcessBeanFactory()
调用Car()构造函数
调用setBrand()设置属性
调用BeanNameAware.setBeanName()
调用BeanFactoryAware.setBeanFactory()
调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黄色
调用InitializingBean.afterPropertiesSet()
调用init-method指定的myInit()，将maxSpeed设置为240
调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为100
brand:奇瑞QQ;color:黄色;maxSpeed:100
brand:奇瑞QQ;color:红色;maxSpeed:100
car1==car2：true
 */
