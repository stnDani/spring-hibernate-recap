package com.luv2code.hibernate.demo;

import java.text.ParseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) throws ParseException {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session =  factory.getCurrentSession();

		try {
			
			Instructor tempInstructor = new Instructor("John", "Doe", "doe@luv2code.com");
			
			InstructorDetail tempInstructorDetails = new InstructorDetail("www.luv2code.com", "Luv 2 code!!");
			
			tempInstructor.setInstructorDetail(tempInstructorDetails);
			
			session.beginTransaction();
			
			// This will ALSO save the details object because of CascadeType.ALL
			session.save(tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
