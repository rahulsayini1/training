package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddCopiesBookBranch {
	public void addcopies(String branch_id) {
		Scanner titleobj = new Scanner(System.in);

		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");

			PreparedStatement stmt = conn
					.prepareStatement("select b.bookid,b.title from tbl_book b join tbl_book_copies bc on bc.bookid = b.bookid where branchid = ?");
			stmt.setString(1, branch_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("book id : " + rs.getString(1) + "title "
						+ rs.getString(2));
			}
			System.out.println("please select bookid ");
			
			//String bookid = titleobj.next();
			String bookid = titleobj.next();
			stmt = conn.prepareStatement("select bc.bookid,bc.noofcopies,b.title from tbl_book_copies bc join tbl_library_branch lb on lb.branchid = bc.branchid join tbl_book b on b.bookid = bc.bookid where b.bookid = ? and lb.branchid = ?");
			stmt.setString(1, bookid);
			stmt.setString(2, branch_id);
			rs=stmt.executeQuery();
			if(rs.next() == false){
				System.out.println("empty set");
			}
			while (rs.next())
				System.out.println(" bookid: " + rs.getString(1)+" noofcopies " + rs.getString(2) + " title "+rs.getString(3));
			System.out
					.println("Please enter the no of copies you want to change");
			String num = titleobj.next();
			stmt= conn.prepareStatement("UPDATE tbl_book_copies bc SET noofcopies = ? where bookid = ? and branchid = ?");
			stmt.setString(1, num);
			stmt.setString(2, bookid);
			stmt.setString(3, branch_id);
			stmt.executeUpdate();
			//stmt.setString(2, bookid);
			System.out.println("change is succesful");
			Librarian librarian = new Librarian();
			librarian.librarianmenu();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
