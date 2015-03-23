package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_library {
	@SuppressWarnings("resource")
	public void updatedetails(String branch_id){
		Scanner titleobj = new Scanner(System.in);
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			PreparedStatement stmt = conn
					.prepareStatement("select branchname,branchaddress from tbl_library_branch where branchid = ?");
			stmt.setString(1, branch_id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				System.out.println("Branch name " +rs.getString(1)+" Branch address "+rs.getString(2) );
			}
			System.out.println("please enter the new branch name");
			Scanner obj = new Scanner(System.in);
			String branch_name = obj.next();
			System.out.println("please enter new branch address");
			String branch_address = obj.next();
			String str = "n/a";
			
			if(branch_name == str && branch_address == str){
				System.out.println("No change");
			}
			
			if(branch_name == str  && branch_address == str){
				stmt =conn.prepareStatement("update tbl_library_branch set branchaddress = ? where branchid = ?");
				stmt.setString(1, branch_address);
				stmt.setString(2,branch_id);
				stmt.executeUpdate();
				System.out.println("successfully executed");
				}
			
			if(branch_name != str  && branch_address == str){
				stmt =conn.prepareStatement("update tbl_library_branch set branchname = ? where branchid = ?");
				stmt.setString(1, branch_name);
				stmt.setString(2,branch_id);
				stmt.executeUpdate();
				System.out.println("successfully executed");
				}
			
			else{
			stmt =conn.prepareStatement("update tbl_library_branch set branchname = ?,branchaddress = ? where branchid = ?");
			stmt.setString(1, branch_name);
			stmt.setString(2, branch_address);
			stmt.setString(3,branch_id);
			stmt.executeUpdate();
			System.out.println("successfully executed");
			}
			
			University_Library_boston ulb = new University_Library_boston();
			ulb.selection(branch_id);

	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

}}
