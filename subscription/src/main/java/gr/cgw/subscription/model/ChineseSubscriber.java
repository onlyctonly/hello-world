package gr.cgw.subscription.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ChineseSubscriber")
public class ChineseSubscriber {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="surname")
	private String surname;
	@Column(name="given_name")
	private String given_name;
	@Column(name="department")
	private String department;
	@Column(name="street")
	private String street;
	@Column(name="street_number")
	private String street_number;
	@Column(name="area")
	private String area;
	@Column(name="tk")
	private String tk;
	@Column(name="start_date")
	private String start_date;
	@Column(name="end_date")
	private String end_date;
	@Column(name="copies")
	private int copies;
	@Column(name="comment")
	private String comment;
	@Column(name="city")
	private String city;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public ChineseSubscriber(String title, String surname, String given_name, String department, String street,
			String street_number, String area, String tk, String start_date, String end_date, int copies,
			String comment, String city) {
		this.title = title;
		this.surname = surname;
		this.given_name = given_name;
		this.department = department;
		this.street = street;
		this.street_number = street_number;
		this.area = area;
		this.tk = tk;
		this.start_date = start_date;
		this.end_date = end_date;
		this.copies = copies;
		this.comment = comment;
		this.city = city;
	}
	public ChineseSubscriber() {
		super();
	}
	@Override
	public String toString() {
		return "ChineseSubscriber [id=" + id + ", title=" + title + ", surname=" + surname + ", lastname=" + given_name
				+ ", department=" + department + ", street=" + street + ", street_number=" + street_number + ", area="
				+ area + ", tk=" + tk + ", start_date=" + start_date + ", end_date=" + end_date + ", copies=" + copies
				+ ", comment=" + comment + ", city=" + city + "]";
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	
	

	
	
	

	
	
}
