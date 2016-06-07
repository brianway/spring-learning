package com.brianway.learning.spring.ioc.ditype;

/**
 *
 */
public class Car {
	public String brand;
	private String corp;	
	private double price;
	private int maxSpeed;

	//----------构造方法------------
	public Car() {}

	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}	

	public Car(String brand, String corp, double price) {
		this.brand = brand;
		this.corp = corp;
		this.price = price;
	}
	public Car(String brand, String corp, int maxSpeed) {
		this.brand = brand;
		this.corp = corp;
		this.maxSpeed = maxSpeed;
	}

	//-----------get和set方法---------------------
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "brand:"+brand+"/maxSpeed:"+maxSpeed+"/price:"+price;
	}

}

