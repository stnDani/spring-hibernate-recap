package com.luv2code.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		final Logger logger = Logger.getLogger(UpdateStudentDemo.class);

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			
			int studentId = 1;
			String firstName = "Scooby";
			
			updateStudentFirstName(logger, factory, studentId, firstName);
			
			String email = "foo@gmail.com";
			bulkUpdateEmail(logger, factory, email);
		} finally {
			factory.close();
		}
	}

	private static void updateStudentFirstName(final Logger logger, SessionFactory factory, int studentId, String firstName) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		logger.info("\nGetting the student with ID: " + studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		logger.info("Updating student...");
		myStudent.setFirstName(firstName);
		
		session.getTransaction().commit();
		
		logger.info("Done!");
	}

	private static void bulkUpdateEmail(final Logger logger, SessionFactory factory, String email) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		logger.info("Updating email for all students...");
		
		String updateEmailHQL = "update Student set email = '" + email + "'";
		session.createQuery(updateEmailHQL)
				.executeUpdate();
		
		session.getTransaction().commit();
		
		logger.info("Done!");
	}

}
