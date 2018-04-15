package com.bashfan.demo;

public enum Book {
	
	BOA("THIS IS BOOK A", "2012"),
	BOB("THIS IS BOOK B", "2000");
	
	private final String title;
	private final String year;
	
	Book(String title, String year){
		this.title=title;
		this.year=year;
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}
	
	

}
