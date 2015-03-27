package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Author;

public class AuthorDAO extends BaseDAO {
	
	public AuthorDAO(Connection connection){
			this.conn = connection;
			}
	
	public void Create(Author author) throws SQLException{
		save("insert into tbl_author (authorName) values(?)",
				new Object[]{author.getAuthorname()});
	}
	public void update(Author author) throws SQLException{
		save("update tbl_author set authorname = ? where authorid = ?",
				new Object[]{author.getAuthorname(),author.getAuthorid()});
	}
	
 public void delete(Author author) throws SQLException{
	 save("delete from tbl_author where authorid=?",
			 new Object[]{author.getAuthorid()});
 }
	public List<Author> getAll() throws SQLException {
		return (List<Author>) read("select * from tbl_author");
	}

	public Author getOne(int authorId) throws SQLException {
		List<Author> list = (List<Author>) read(
				"select * from tbl_author where authorId = ?",
				new Object[] { authorId });
		
		if(list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Author> mapResult(ResultSet rs) throws SQLException {
		List<Author> list = new ArrayList<Author>();
		while (rs.next()) {
			Author a = new Author();
			a.setAuthorid(rs.getInt("authorId"));
			a.setAuthorname(rs.getString("authorName"));

			list.add(a);
		}
		return list;
	}


}