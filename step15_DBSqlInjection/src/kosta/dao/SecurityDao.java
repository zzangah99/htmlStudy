package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SecurityDao {

	 /**
	  * 1. Statement인경우
	  * */
	public List<String> statementSelect(String empno){ // 5000 or 1=1
		Connection con=null;
		Statement st =null;
		ResultSet rs=null;
		List<String> list =new ArrayList<>();
		try{
			con = DBUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select ename from emp where empno="+empno);
		    while(rs.next()){
		    	list.add(rs.getString(1));
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, st, rs);
		}
		return list;
	}
	
	/**
	 * 2.PreparedStatement인 경우
	 * */
	public List<String> preparedSelect(String empno){
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		List<String> list =new ArrayList<>();
		try{
			con = DBUtil.getConnection();
			ps = con.prepareStatement("select ename from emp where empno=?");
			ps.setString(1, empno);
			rs = ps.executeQuery();
		    while(rs.next()){
		    	list.add(rs.getString(1));
		    }
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}






