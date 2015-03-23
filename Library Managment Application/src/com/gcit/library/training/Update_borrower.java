package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_borrower {
public void updateborrower(){
	try{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		PreparedStatement stmt = conn
				.prepareStatement("select cardno,name,address,phone from tbl_borrower");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("Card number "+rs.getString(1)+"  Name " +rs.getString(2)+" Address "+rs.getString(3)+ "  phone " +rs.getString(4) );
	}
		System.out.println("please select the card number you want to update");
		Scanner scan = new Scanner(System.in);
		String cardno = scan.next();
		System.out.println("enter new name");
		String name = scan.next();
		System.out.println("enter new address");
		String address = scan.next();
		System.out.println("enter the phone");
		String phone = scan.next();
		
		stmt = conn.prepareStatement("update tbl_borrower set name=?,address=?,phone=? where cardno = ?" );
		stmt.setString(1, name);
		stmt.setString(2, address);
		stmt.setString(3, phone);
		stmt.setString(4, cardno);
		stmt.executeUpdate();
		
		System.out.println("successfully updated");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

