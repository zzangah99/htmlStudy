package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dao.UserDAO;
import kosta.mvc.dao.UserDAOImpl;
import kosta.mvc.dto.UserDTO;
import kosta.mvc.exception.AuthenticationException;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException, AuthenticationException {
		//dao ȣ��
		UserDTO dbDTO = userDAO.loginCheck(userDTO);
		if(dbDTO == null) {
			throw new AuthenticationException("������ �ٽ� Ȯ�����ּ���");
		}
		
		return dbDTO;
	}

}
