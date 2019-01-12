package com.luv2code.springdemo;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside Football Coach - setting the fortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "20 goals!!";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}
	
	public String getRandomFortune() {
		return fortuneService.getFortune();
	}

}
