package com.gcit.library.training;

import java.util.Scanner;

public class Librarian {

	public void librarianmenu(){
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Enter the Branch manage");
		System.out.println("2.Quit ");
		int input = scan.nextInt();
		while(input != 1 && input != 2){
			System.out.println("please enter proper input");
			input = scan.nextInt();
		}
		if(input == 1){
			Branch branch = new Branch();
			branch.branch();
		}
		if(input == 2)
			{
			Manage obj = new Manage();
			obj.manage();
			}
	}
	
}
