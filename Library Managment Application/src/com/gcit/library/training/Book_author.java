package com.gcit.library.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book_author {
public void book_operations()
{
	System.out.println("1. Add a book and author");
	System.out.println("2. Delete a book");
	System.out.println("3. Delete author");
	System.out.println("4.Update a book");
	
	Scanner o = new Scanner(System.in);
	int ip = o.nextInt();
	
	while(ip != 1 && ip != 2 && ip != 3 && ip != 4){
		System.out.println("please enter proper input");
		ip = o.nextInt();
	}
	
	if(ip == 1){
		
Add_book_author aba = new Add_book_author();
aba.addbookauthor();

		}
	if(ip == 2){
		Delete_book db = new Delete_book();
		db.deletebook();
		
	}
	if(ip == 3){
		Delete_author da = new Delete_author();
		da.deleteauthor();
	}
	if(ip == 4){
		
		Update_book_author uba = new Update_book_author();
		uba.updatebookauthor();
		
	}
	

}}
