package gr.cgw.subscription.model;

public class ChineseSubscriber {
	private String surname;
	private String lastname;
	private String department;
	private String street;
	private String street_number;
	private String area;
	private String tk;
	private String start_date;
	private String end_date;
	private int copies;
	public ChineseSubscriber(String surname, String lastname, String department, String street, String street_number,
			String area, String tk, String start_date, String end_date, int copies) {
		this.surname = surname;
		this.lastname = lastname;
		this.department = department;
		this.street = street;
		this.street_number = street_number;
		this.area = area;
		this.tk = tk;
		this.start_date = start_date;
		this.end_date = end_date;
		this.copies = copies;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	@Override
	public String toString() {
		return "ChineseSubscriber [surname=" + surname + ", lastname=" + lastname + ", department=" + department
				+ ", street=" + street + ", street_number=" + street_number + ", area=" + area + ", tk=" + tk
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", copies=" + copies + "]";
	}

	
	
}
