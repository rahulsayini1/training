package com.gcit.training.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Author extends AbstractDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1194865907519644789L;
	private int authorid;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	private String authorname;
	private List<Book> books = new ArrayList<Book>();
}