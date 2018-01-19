package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Course;
import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;
import com.jxyu.entity.Review;

public class GetCourseReviews {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = fac.getCurrentSession();
		try {
			
			session.beginTransaction();
			Course tempCourse = session.get(Course.class, 11);
			tempCourse.add(new Review("不错啊"));
			tempCourse.add(new Review("耶!"));
			session.save(tempCourse);
			tempCourse.getReviews().stream().forEach(System.out::println);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			fac.close();
		}
	}

}
