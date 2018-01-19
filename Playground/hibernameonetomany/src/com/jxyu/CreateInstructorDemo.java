package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Course;
import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = fac.getCurrentSession();
		try {
			
			Instructor temInstructor = new Instructor("xinhe", "lv", "testlv2@gmail.com");
			InstructorDetail tempdetail = new InstructorDetail("www.youtube.com/xinhe2", "lele");
			temInstructor.setInstructorDetail(tempdetail);
			
			
			session.beginTransaction();
			session.save(temInstructor);
			
			session.getTransaction().commit();
		} finally {
			session.close();
			fac.close();
			
		}
	}

}
