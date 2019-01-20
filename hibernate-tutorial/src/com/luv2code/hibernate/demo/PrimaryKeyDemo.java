package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
		    .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the student object
			System.out.println("Creating 3 student objects...");
			
			Date theDateOfBirth = DateUtils.parseDate("31/12/1990");

			Student tempStudent1 = new Student("John", "Doe", "paul@luv2code.com", theDateOfBirth);
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com", theDateOfBirth);
			Student tempStudent3 = new Student("Bonita", "Applebum", "applebum@luv2code.com", theDateOfBirth);

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
