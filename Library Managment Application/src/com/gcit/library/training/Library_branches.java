package com.gcit.library.training;

import java.util.Scanner;

public class Library_branches {
public void librarybranches(){
	System.out.println("1. Add a Library branch");
	System.out.println("2. Delete Library");
	System.out.println("3.Update a library");
	
	Scanner o = new Scanner(System.in);
	int ip = o.nextInt();
	
	if(ip == 1){
		Add_library_branch alb = new Add_library_branch();
		alb.addlibrary();
	}
	if(ip == 2){
		Delete_library dl = new Delete_library();
		dl.deletelibrary();
	}
	if(ip == 3){
		Update_library_branch ul = new Update_library_branch();
		ul.updatelibraybranch();
	}
}
}
