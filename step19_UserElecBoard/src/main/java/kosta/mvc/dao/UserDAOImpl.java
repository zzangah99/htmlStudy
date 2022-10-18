package kosta.mvc.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.util.DbUtil;

public class UserDAOImpl implements UserDAO {
	private Properties proFile = new Properties();

	public UserDAOImpl(){
		try{
			//dbQuery�� �غ��� ~.properties ������ �ε��ؼ� Properties �ڷᱸ���� �����Ѵ�
		
			//���� ������Ʈ�� ��Ÿ��(����)�� ��, �� ������ ����� �� classes ������ ��ġ�� �������� �����ͼ� ��θ� �����ؾ��Ѵ�
			InputStream is = getClass().getClassLoader().getResourceAsStream("dbQuery.properties");
			proFile.load(is);
			
			System.out.println("query.userlogin = " + proFile.getProperty("query.userlogin"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("query.userlogin");
		UserDTO user = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userDTO.getUserId());
			ps.setString(2, userDTO.getPwd());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return user;
	}

}
