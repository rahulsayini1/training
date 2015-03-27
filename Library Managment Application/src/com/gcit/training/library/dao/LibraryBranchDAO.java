package com.gcit.training.library.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.List;

import com.gcit.training.library.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO{
	
	public LibraryBranchDAO(Connection connection){
		this.conn = connection;
		}

		public void create(LibraryBranch libraryBranch) throws SQLException{
			save("insert into tbl_library_branch (branchname,branchaddress) values(?,?)",
					new Object[]{libraryBranch.getBranchname(),libraryBranch.getBranchaddress()});
		}
		public void update(LibraryBranch libraryBranch) throws SQLException{
			save("update tbl_library_branch set branchname=?,branchaddress=? where branchid = ?",
					new Object[]{libraryBranch.getBranchname(),libraryBranch.getBranchaddress(),libraryBranch.getBranchid()});

		}
		public void delete(LibraryBranch libraryBranch) throws SQLException{
			save("delete from tbl_library_branch where branchid=?",
					 new Object[]{libraryBranch.getBranchid()});
		}

		@Override
		public List<?> mapResult(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
}
