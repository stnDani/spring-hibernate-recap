package com.luv2code.hibernate.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session =  factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("Creating new student object...");
			
			Date theDateOfBirth = DateUtils.parseDate("31/12/1990");
			
			Student tempStudent = new Student("John", "Wall", "john@luv2code.com", theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
						
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
