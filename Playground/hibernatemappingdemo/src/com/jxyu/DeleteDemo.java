package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = fac.getCurrentSession();
		
		try {
			session.beginTransaction();
			Instructor temp = session.get(Instructor.class, 1);
			System.out.println(temp);
			if (temp != null) {
				session.delete(temp);
			}
//			session.createQuery("delete Instructor ins where ins.id = 2").executeUpdate();
			session.getTransaction().commit();
		} finally {
			session.close();
			fac.close();
		}
	}

}
