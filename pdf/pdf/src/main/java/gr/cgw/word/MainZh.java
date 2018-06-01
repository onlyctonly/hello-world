package gr.cgw.word;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MainZh {

	public static void main(String[] args) throws IOException  {
		//set properties
		Properties props =new Properties();
		try {
			InputStream in= new FileInputStream("db.properties");
			try {
				props.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//connect to db //get all tk
		try {
			Connection conn = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select tk from subscription.chinesesubscriber");
			BufferedWriter bf = new BufferedWriter(new FileWriter("postcodeZH.csv"));
			//out put the file 
			while (rs.next()) {
				StringBuilder sb=new StringBuilder();
				sb.append("0;");
				sb.append(rs.getInt(1));
				sb.append(";2;2;4;0;000000;1");
				sb.append("\r\n");
				bf.write(sb.toString());
			}
			
			rs.close();
			st.close();
			conn.close();
			bf.close();
			System.out.println("bye");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
