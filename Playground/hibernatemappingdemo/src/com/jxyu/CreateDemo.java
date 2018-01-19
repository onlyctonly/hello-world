package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Instructor temInstructor = new Instructor("xinhe", "lv", "testlv@gmail.com");
			InstructorDetail tempid = new InstructorDetail("www.youtube.com/xinhe", "lele");
			temInstructor.setInstructorDetail(tempid);
			
			
			session.beginTransaction();
			session.save(temInstructor);
			session.getTransaction().commit();
			System.out.println(temInstructor);
		} finally {
			session.close();
			factory.close();  
		}
	}

}
