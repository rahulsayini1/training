package com.gcit.training.library.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gcit.training.library.domain.Author;

public class AuthorDAOTest {
	
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
			Author author = new Author();
			author.setAuthorname("Some new author");
			new AuthorDAO(conn).Create(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Author create failed!"); 
		}
	}

	@Test
	public void testUpdate() throws SQLException {
		Author author = new Author();
		author.setAuthorid(1);
		author.setAuthorname("Some other name");
		try {
			new AuthorDAO(conn).update(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Author update failed!"); 
		}
	}

	@Test
	public void testDelete() throws SQLException {
		Author author = new Author();
		author.setAuthorid(1);
		try {
			new AuthorDAO(conn).delete(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Author delete failed!"); 
		}
	}
	
	@Test
	public void testgetAll() throws SQLException {
		try {
			new AuthorDAO(conn).getAll();
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Author get failed!"); 
		}
	}
	
	
	@Test
	public void testgetOne() throws SQLException {
		try {
			new AuthorDAO(conn).getOne(1);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Author get failed!"); 
		}
	}
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}
