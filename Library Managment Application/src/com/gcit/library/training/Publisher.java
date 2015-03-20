package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Publisher {

	public static void main(String[] args) {
		System.out.println("enter the Publisher name");
		Scanner publisherobj = new Scanner(System.in); 
		String publishername = publisherobj.next();
		System.out.println("enter publisher address");
		String publisheraddress = publisherobj.next();
		System.out.println("enter publisher phone");
		String publisherphone = publisherobj.next();
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO tbl_publisher (publishername,publisheraddress,publisherphone) VALUES ('"+publishername+"','"+publisheraddress+"','"+publisherphone+"')");
			System.out.println("successfully inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}}

}
