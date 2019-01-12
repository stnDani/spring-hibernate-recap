package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> Tennis Coach: inside the default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach : inside doMyStartupStuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach : inside doMyCleanupStuff");
	}
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	/*
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> Tennis Coach: inside the doSomeCrazyStuff() method");
		this.fortuneService = fortuneService;
	}
	*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
