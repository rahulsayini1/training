package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrower {

	public static void main(String[] args) {
		
		Scanner borrowerobj = new Scanner(System.in);
		System.out.println("enter the borrower name");
		String name = borrowerobj.next();
		System.out.println("enter address");
		String address = borrowerobj.next();
		System.out.println("enter phone number");
		String phone = borrowerobj.next();
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO tbl_borrower (name,address,phone) VALUES ('"+name+ "','"+address+ "','"+phone+ "')");
			System.out.println("Succesfully inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
