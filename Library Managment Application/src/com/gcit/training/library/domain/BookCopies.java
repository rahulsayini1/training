package com.gcit.training.library.domain;


public class BookCopies extends AbstractDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1526379484607216912L;
	private String noofcopies;
	private Book bookid = new Book();
	private LibraryBranch branch = new LibraryBranch();
	public String getNoofcopies() {
		return noofcopies;
	}
	public void setNoofcopies(String noofcopies) {
		this.noofcopies = noofcopies;
	}
	public Book getBookid() {
		return bookid;
	}
	public void setBookid(Book bookid) {
		this.bookid = bookid;
	}
	public LibraryBranch getBranch() {
		return branch;
	}
	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result
				+ ((noofcopies == null) ? 0 : noofcopies.hashCode());
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
		BookCopies other = (BookCopies) obj;
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
		if (noofcopies == null) {
			if (other.noofcopies != null)
				return false;
		} else if (!noofcopies.equals(other.noofcopies))
			return false;
		return true;
	}
}
