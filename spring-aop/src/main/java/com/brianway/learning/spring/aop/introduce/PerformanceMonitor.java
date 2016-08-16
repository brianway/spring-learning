package com.brianway.learning.spring.aop.introduce;

public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();
	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformace mp = performaceRecord.get();
		if(mp == null){
			mp = new MethodPerformace(method);
			performaceRecord.set(mp);
		}else{
		    mp.reset(method);	
		}
	}
	public static void end() {
		System.out.println("end monitor...");
		MethodPerformace mp = performaceRecord.get();
		mp.printPerformace();
	}
}
