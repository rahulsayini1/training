package com.gcit.library.training;

import java.util.Scanner;

public class University_Library_boston {
	public void selection(int branch_id)
	{
		System.out.println("1)Update the details of the library");
		System.out.println("2)Add copies of Book to the Branch");
		System.out.println("3)Quit to previous");
		Scanner ip = new Scanner(System.in);
		int choice = ip.nextInt();
		while(choice != 1 && choice != 2 && choice != 3){
			System.out.println("please enter proper choice");
			choice = ip.nextInt();
		}
		if(choice == 1){}
		if(choice == 2){
			AddCopiesBookBranch obj = new AddCopiesBookBranch();
			obj.addcopies(branch_id);
		}
		if(choice == 3){}
	}

}
