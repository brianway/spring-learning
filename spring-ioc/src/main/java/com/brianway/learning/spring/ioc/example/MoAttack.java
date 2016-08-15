package com.brianway.learning.spring.ioc.example;

/**
 * Created by Brian on 2016/5/12.
 */
public class MoAttack {
    /*
    //通过演员安排剧本，耦合严重
    public void cityGateAsk(){
        LiuDeHua ldh = new LiuDeHua();
        ldh.responseAsk("墨者革离");
    }*/

    /*
    //引入剧本角色
    public void cityGateAsk(){
        GeLi geli = new LiuDeHua();
        geli.responseAsk("墨者革离");
    }*/

    private GeLi geli;

    public MoAttack() {
    }

    //构造函数注入
    public MoAttack(GeLi geli) {
        this.geli = geli;
    }

    //属性注入方法
    public void setGeli(GeLi geli) {
        this.geli = geli;
    }

    public void cityGateAsk() {
        geli.responseAsk("墨者革离");
    }

}
