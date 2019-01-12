package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortuneMessages = {"today!", "this year!", "your whole life!"};
	
	@Override
	public String getFortune() {
		int randIdx = new Random().nextInt(fortuneMessages.length);
		
		return "You are lucky " + fortuneMessages[randIdx];
	}

}
