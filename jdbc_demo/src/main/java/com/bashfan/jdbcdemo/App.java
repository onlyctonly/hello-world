package com.bashfan.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class App {

	public static void main(String[] args) {
		Connection myconn = null;
		Statement mystate = null;
		ResultSet myrs = null;
		PreparedStatement myps = null;
		CallableStatement mycall = null;

		try {
			myconn = DriverManager.getConnection("jdbc:mysql://127.0.0.1", "root", "root");
			mystate = myconn.createStatement();
			myrs = mystate.executeQuery("select * from subscription.GreekSubscriber");

			while (myrs.next()) {
				System.out.println(myrs.getInt(1));
				System.out.println(myrs.getString("department"));
			}

			int i = mystate.executeUpdate(
					"insert into subscription.GreekSubscriber (givenname, surname) values ('Jane', 'Doe')");
			System.out.println(i);

			myps = myconn.prepareStatement("select * from subscription.GreekSubscriber where `surname` = ?");
			myrs = null;
			myps.setString(1, "Doe");
			myrs = myps.executeQuery();

			System.out.println("======");
			while (myrs.next()) {
				System.out.println(myrs.getString("surname") + " " + myrs.getInt(1));
			}

			mycall = myconn.prepareCall("call subscription.new_greek(?, ?, ?)");
			mycall.setString(1, "L");
			mycall.setString(2, "M");
			mycall.registerOutParameter(3, Types.INTEGER);
			mycall.execute();
			Integer i1 = mycall.getInt(3);
			System.out.println(i1);

			myrs.close();
			mystate.close();
			myps.close();
			myconn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
