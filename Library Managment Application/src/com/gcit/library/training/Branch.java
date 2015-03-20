package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Branch {
public void branch(){
	
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select branchid,branchname from tbl_library_branch");

			while (rs.next()) {
				//System.out.println("#################");
				System.out.println("Branch id:" + rs.getInt("branchid")+ " Branchname :" + rs.getString("branchname"));
				//System.out.println("######################");
				

			}
			Scanner scan = new Scanner(System.in);
			System.out.println("please enter the branch id from the above list");
			int branch_num = scan.nextInt();
			while(rs.next())
			while(branch_num != rs.getInt("branchid")){
				System.out.println("please enter proper branch id");
			}
			University_Library_boston ul = new University_Library_boston();
			ul.selection(branch_num);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
}}