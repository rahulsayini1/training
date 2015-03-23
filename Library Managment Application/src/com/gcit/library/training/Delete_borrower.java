package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_borrower {
public void deleteborrower(){
	try{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		
		PreparedStatement stmt = conn.prepareStatement("select cardno,name from tbl_borrower");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			System.out.println(" Cardno " +rs.getString(1) + " name " +rs.getString(2));
		}
		
		System.out.println("select the cardno you want to delete");
		Scanner scan = new Scanner(System.in);
		String cardno = scan.next();
		
		stmt = conn.prepareStatement("delete from tbl_borrower where cardno=?");
		stmt.setString(1, cardno);
		stmt.executeUpdate();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
