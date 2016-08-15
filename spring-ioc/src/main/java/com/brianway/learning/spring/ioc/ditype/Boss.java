package com.brianway.learning.spring.ioc.ditype;

public class Boss {
    private String name;
    private Car car;
    private Office office;


    public Boss() {

    }

    public Boss(String name, Car car, Office office) {
        this.name = name;
        this.car = car;
        this.office = office;
    }

    public Boss(String name, Car car) {
        this.name = name;
        this.car = car;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String toString() {
        return "name:" + name + "/car:" + car.getBrand() + "/office:" + office;
    }
}
