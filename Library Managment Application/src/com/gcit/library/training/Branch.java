package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Branch {
public void branch(){
	
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			PreparedStatement stmt = conn.prepareStatement("select branchid,branchname from tbl_library_branch");
			ResultSet rs = stmt.executeQuery();
			List<String> results = new ArrayList<String>();
			while (rs.next()) {
				
				results.add(rs.getString(1));
				System.out.println("Branch id:" + rs.getString(1)+ " Branchname : " + rs.getString(2));
				}
			System.out.println("Select the branchid from the list ");
			Scanner obj = new Scanner(System.in);
			String branch_id = obj.next();
			
			/*while(branch_id != rs.getInt(1)){
				System.out.println("please enter proper branch id");
				branch_id = obj.nextInt();
			}*/
			while(results.contains(branch_id)){
			University_Library_boston ulb = new University_Library_boston();
			ulb.selection(branch_id);}
			Branch b = new Branch();
			b.branch();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
}}