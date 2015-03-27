package com.gcit.training.library.dao;

import static org.junit.Assert.fail;
import com.gcit.training.library.domain.Publisher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class PublisherDAOTest  {
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
			Publisher publisher = new Publisher();
			publisher.setPublishername("some publisher name");
			publisher.setPublisheraddress("some publisher address");
			publisher.setPublisherphone("873");
			new PublisherDAO(conn).create(publisher);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Publisher create failed!"); 
		}
	}

	@Test
	public void testUpdate() throws SQLException {
		Publisher publisher = new Publisher();
		publisher.setPublisherid(1);
		publisher.setPublishername("publisher name");
		publisher.setPublisheraddress("publisher address");
		publisher.setPublisherphone("98687");
		try {
			new PublisherDAO(conn).update(publisher);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Publisher update failed!"); 
		}
	}

	@Test
	public void testDelete() throws SQLException {
		Publisher publisher = new Publisher();
		publisher.setPublisherid(1);
		try {
			new PublisherDAO(conn).delete(publisher);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
			fail("Publisher delete failed!"); 
		}
	}
	
	@After
	public void destroy() throws SQLException {
		conn.close();
		conn = null;
	}
}
