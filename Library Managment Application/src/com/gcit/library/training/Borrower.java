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

public class Borrower {

	public void borrower(){
		System.out.println("Enter the card number");
		Scanner obj = new Scanner(System.in);
		String card_no = obj.next();
		
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", "root", "root");
			PreparedStatement stmt = conn.prepareStatement("select cardno from tbl_borrower");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				List<String> results = new ArrayList<String>();
				results.add(rs.getString(1));
				while(results.contains(card_no)) {
				System.out.println("1) Check out a book ");
				System.out.println("2) Return a Book ");
				System.out.println("3) Quit to Previous");
				System.out.println("please enter the choice");
				int choice = obj.nextInt(); 
				if(choice == 1){
					 Check_out co = new Check_out();
					 co.checkout(card_no);
				}
				if(choice == 2){
					Return_book rb = new Return_book();
					rb.returnbook(card_no);
				}
				if(choice == 3){
					Manage o = new Manage();
					o.manage();
				}
				
			}
				/**/
				
				}
			
			Borrower b = new Borrower();
			b.borrower();}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
