package com.bashfan.dao;

import java.util.List;

import javax.sql.DataSource;

import com.bashfan.domain.Organization;

public interface OrganizationDao {
	public void setDatasource(DataSource ds);
	public boolean create(Organization org);
	public Organization getOrganization(Integer id);
	public List<Organization> getAllOrganizations();
	public boolean deleteOrganization(Integer id);
	public boolean updateOrganization(Integer id);
	

}
