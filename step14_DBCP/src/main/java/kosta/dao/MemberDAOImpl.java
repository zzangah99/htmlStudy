package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kosta.dto.Member;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<Member> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member order by join_date desc";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return list;
	}

	@Override
	public int insert(Member member) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "insert into member(id,pwd,name,age,phone,addr, join_date) values(?,?,?,?,?,?, sysdate)";
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getAddr());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public boolean duplicateCheckById(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		boolean result = false;
		String sql = "select id from member where id=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return result;
	}

	@Override
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from member where id=?";
		int result=0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public Member selectById(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		Member member = null;
		String sql = "select * from member where id=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return member;
	}

	@Override
	public List<Member> searchByKeyWord(String keyField, String keyWord) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member where ";
		
		try {
			switch(keyField) {
			case "id" : sql += "id like ?"; break;
			case "name" : sql += "name like ?"; break;
			case "addr" : sql += "addr like ?"; break;
			}
			
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + keyWord + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

}
