package com.jxyu;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	@NotNull(message="required")
	@Size(min=1, message="required")
	private String firstname;
	
	@Pattern(regexp="^\\w{5}", message="must be 5 characters")
	private String lastname;
	
	@NotNull(message="is required")
	@Min(value=18, message="adult only")
	@Max(value=100, message="too old")
	private Integer age;
	
	private String Country;
	private String prefferedlanguage;
	private String[] os;
	
	private LinkedHashMap<String, String> countryoptions;
	

	
	
	public Student() {
		this.countryoptions = new LinkedHashMap<>();
		this.countryoptions.put("Zh", "China");
		this.countryoptions.put("GR", "Greece");
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public LinkedHashMap<String, String> getCountryoptions() {
		return countryoptions;
	}
	public String getPrefferedlanguage() {
		return prefferedlanguage;
	}
	public void setPrefferedlanguage(String prefferedlanguage) {
		this.prefferedlanguage = prefferedlanguage;
	}
	public String[] getOs() {
		return os;
	}
	public void setOs(String[] os) {
		this.os = os;
	}
	
	
	
	
}
