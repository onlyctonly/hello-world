package com.bashfan.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bashfan.domain.Organization;

public class OrganizationRowMapper implements RowMapper<Organization> {

	public Organization mapRow(ResultSet rs, int rownum) throws SQLException {
		Organization org = new Organization();
		org.setId(rs.getInt("id"));
		org.setCompanyName(rs.getString("company_name"));
		org.setEmployeeCount(rs.getInt("employee_count"));
		org.setPostalCode(rs.getInt("postal_code"));
		org.setSlogan(rs.getString("slogan"));
		org.setYearOfOperation(rs.getInt("year_of_operation"));
		
		
		return org;
	}

}
