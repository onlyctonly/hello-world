package com.bashfan.daoImp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bashfan.dao.OrganizationDao;
import com.bashfan.domain.Organization;

@Repository
public class OrganizationDaoImp implements OrganizationDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDatasource(DataSource ds) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
	}

	public boolean create(Organization org) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(org);
		String sql="insert into organizations values(null,:companyName,:yearOfOperation,:postalCode,:employeeCount,:slogan)";
		return namedParameterJdbcTemplate.update(sql, paramSource) ==1;
//		Object[] args = new Object[] {org.getCompanyName(),org.getYearOfOperation(),org.getPostalCode(),org.getEmployeeCount(),org.getSlogan()};
//		return jdbcTemplate.update(sql, args)==1;
	}

	public Organization getOrganization(Integer id) {
		SqlParameterSource paramSource = new MapSqlParameterSource("ID", id);
		String sql="select * from organizations where id=:ID";
		Organization o = namedParameterJdbcTemplate.queryForObject(sql, paramSource, new OrganizationRowMapper());
		return o;
//		Object[] args=new Object[] {id};

	}

	public List<Organization> getAllOrganizations() {
		String sql= "select * from organizations";
		List<Organization> orgAll = namedParameterJdbcTemplate.query(sql, new OrganizationRowMapper());
		
		return orgAll;
				
	}

	public boolean deleteOrganization(Integer id) {
		SqlParameterSource paramSource=new MapSqlParameterSource("ID",id);
		String sql= "delete from organizations where id =:ID";
		return namedParameterJdbcTemplate.update(sql, paramSource)==1;
	}

	public boolean updateOrganization(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
