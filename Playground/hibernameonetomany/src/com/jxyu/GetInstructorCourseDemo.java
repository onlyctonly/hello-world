package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Course;
import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;
import com.jxyu.entity.Review;
import com.jxyu.entity.Student;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		try {
			
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, 4);
			System.out.println(tempInstructor);
			System.out.println(tempInstructor.getCourses());
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			fac.close();
		}
	}

}
