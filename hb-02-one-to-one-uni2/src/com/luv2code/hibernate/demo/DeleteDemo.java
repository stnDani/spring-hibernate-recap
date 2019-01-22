package com.luv2code.hibernate.demo;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {
	
	private static Logger logger = Logger.getLogger(DeleteDemo.class);

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
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			logger.debug("Found instructor: " + tempInstructor);
			
			// delete the instructor
			if (tempInstructor != null) {
				
			// This will ALSO delete the details object because of CascadeType.ALL
				session.delete(tempInstructor);
				logger.debug("Deleting Instructor with ID " + theId);
			}
			
			// commit the transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}

