package com.brianway.learning.spring.ioc.example;

/**
 * Created by Brian on 2016/5/12.
 */
public class Director {
    public void  direct_constructor(){
        GeLi geli = new LiuDeHua();
        MoAttack moAttack = new MoAttack(geli);
        moAttack.cityGateAsk();
    }

    public void  direct_setter(){
        GeLi geli = new LiuDeHua();
        MoAttack moAttack = new MoAttack();
        moAttack.setGeli(geli);
        moAttack.cityGateAsk();
    }

}
