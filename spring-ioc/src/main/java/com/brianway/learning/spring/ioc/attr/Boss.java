package com.brianway.learning.spring.ioc.attr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Boss {
	private String name ;
	private int age;
	private Car car = new Car();
	private Map jobs = new HashMap(); 
	private Properties mails = new Properties();
	private Map<String,Integer> jobTime = new HashMap<String,Integer>();
	
	//-----------get和set方法------------------
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Map<String, Integer> getJobTime() {
		return jobTime;
	}
	public void setJobTime(Map<String, Integer> jobTime) {
		this.jobTime = jobTime;
	}
	public Properties getMails() {
		return mails;
	}
	public void setMails(Properties mails) {
		this.mails = mails;
	}
	
	public Map getJobs() {
		return jobs;
	}
	public void setJobs(Map jobs) {
		this.jobs = jobs;
	}	

	private Set favorites = new HashSet();
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String toString(){
		String temp ="car:"+car+"\n";
		temp += "favorites.size:"+favorites.size()+"\n";
		temp += "jobs.size:"+jobs.size();
		return temp;
	}
	public Set getFavorites() {
		return favorites;
	}
	public void setFavorites(Set favorites) {
		this.favorites = favorites;
	}


	//	private List favorites = new ArrayList();
	//
	//	public List getFavorites() {
	//		return favorites;
	//	}
	//	public void setFavorites(List favorites) {
	//		this.favorites = favorites;
	//	}

}
