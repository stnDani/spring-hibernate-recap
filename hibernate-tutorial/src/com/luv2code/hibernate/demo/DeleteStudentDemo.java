package com.luv2code.hibernate.demo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
	final static Logger logger = Logger.getLogger(DeleteStudentDemo.class);

	final static SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class)
			.buildSessionFactory();
	
	public static void main(String[] args) {

		try {
			int studentId = 1;
			deleteStudent(studentId);
			
			String lastName = "Duck";
			deleteStudentWithLastName(lastName);
			
		} finally {
			factory.close();
		}
	}

	private static void deleteStudentWithLastName(String lastName) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String deleteStudentWithLastNameHQL = "delete Student s where s.lastName = :lastName";
		
		logger.info("Deleting student with last name: " + lastName);
		session.createQuery(deleteStudentWithLastNameHQL)
			.setParameter("lastName", lastName)
			.executeUpdate();
		
		session.getTransaction().commit();
		
		logger.info("Done deleting student with las name: " + lastName);
	}

	private static void deleteStudent(int studentId) {
		Session session =  factory.getCurrentSession();
		session.beginTransaction();
		
		Student myStudent = session.get(Student.class, studentId);
		
		if (myStudent != null) {
			logger.info("Deleting student with ID: " + studentId);
			session.delete(myStudent);
			
			logger.info("Deleting student with ID " + studentId + " finished!");
		} else {
			logger.info("Student with ID " + studentId + "was not found in the database.");
		}
		session.getTransaction().commit();
	}

}
