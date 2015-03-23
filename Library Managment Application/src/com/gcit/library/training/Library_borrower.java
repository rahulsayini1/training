package com.gcit.library.training;

import java.util.Scanner;

public class Library_borrower {
public void borrower()
{
	System.out.println("1. Add a borrower");
	System.out.println("2. Update a borrower");
	System.out.println("3.Delete a borrower");
	
	Scanner scan = new Scanner(System.in);
	System.out.println("please enter the choice ");
	int ch = scan.nextInt();
	while(ch != 1 && ch != 2 && ch!=3)
	{System.out.println("enter correct choice");
	ch = scan.nextInt();}
	if(ch == 1){
		Add_borrower ab = new Add_borrower();
		ab.addborrower();
	}
	if(ch == 2){
		Update_borrower ub = new Update_borrower();
		ub.updateborrower();
	}if(ch == 3){
		Delete_borrower db = new Delete_borrower();
		db.deleteborrower();
	}
	}
	
}

