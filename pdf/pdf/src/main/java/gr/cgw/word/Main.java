package gr.cgw.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.hwpf.HWPFDocument;

public class Main {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/subscription?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) throws Exception {
		// mysql
		Connection conn = null;
		Statement stmt = null;
		// Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		stmt = conn.createStatement();
		String sql;
		sql = "SELECT title, givenname, surname,department,street,street_number,area,tk FROM greeksubscriber";
		ResultSet rs = stmt.executeQuery(sql);
		
		File file = new File("template.doc");
		InputStream fs = new FileInputStream(file);
		HWPFDocument doc2 = new HWPFDocument(fs);
		
		while (rs.next()) {
			String title = rs.getString("title");
			String surname = rs.getString("surname");
			String givenname = rs.getString("givenname");
			String department = rs.getString("department");
			String street = rs.getString("street");
			String no = rs.getString("street_number");
			String area = rs.getString("area");
			String tk = rs.getString("tk");
			String total = title + " " + givenname + " " + surname + "\n" + department + ", " + street + " " + no + ", "
					+ area + ", " + tk;
			doc2.getRange().replaceText("${1}", total);
		}
		rs.close();
		stmt.close();
		conn.close();
		System.out.println("Goodbye!");

		// open a file

		doc2.write(new File("2.doc"));
		doc2.close();
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
