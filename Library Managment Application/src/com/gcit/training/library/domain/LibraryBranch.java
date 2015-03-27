package com.gcit.training.library.domain;

import java.util.ArrayList;
import java.util.List;

import com.gcit.library.training.Borrower;

public class LibraryBranch extends AbstractDomain {
/**
	 * 
	 */
	private static final long serialVersionUID = 176637179336338831L;
private int branchid; 
public int getBranchid() {
	return branchid;
}
public void setBranchid(int branchid) {
	this.branchid = branchid;
}
public String getBranchname() {
	return branchname;
}
public void setBranchname(String branchname) {
	this.branchname = branchname;
}
public String getBranchaddress() {
	return branchaddress;
}
public void setBranchaddress(String branchaddress) {
	this.branchaddress = branchaddress;
}
public List<Book> getBooks() {
	return books;
}
public void setBooks(List<Book> books) {
	this.books = books;
}
public List<Borrower> getBorrowers() {
	return borrowers;
}
public void setBorrowers(List<Borrower> borrowers) {
	this.borrowers = borrowers;
}
private String branchname;
private String branchaddress;
private List<Book> books = new ArrayList<Book>();
private List<Borrower> borrowers = new ArrayList<Borrower>();
}
