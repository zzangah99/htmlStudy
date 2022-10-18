package kosta.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.dto.Electronics;
import kosta.mvc.dto.Reply;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.paging.PageCnt;
import kosta.mvc.util.DbUtil;
import oracle.jdbc.proxy.annotation.Pre;

public class ElectronicsDAOImpl implements ElectronicsDAO {
	
	private Properties proFile = new Properties();

	public ElectronicsDAOImpl(){
		try{
			//dbQuery를 준비한 ~.properties 파일을 로딩해서 Properties 자료구조에 저장한다
		
			//현재 프로젝트가 런타임(실행)될 때, 즉 서버가 실행될 때 classes 폴더의 위치를 동적으로 가져와서 경로를 설정해야한다
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("query.select = " + proFile.getProperty("query.select"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Electronics> select() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("query.select");
		List<Electronics> list = new ArrayList<Electronics>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getString(8), rs.getInt(9)));
			}
			
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public List<Electronics> getBoardList(int pageNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("query.pagingSelect"); //select * from (select a.*, rownum rnum from (select * from electronics order by writeday desc) a) where rnum>=? and rnum<=?
		List<Electronics> list = new ArrayList<Electronics>();
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			//전체 레코드 수
			int totalCount = this.getTotalCount(con);
			//전체 페이지 수 (Math.ceil 써도 됨)
			int totalPage = totalCount%PageCnt.pagesize==0 ? totalCount/PageCnt.pagesize : (totalCount/PageCnt.pagesize)+1;
			
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt(totalPage);
			pageCnt.setPageNo(pageNo);
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, ((pageNo-1) * pageCnt.getPagesize()) +1); //시작 
			ps.setInt(2, pageNo * pageCnt.getPagesize()); //끝
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getString(8), rs.getInt(9)));
			}
			
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	
	/**
	 * 전체 레코드 수 검색
	 */
	private int getTotalCount(Connection con) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = proFile.getProperty("query.totalCount"); //select count(*) from Electronics
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			DbUtil.dbClose(null, ps, rs);
		}
		
		return result;
	}
	

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("query.selectBymodelNum");
		Electronics elec = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getString(8), rs.getInt(9));
				
				//해당 elec의 댓글 정보 검색
				elec.setRepliesList(this.getReply(con, modelNum));
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return elec;
	}
	
	
	/**
	 * 댓글 정보 가져오기
	 */
	private List<Reply> getReply(Connection con, String modelNum) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("query.replyByParentNum"); //select * from replies where parent_model_num=?
		List<Reply> list = new ArrayList<Reply>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(reply);
			}
			
		} finally {
			DbUtil.dbClose(null, ps, rs);
		}
		
		return list;
	}
	

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.updateReadnum");
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			
			result = ps.executeUpdate();
		
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	
	@Override
	public int insert(Electronics electronics) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.insert"); //insert into Electronics values(?,?,?,?,?,sysdate,0,?,?)
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, electronics.getModelNum());
			ps.setString(2, electronics.getModelName());
			ps.setInt(3, electronics.getPrice());
			ps.setString(4, electronics.getDescription());
			ps.setString(5, electronics.getPassword());
			ps.setString(6, electronics.getFname());
			ps.setInt(7, electronics.getFsize());
			
			result = ps.executeUpdate();
		
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.delete"); //delete Electronics where model_num=? and password=?
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			ps.setString(2, password);
			
			result = ps.executeUpdate();
		
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = proFile.getProperty("query.update"); //update Electronics set model_name=?,price=?,description=? where model_num=? and password=?
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, electronics.getModelName());
			ps.setInt(2, electronics.getPrice());
			ps.setString(3, electronics.getDescription());
			ps.setString(4, electronics.getModelNum());
			ps.setString(5, electronics.getPassword());
			
			result = ps.executeUpdate();
		
		} finally {
			DbUtil.dbClose(con, ps);
		}
		
		return result;
	}

}
