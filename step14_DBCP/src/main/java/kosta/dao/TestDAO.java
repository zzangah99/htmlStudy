package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	/**
	 * SCOTT - EMP ���̺��� ����̸� �˻��ϱ�
	 */
	public List<String> selectByEname() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		String sql = "select ename from emp";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}
}
