package com.brianway.learning.spring.ioc.example;

/**
 * Created by Brian on 2016/5/12.
 */
public class Director {
    /**
     * 通过构造函数注入革离扮演者
     */
    public void directConstructor() {
        GeLi geli = new LiuDeHua();
        MoAttack moAttack = new MoAttack(geli);
        moAttack.cityGateAsk();
    }

    /**
     * 通过setter方法注入革离扮演者
     */
    public void directSetter() {
        GeLi geli = new LiuDeHua();
        MoAttack moAttack = new MoAttack();
        moAttack.setGeli(geli);
        moAttack.cityGateAsk();
    }

}
