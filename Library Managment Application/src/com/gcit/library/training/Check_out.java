package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Scanner;

public class Check_out {
public void checkout(String cardno)
{
	try {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		PreparedStatement stmt = conn.prepareStatement("select branchid,branchname from tbl_library_branch");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println("Branch id:" + rs.getString(1)+ " Branchname : " + rs.getString(2));
			}
		System.out.println("Select the branchid from the list ");
		Scanner ob = new Scanner(System.in);
		
		String branch_id = ob.next();	
		
		stmt=conn.prepareStatement("select b.bookid,b.title from tbl_book b join tbl_book_loans bl on bl.bookid = b.bookid join tbl_library_branch lb on lb.branchid=bl.branchid where lb.branchid=?");
		stmt.setString(1, branch_id);
		rs = stmt.executeQuery();
		while(rs.next())
		System.out.println("bookid " + rs.getString(1) + "title" + rs.getString(2));
		System.out.println("please select the bookid from above list");
		String book_id = ob.next();
		 Calendar calendar = Calendar.getInstance();
		    java.sql.Date JavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		    
			//System.out.println("Date : " + sdf.format(calendar.getTime()));
		stmt = conn.prepareStatement("insert into tbl_book_loans (bookid,branchid,cardno,dateout,duedate) values (?,?,?,?,?)");
		stmt.setString(1, book_id);
		stmt.setString(2, branch_id);
		stmt.setString(3, cardno );
		stmt.setDate(4,JavaDateObject );
		stmt.setDate(5, JavaDateObject);
		stmt.executeUpdate();
		
		System.out.println("Successfully checked out");
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}

}}
