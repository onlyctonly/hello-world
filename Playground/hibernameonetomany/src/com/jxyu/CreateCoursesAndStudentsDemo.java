package com.jxyu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jxyu.entity.Course;
import com.jxyu.entity.Instructor;
import com.jxyu.entity.InstructorDetail;
import com.jxyu.entity.Review;
import com.jxyu.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		SessionFactory fac = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		Session session = fac.getCurrentSession();
		
		try {
			session.beginTransaction();
//			Instructor tempIns = session.get(Instructor.class, 4);
//			Course tempCourse = new Course("how to get rich2");
//			tempIns.add(tempCourse);
//			Student s1=new Student("lele", "Jia","lele@gmail.com");
//			Student s2=new Student("jia", "Jia",	"jiajia@gmail.com");
//			tempCourse.addStudent(s1);
//			tempCourse.addStudent(s2);
//			session.save(tempCourse);
//			session.save(s1);
//			session.save(s2);
			
			Student s = session.get(Student.class, 3);
			s.getCourses().stream().forEach(System.out::println);
			
			session.getTransaction().commit();
			
			
		} finally {
			session.close();
			fac.close();
		}
	}

}
