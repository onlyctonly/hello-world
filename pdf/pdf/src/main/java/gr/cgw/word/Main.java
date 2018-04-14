package gr.cgw.word;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.hwpf.HWPFDocument;

public class Main {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) throws Exception {
		// mysql
		Connection conn = null;
		Statement stmt = null;
		Statement stmt2 = null;
		// Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		stmt2 = conn.createStatement();

		String sql = "SELECT * FROM subscription.greeksubscriber";
		
		String sql2 = "select found_rows()";

		
		
		File file = new File("template.doc");

		
		ResultSet rs = stmt.executeQuery(sql);
		ResultSet rs2=stmt2.executeQuery(sql2);
		
		//get total pages
		rs2.next();
		int totalRows = rs2.getInt(1);
		int pages = 0;
		if ( totalRows%40 != 0 ) {
			pages = Math.floorDiv(totalRows, 40)+1;
		}else {
			pages = totalRows/40;
		}
		
		//create post code csv
		BufferedWriter out = new BufferedWriter(new FileWriter("postcodeGR.csv"));
		
		for (int j = 0; j < pages; j++) {
			//create page
			InputStream fs = new FileInputStream(file);
			HWPFDocument doc2 = new HWPFDocument(fs);
			//select rows
			Statement stat3 = conn.createStatement();
			String sql3= "SELECT title, givenname, surname,department,street,street_number,area,tk,copies,city FROM subscription.greeksubscriber "
					+ "limit " + j*40 + ", 40";
			ResultSet rs3 = stat3.executeQuery(sql3);
			//start replacing
			int i =1;
			while (rs3.next()) {
				
				String title = rs3.getString("title");
				String surname = rs3.getString("surname");
				String givenname = rs3.getString("givenname");
				String department = rs3.getString("department");
				String street = rs3.getString("street");
				String no = rs3.getString("street_number");
				String area = rs3.getString("area");
				String tk = rs3.getString("tk");
				String copies = rs3.getString("copies");
				String city = rs3.getString("city");

				
				String total = title + " " + givenname + " " + surname + ", " + department + ", " + street + " " + no + ", "
						+ area + ", "+ city+" " + tk + ","+ copies;
				doc2.getRange().replaceText("${"+i+"}", total);
				doc2.getRange().replaceText("null", "");
				doc2.getRange().replaceText(",,", ",");
				doc2.getRange().replaceText(", ,", ",");
				i=i+1;
				
				// write post code file
				StringBuilder sb=new StringBuilder();
				sb.append("0;");
				sb.append(tk.substring(3, 8));
				sb.append(";2;2;4;0;000000;1");
				sb.append("\r\n");
				out.write(sb.toString());
				
			}
			doc2.write(new File(j+1+".doc"));
			doc2.close();
			rs3.close();
			stat3.close();
			
			
		}
		
		
		
	
		rs.close();
		rs2.close();
		
		stmt.close();
		stmt2.close();
		
		conn.close();
		out.close();
		System.out.println("Goodbye!");

	}

}

// Blank Document
// XWPFDocument document = new XWPFDocument();
//
//// Write the Document in file system
// FileOutputStream out = new FileOutputStream(new
// File("createparagraph.docx"));
//
//// create table
// XWPFTable table = document.createTable();
// XWPFTableRow tableRowOne = table.getRow(0);
// tableRowOne.setHeight(17000);
// tableRowOne.getCell(0).setText("col one, row one");
// tableRowOne.addNewTableCell().setText("col two, row one");
// tableRowOne.addNewTableCell().setText("col three, row one,bla,bla,bal");
//
//// create Paragraph
// XWPFParagraph paragraph = document.createParagraph();
// XWPFRun run = paragraph.createRun();
// run.setText("测试");
//
// document.write(out);
// out.close();
// document.close();
// System.out.println("createparagraph.docx written successfully");
