package com.bashfan.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import com.bashfan.config.SpringConfig;
import com.bashfan.dao.OrganizationDao;
import com.bashfan.daoImp.OrganizationDaoImp;
import com.bashfan.domain.Organization;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		OrganizationDao dao = (OrganizationDao) context.getBean(OrganizationDaoImp.class);
		List<Organization> orgs = dao.getAllOrganizations();
		
		System.out.println("print out all Orgs\n");
		orgs.stream().forEach(o->System.out.println(o+"\n"));
//		Organization o = new Organization("GE", 18, 200, 11122, "test slogan");
//		dao.create(o);
		System.out.println("print out 1 org");
		try {
			Organization o = dao.getOrganization(4);
			System.out.println(o);

		} catch (DataAccessException dae) {
			System.out.println(dae.getMessage() + " "+dae.getClass());
		}
		context.close();
		
	}

}
