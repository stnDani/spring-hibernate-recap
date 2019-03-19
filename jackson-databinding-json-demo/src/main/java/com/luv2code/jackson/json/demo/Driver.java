package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("First name: " + theStudent.getFirstName());
			System.out.println("Student ID: " + theStudent.getId());
			System.out.println("Address: " + theStudent.getAddress());
			
			for (String language : theStudent.getLanguages()) {
				System.out.println(language);
			}
			
		} catch (Exception exc) {
				exc.printStackTrace();
		}
	}
}
