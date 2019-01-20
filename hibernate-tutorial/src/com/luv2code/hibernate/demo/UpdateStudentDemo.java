package com.luv2code.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	private static final Logger logger = Logger.getLogger(UpdateStudentDemo.class);

	private static final SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {
		
		
		try {
			updateStudentFirstNameAndID(1, "Scooby");
			
			bulkUpdateWithEmail("foo@gmail.com");
		} finally {
			factory.close();
		}
	}

	private static void updateStudentFirstNameAndID(int studentId, String firstName) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		logger.info("\nGetting the student with ID: " + studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		logger.info("Updating student...");
		myStudent.setFirstName(firstName);
		
		session.getTransaction().commit();
		
		logger.info("Done!");
	}

	private static void bulkUpdateWithEmail(String email) {
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
