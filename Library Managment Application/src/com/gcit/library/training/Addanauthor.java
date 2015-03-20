package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Addanauthor {

	public static void main(String[] args) {
		System.out.println("enter the author name");
		Scanner authorobj = new Scanner(System.in); 
		String authorname = authorobj.nextLine();
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO tbl_author (authorName) VALUES ('"+authorname+"')");
			System.out.println("Succesfully inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}

}}
