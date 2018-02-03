package all.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	public void addMember() {
		System.out.println(this.getClass() + " adding new member to db \n");
	}
}
