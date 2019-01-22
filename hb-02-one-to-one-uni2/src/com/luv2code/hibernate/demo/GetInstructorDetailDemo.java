package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {
	
	private static Logger logger = Logger.getLogger(GetInstructorDetailDemo.class);

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
			session.beginTransaction();
			
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			
			if (tempInstructorDetail != null) {
				logger.debug("Instructor details: " + tempInstructorDetail);
				
				logger.debug("The associated instructor: " + tempInstructorDetail.getInstructor());
			} else {
				logger.debug("Instructor with this ID does not exist");
			}

			session.getTransaction().commit();
		} catch (Exception exc) {
				exc.printStackTrace();
		} finally {
				session.close();
				factory.close();
		}
	}
}

