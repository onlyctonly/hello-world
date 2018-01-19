package com.jxyu;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) {
			String url="jdbc:mysql://localhost:32768/hb-01-one-to-one-uni?useSSL=false";
			String user="hbstudent";
			String password="hbstudent";
			
			try {
				Connection conn = DriverManager.getConnection(url, user, password);
				System.out.println("connected");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				
			}
			
	}

}
