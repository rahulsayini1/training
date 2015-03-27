package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Book;

public class BookDAO extends BaseDAO {

	public BookDAO(Connection connection) {
		this.conn = connection;
	}

	public void create(Book book) throws SQLException {
		int bookId = -1;
		if (book.getPublisher() == null) {
			bookId = saveReturnGen(
					"insert into tbl_book (title, pubId) values (?,?)",
					new Object[] { book.getTitle(), null });
		} else {
			bookId = saveReturnGen(
					"insert into tbl_book (title, pubId) values (?,?)",
					new Object[] { book.getTitle(),
							book.getPublisher().getPublisherid() });
		}

		if (book.getAuthors() != null && book.getAuthors().size() > 0) {
			for (Author a : book.getAuthors()) {
				save("insert into tbl_book_authors (bookId, authorId) values (?,?)",
						new Object[] { bookId, a.getAuthorid() });
			}
		}
	}

	public void update(Book book) throws SQLException {
		save("update tbl_book set title = ? where bookid = ?",
				new Object[]{book.getTitle(), book.getBookId()});
	}

	public void delete(Book book) throws SQLException {
		save("delete from tbl_book where bookid=?",
				 new Object[]{book.getBookId()});
	}

	public List<Book> getAll() throws SQLException {
		return (List<Book>) read("select * from tbl_book");
	}

	public Book getOne(int bookId) throws SQLException {
		List<Book> list = (List<Book>) read(
				"select * from tbl_book where bookId = ?",
				new Object[] { bookId });
		
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Book> mapResult(ResultSet rs) throws SQLException {
		List<Book> list = new ArrayList<Book>();
		while (rs.next()) {
			Book a = new Book();
			a.setBookId(rs.getInt("bookId"));
			a.setTitle(rs.getString("title"));

			list.add(a);
		}
		return list;
	}


}
