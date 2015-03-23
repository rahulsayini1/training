package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Publisher {

	public void publisher_operations() {
		
		System.out.println("1. Insert a publisher");
		System.out.println("2. Update a publisher");
		System.out.println("3. Delete a publisher");
		System.out.println("4. Return to previous menu ");
		Scanner publisherobj = new Scanner(System.in);
		int ch = publisherobj.nextInt();
		
		while(ch != 1 && ch != 2 && ch != 3 && ch != 4){
			System.out.println("please enter proper choice");
			ch = publisherobj.nextInt();
		}
		if(ch ==1){
		System.out.println("enter the Publisher name");
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

	}
		Publisher p = new Publisher();
		p.publisher_operations();}
		if(ch == 2){
			Update_publisher up = new Update_publisher();
			up.update();
		}
		
		if(ch == 3){
			Delete_publisher dp = new Delete_publisher();
			dp.deletepublisher();
		}
		
		if(ch==4)
		{
			Administrator obj = new Administrator();
			obj.admin();
		}
		
	}
	

}
