package com.gcit.training.library.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.gcit.training.library.domain.LibraryBranch;

public class LibraryBranchDAOTest {
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
			LibraryBranch librarybranch = new LibraryBranch();
			librarybranch.setBranchname("some branch name");
			librarybranch.setBranchaddress("some address");
			new LibraryBranchDAO(conn).create(librarybranch);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("LibraryBranch create failed!"); 
		}
	}

	@Test
	public void testUpdate() throws SQLException {
		LibraryBranch librarybranch = new LibraryBranch();
		librarybranch.setBranchid(1);
		librarybranch.setBranchname("some branch name");
		librarybranch.setBranchaddress("some address");
		try {
			new LibraryBranchDAO(conn).update(librarybranch);
			//new AuthorDAO(conn).update(author);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("LibraryBranch update failed!"); 
		}
	}

	@Test
	public void testDelete() throws SQLException {
		LibraryBranch librarybranch = new LibraryBranch();
		//Author author = new Author();
		librarybranch.setBranchid(1); 
		//genre.setGenre_id(1);
		//author.setAuthorid(1);
		try {
			new LibraryBranchDAO(conn).delete(librarybranch);
			//new GenreDAO(conn).delete(genre);
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
