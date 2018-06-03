package com.bashfan.jdbcprocdedure;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class CallProcddure {

	public static void main(String[] args) throws Exception {
		Connection conn=null;
		CallableStatement mycall=null;
		ResultSet rs=null;
		
		Properties props = new Properties();
		props.load(new FileInputStream("src/main/resources/db.properties"));
		
		try {
			conn=DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("passwd"));
			mycall=conn.prepareCall("call test.addname(?)");
			mycall.setString(1, "over");
			
			if (mycall.execute()) {
				System.out.println("done");
			}

		} finally {
			if(rs !=null) {rs.close();}
			mycall.close();
			conn.close();
		}
	}

}
