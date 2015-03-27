package com.gcit.training.library.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.gcit.training.library.domain.Genre;

public class GenreDAOTest {
	
private Connection conn;
	
	@Before
	public void init() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/library", "root", "root");
			conn.setAutoCommit(false);
		} catch(Exception e) {
			e.printStackTrace();
			fail("No connection!");
		}
	}

	@Test
	public void testCreate() throws SQLException {
		try {
			Genre genre = new Genre();
			//Author author = new Author();
			genre.setGenre_name("some genre name");
			//author.setAuthorname("Some new author");
			new GenreDAO(conn).create(genre);
			//new AuthorDAO(conn).Create(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("genre create failed!"); 
		}
	}

	@Test
	public void testUpdate() throws SQLException {
		Genre genre = new Genre();
		//Author author = new Author();
		genre.setGenre_id(1);
		//author.setAuthorid(1);
		//author.setAuthorname("Some other name");
		try {
			new GenreDAO(conn).update(genre);
			//new AuthorDAO(conn).update(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Genre update failed!"); 
		}
	}

	@Test
	public void testDelete() throws SQLException {
		Genre genre = new Genre();
		//Author author = new Author();
		genre.setGenre_id(1);
		//author.setAuthorid(1);
		try {
			new GenreDAO(conn).delete(genre);
			//new AuthorDAO(conn).delete(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Genre delete failed!"); 
		}
	}
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}


}
