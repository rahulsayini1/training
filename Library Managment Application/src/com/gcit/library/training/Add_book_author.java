package com.gcit.library.training;

import java.awt.image.TileObserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Add_book_author {
	
public void addbookauthor(){
	System.out.println("1. Add book");
	System.out.println("2. Add Author");
	
	Scanner obj = new Scanner(System.in);
	
	int ch = obj.nextInt();
	while(ch !=1 && ch != 2){
		System.out.println("please enter valid input");
	ch = obj.nextInt();}
	
	if(ch == 1){
	try {
		System.out.println("Enter book title name");
		String title = obj.next();
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		PreparedStatement stmt = conn.prepareStatement("select publisherid,publishername from tbl_publisher");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("publisher id  " +rs.getString(1)+"publisher name " +rs.getString(2) );
		}
		
		System.out.println("enter publisher id from the above list");
		String publisherid = obj.next();
		
		stmt = conn.prepareStatement("insert into tbl_book (title,pubid) values (?,?)");
		stmt.setString(1, title);
		stmt.setString(2, publisherid);
		stmt.executeUpdate();
		
		System.out.println("inserted succesfully");
	
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e. printStackTrace();

	}}
	if(ch == 2){
		try{
		System.out.println("Enter the author name");
		String name = obj.next();
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		PreparedStatement stmt = conn.prepareStatement("insert into tbl_author (authorname) values (?)");
		stmt.setString(1, name);
		stmt.executeUpdate();
		System.out.println("author inserted succesfully");
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e. printStackTrace();

	}
		}
	
	Administrator obj1 = new Administrator();
	obj1.admin();
	}
}
	
