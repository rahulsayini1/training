package com.gcit.training.library.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.library.domain.Author;
import com.gcit.training.library.domain.Borrower;

public class BorrowerDAO extends BaseDAO {
	
	public BorrowerDAO(Connection connection){
		this.conn = connection;
		}

public void create(Borrower borrower) throws SQLException{
	save("insert into tbl_borrower (Name,address,phone) values(?,?,?)",
			new Object[]{borrower.getBorrowerName(),borrower.getBorrowerAddress(),borrower.getBorrowerPhone()});
}
public void update(Borrower borrower) throws SQLException{
	save("update tbl_borrower set name = ?,address=?,phone=? where cardno = ?",
			new Object[]{borrower.getBorrowerName(),borrower.getBorrowerAddress(),borrower.getBorrowerPhone()});
}
public void delete(Borrower borrower) throws SQLException{
	save("delete from tbl_borrower where cardno=?",
			 new Object[]{borrower.getCardno()});
}
public List<Borrower> getAll() throws SQLException {
	return (List<Borrower>) read("select * from tbl_Borrower");
}

public Borrower getOne(int cardno) throws SQLException {
	List<Borrower> list = (List<Borrower>) read(
			"select * from tbl_Borrower where cardno = ?",
			new Object[] { cardno });
	
	if(list != null && list.size() > 0) {
		return list.get(0);
	} else {
		return null;
	}
}

@Override
public List<Borrower> mapResult(ResultSet rs) throws SQLException {
	List<Borrower> list = new ArrayList<Borrower>();
	while (rs.next()) {
		Borrower a = new Borrower();
		a.setCardno(rs.getInt("cardno"));
		a.setBorrowerName(rs.getString("borrowername"));
		//a.setAuthorid(rs.getInt("authorId"));
		//a.setAuthorname(rs.getString("authorName"));

		list.add(a);
	}
	return list;
}

	
}
