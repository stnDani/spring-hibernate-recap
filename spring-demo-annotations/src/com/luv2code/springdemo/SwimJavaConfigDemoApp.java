package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);
		
		// get the bean from the spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
				
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call our new swim coach methods.. has the props values
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
