package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Course;
import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		try {
			
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 4);
			System.out.println(instructor);
			System.out.println(instructor.getCourses());
			
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			fac.close();
		}
	}

}
