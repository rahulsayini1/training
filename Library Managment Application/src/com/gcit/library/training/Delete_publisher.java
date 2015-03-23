package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_publisher {
 public void deletepublisher(){
	 try{
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			
			PreparedStatement stmt = conn.prepareStatement("select publisherid,publishername from tbl_publisher");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				System.out.println(" publisher id " +rs.getString(1) + " publisher name " +rs.getString(2));
			}
			
			System.out.println("select the publisher id you want to delete");
			Scanner scan = new Scanner(System.in);
			String publisherid = scan.next();
			
			stmt = conn.prepareStatement("delete from tbl_publisher where publisherid=?");
			stmt.setString(1, publisherid);
			stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
}
