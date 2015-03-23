package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete_library {
public void deletelibrary(){
	try{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library", "root", "root");
		
		PreparedStatement stmt = conn.prepareStatement("select branchid,branchname from tbl_library_branch");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			System.out.println("Branch id" +rs.getString(1) + " Branch name " +rs.getString(2));
		}
		
		System.out.println("select the branch id you want to delete");
		Scanner scan = new Scanner(System.in);
		String branchid = scan.next();
		
		stmt = conn.prepareStatement("delete from tbl_library_branch where branchid=?");
		stmt.setString(1, branchid);
		stmt.executeUpdate();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
