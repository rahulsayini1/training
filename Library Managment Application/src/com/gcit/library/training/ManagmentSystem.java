package com.gcit.library.training;

import java.util.Scanner;

public class ManagmentSystem {
	public static void main(String[] args){  
		Manage obj = new Manage();
		obj.manage();
	}}

class Manage{
	
	public void manage()
	{
		
		Scanner ipobj = new Scanner(System.in);	
		System.out.println("1) Librarian ");
		System.out.println("2) Administrator ");
		System.out.println("3) Borrower ");
		
		int input = ipobj.nextInt();
		if(input == 1)
		{
			Librarian librarian = new Librarian();
			librarian.librarianmenu();
		}
		if(input == 2){
			
		}
		if(input == 3){
			Borrower obj = new Borrower();
			obj.borrower();
		}
		while (input != 1 && input != 2 & input != 3)
			System.out.println("please enter proper input");
			input = ipobj.nextInt();
	}
	
	
}
