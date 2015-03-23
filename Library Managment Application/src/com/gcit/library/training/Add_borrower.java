package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_borrower {
public void addborrower(){
	try{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter name");
		String name = scan.next();
		System.out.println("enter address");
		String address = scan.next();
		System.out.println("enter phone");
		String phone = scan.next();
		
		PreparedStatement stmt = conn.prepareStatement("insert into tbl_borrower (name,address,phone) values (?,?,?)");
		stmt.setString(1, name);
		stmt.setString(2, address);
		stmt.setString(3, phone);
		stmt.executeUpdate();
		
		System.out.println("successfully inserted");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
