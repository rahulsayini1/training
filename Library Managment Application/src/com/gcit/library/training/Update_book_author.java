package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_book_author {
 public void updatebookauthor()
 {
	 System.out.println("1. Update book");
	 System.out.println("2. Update Author");
	 Scanner obj = new Scanner(System.in);
	 
	 System.out.println("enter the Choice");
	 int ch = obj.nextInt();
	 while(ch != 1 && ch != 2){
		 System.out.println("please enter proper choice");
		 ch = obj.nextInt();
	 }
	 if(ch ==1)
	 {
		 try {
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/library", "root", "root");
				PreparedStatement stmt = conn.prepareStatement("select bookid,title from tbl_book");
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					System.out.println("Book id : " + rs.getString(1)+ "title : "+ rs.getString(2));
				}
				
				System.out.println(" the bookid to update the title");
				String bookid = obj.next();
				 System.out.println("Select the new title name");
				 String title = obj.next();
				 
				 stmt = conn.prepareStatement("update tbl_book set title=? where bookid = ?");
				 stmt.setString(1, title);
				 stmt.setString(2, bookid);
				 stmt.executeUpdate();
				 
				 System.out.println("succesfully updated");
				
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e. printStackTrace();

			}
	 }
	 if(ch ==2){
		 try {
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/library", "root", "root");
				PreparedStatement stmt = conn.prepareStatement("select authorid,authorname from tbl_author");
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()){
					System.out.println("Author id : " + rs.getString(1)+ "Author name : "+ rs.getString(2));
				}
				
				System.out.println(" the Author id to update the Author name");
				String authorid = obj.next();
				 System.out.println("Select the new Author name");
				 String author = obj.next();
				 
				 stmt = conn.prepareStatement("update tbl_author set authorname=? where authorid = ?");
				 stmt.setString(1, author);
				 stmt.setString(2, authorid);
				 stmt.executeUpdate();
				 
				 System.out.println("succesfully updated");
				
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e. printStackTrace();

			}
		 
	 }
 }
}
