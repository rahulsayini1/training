package com.gcit.training.library.domain;

import java.util.ArrayList;
import java.util.List;

public class Genre extends AbstractDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1232130749029678804L;
	private int genre_id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + genre_id;
		result = prime * result
				+ ((genre_name == null) ? 0 : genre_name.hashCode());
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
		Genre other = (Genre) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (genre_id != other.genre_id)
			return false;
		if (genre_name == null) {
			if (other.genre_name != null)
				return false;
		} else if (!genre_name.equals(other.genre_name))
			return false;
		return true;
	}
	public int getGenre_id() {
		return genre_id;
	}
	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}
	public String getGenre_name() {
		return genre_name;
	}
	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	private String genre_name;
	private List<Book> books = new ArrayList<Book>();
	
}
