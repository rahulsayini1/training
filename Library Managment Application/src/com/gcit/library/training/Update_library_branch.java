package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_library_branch {
public void updatelibraybranch()
{
	try {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		PreparedStatement stmt = conn
				.prepareStatement("select branchid,branchname,branchaddress from tbl_library_branch");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()){
			System.out.println("Branch id "+rs.getString(1)+" Branch name " +rs.getString(2)+" Branch address "+rs.getString(3) );
		}
		System.out.println("please enter the new branch id you want to update");
		Scanner obj = new Scanner(System.in);
		String branch_id = obj.next();
		System.out.println("please enter branch name");
		String name = obj.next();
		System.out.println("Please enter new Branch address");
		String add = obj.next();
		
		stmt = conn.prepareStatement("update tbl_library_branch set branchname=?,branchaddress=? where branchid = ?");
		stmt.setString(1, name);
		stmt.setString(2, add);
		stmt.setString(3, branch_id);
		stmt.executeUpdate();
		System.out.println("Successfully updated");
}catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	Administrator obj = new Administrator();
	obj.admin();	
}}
