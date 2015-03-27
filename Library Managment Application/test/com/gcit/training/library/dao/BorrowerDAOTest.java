package com.gcit.training.library.dao;


	import static org.junit.Assert.fail;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.gcit.training.library.domain.Borrower;

	public class BorrowerDAOTest {
		
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
				Borrower borrower = new Borrower();
				//Author author = new Author();
				borrower.setBorrowerName("some borrower name");
				borrower.setBorrowerAddress("some address");
				borrower.setBorrowerPhone("91097193");
				//author.setAuthorname("Some new author");
				//new AuthorDAO(conn).Create(author);
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
				fail("Borrower create failed!"); 
			}
		}

		@Test
		public void testUpdate() throws SQLException {
			Borrower borrower = new Borrower();
			borrower.setCardno(1234);
			//Author author = new Author();
			//author.setAuthorid(1);
			borrower.setBorrowerName("some borrower name");
			borrower.setBorrowerPhone("98796");
			//author.setAuthorname("Some other name");
			try {
				
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
				fail("Borrower update failed!"); 
			}
		}

		@Test
		public void testDelete() throws SQLException {
			Borrower borrower = new Borrower();
			borrower.setCardno(1234);
			//author.setAuthorid(1);
			try {
				new BorrowerDAO(conn).delete(borrower);
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				e.printStackTrace();
				fail("Borrower delete failed!"); 
			}
		}
		
		@After
		public void destroy() throws SQLException {
			conn.close();
			conn = null;
		}
	}


