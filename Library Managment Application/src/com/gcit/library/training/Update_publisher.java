package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_publisher {

	public void update()
	{
		try{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		PreparedStatement stmt = conn.prepareStatement("select publisherid,publishername,publisheraddress,publisherphone from tbl_publisher");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("Publisher id  "+rs.getString(1)+ "   Publisher name "+ rs.getString(2)+"  publisher Address  "+ rs.getString(3)+ "   publisher phone  "+rs.getString(4));
		}
		
		System.out.println("select the publisher id to whom you want to update values");
		Scanner scan = new Scanner(System.in);
		String id = scan.next();
		
		System.out.println("enter the new publisher name");
		String name = scan.next();
		System.out.println("enter new publisher address");
		String add = scan.next();
		System.out.println("enter new publisher phone ");
		String phn = scan.next();
		
		stmt = conn.prepareStatement("update tbl_publisher set publishername = ?, publisheraddress = ?, publisherphone = ? where publisherid = ?");
		stmt.setString(1, name);
		stmt.setString(2, add);
		stmt.setString(3, phn);
		stmt.setString(4,id);
		stmt.executeUpdate();
		
		System.out.println("succesfully updates");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e. printStackTrace();

	}
		Publisher p = new Publisher();
		p.publisher_operations();
	
	}}
