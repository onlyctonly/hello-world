package com.jxyu;



//import java.util.List;

//import java.sql.Connection;
//import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Student;


public class TestJdbc {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = sf.getCurrentSession();
	try {
		session.beginTransaction();
//		update students 1
//		Student s = session.get(Student.class, 1);
//		s.setFirst_name("XiangYu");
		
//		update students 2
		session.createQuery("update Student s set s.email='test@gmail.com' where s.id=1").executeUpdate();
		
//		Read Students
//		List<Student> ls = session.createQuery("from Student s where s.first_name like 'l%'").getResultList();
//		List<Student> ls = session.createQuery("from Student").getResultList();
//		ls.stream().forEach(System.out::println);
//		for (Student s : ls) {
//			System.out.println(s);
//		}
		
		session.getTransaction().commit();
//		Create students
//		Student s1 = new Student("le", "le", "lele@test.com");
//		session.beginTransaction();
//		session.save(s1);
//		System.out.println(s1);
//		session.getTransaction().commit();
//		System.out.println(session.get(Student.class, s1.getId()));
		
//		Student s1 = new Student("jia", "jia", "jiajia@test.com");
//		session.beginTransaction();
//		session.save(s1);
//		session.getTransaction().commit();
//		System.out.println("done");

		

	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	} finally {
		sf.close();
	}
		
		
//		String url= "jdbc:mysql://localhost:32771/?useSSL=false";
//		String user="hbstudent";
//		String password="hbstudent";
//		try {
//			System.out.println("connecting");
//			
//			Connection conn = DriverManager.getConnection(url, user, password);
//			System.out.println("connected");
//
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
	}
}
