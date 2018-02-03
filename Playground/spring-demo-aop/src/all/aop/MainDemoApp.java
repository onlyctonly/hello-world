package all.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import all.dao.AccountDAO;
import all.dao.MemberDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MemberDAO theMemberDAO = context.getBean("memberDAO", MemberDAO.class);
		theAccountDAO.addAccount();
		theAccountDAO.addAccount();
		theMemberDAO.addMember();
		context.close();
	}

}
