package com.brianway.learning.spring.ioc.ditype;

public class CarFactory {

    /**
     * 创建Car的非静态工厂方法
     *
     * @return
     */
    public Car createHongQiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }

    /**
     * 静态工厂方法
     *
     * @return
     */
    public static Car createCar() {
        Car car = new Car();
        return car;
    }

}
