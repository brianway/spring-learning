package com.brianway.learning.spring.ioc.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 基于注解的Boss类
 */
@Component
public class Boss {

    private Car car;

    public Boss() {
        System.out.println("construct...");
    }

//	@Autowired
//	private void setCar(Car car){
//		System.out.println("execute in setCar");
//		this.car = car;
//	}

    @Resource
    private void setCar(Car car) {
        System.out.println("execute in setCar");
        this.car = car;
    }

    @PostConstruct
    private void init1() {
        System.out.println("execute in init1");
    }

    @PostConstruct
    private void init2() {
        System.out.println("execute in init1");
    }

    @PreDestroy
    private void destory1() {
        System.out.println("execute in destory1");
    }

    @PreDestroy
    private void destory2() {
        System.out.println("execute in destory2");
    }

}
