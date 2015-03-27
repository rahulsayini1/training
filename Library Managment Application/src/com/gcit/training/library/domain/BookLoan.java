package com.gcit.training.library.domain;


import java.util.Date;


public class BookLoan extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3851428526784529925L;
	private Date dateout;
	private Date duedate;
	private Book book = new Book();
	private LibraryBranch branch = new LibraryBranch();
	public Date getDateout() {
		return dateout;
	}
	public void setDateout(Date dateout) {
		this.dateout = dateout;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public LibraryBranch getBranch() {
		return branch;
	}
	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}
	public Book getBookid() {
		return bookid;
	}
	public void setBookid(Book bookid) {
		this.bookid = bookid;
	}
	public Borrower getCardno() {
		return cardno;
	}
	public void setCardno(Borrower cardno) {
		this.cardno = cardno;
	}
	private Book bookid = new Book(); 
	private Borrower cardno = new Borrower();
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((cardno == null) ? 0 : cardno.hashCode());
		result = prime * result + ((dateout == null) ? 0 : dateout.hashCode());
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoan other = (BookLoan) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (bookid == null) {
			if (other.bookid != null)
				return false;
		} else if (!bookid.equals(other.bookid))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (cardno == null) {
			if (other.cardno != null)
				return false;
		} else if (!cardno.equals(other.cardno))
			return false;
		if (dateout == null) {
			if (other.dateout != null)
				return false;
		} else if (!dateout.equals(other.dateout))
			return false;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		return true;
	}
	
	
}
