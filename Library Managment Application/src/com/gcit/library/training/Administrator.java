package com.gcit.library.training;

import java.util.Scanner;

public class Administrator {
public void admin()
{
	System.out.println("Please Select from the list below");
			System.out.println("1.Book and Author");
			System.out.println("2.Publisher");
			System.out.println("3.Library Branches");
			System.out.println("4.Borrowers");
			System.out.println("5.Book Loan");
			System.out.println("6. Exit back");
			
			Scanner obj = new Scanner(System.in);
			int input = obj.nextInt();
			
			if(input == 1){
				Book_author book = new Book_author();
				book.book_operations();
			}
			if(input == 2){
				Publisher p = new Publisher();
				p.publisher_operations();
			}
			if(input == 3){
				Library_branches lb = new Library_branches();
				lb.librarybranches();
				
			}
			if(input == 4){
				Library_borrower lb = new Library_borrower();
				lb.borrower();
			}
			if(input == 5){}
			if(input == 6){
				Manage ob = new Manage();
				ob.manage();
			}
			
			
			
			
}
}
