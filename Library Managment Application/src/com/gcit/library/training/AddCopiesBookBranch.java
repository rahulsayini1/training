package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddCopiesBookBranch {
	public void addcopies(int branch_id) {
		Scanner titleobj = new Scanner(System.in);

		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select bookid,title from tbl_book");
			while (rs.next()) {
				System.out.println("book id : " + rs.getString("bookid")
						+ "title " + rs.getString("title"));
			}
			System.out.println("please select the book title and id ");
			String title = titleobj.next();
			String bookid = titleobj.next();
			rs = stmt
					.executeQuery("select bc.bookid,bc.noofcopies,b.title from tbl_book_copies bc join tbl_library_branch lb on lb.branchid = bc.branchid join tbl_book b on b.bookid = bc.bookid where b.title ='"
							+ title + "' and lb.branchid = '"+branch_id+"'");
			while (rs.next())
				System.out.println("noofcopies:" + rs.getInt("noofcopies"));
			System.out
					.println("Please enter the no of copies you want to change");
			String num = titleobj.next();
			stmt.executeUpdate("UPDATE tbl_book_copies SET noofcopies = '"
					+ num + "' where bookid = '" + bookid + "'");
			System.out.println("changes succesfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
