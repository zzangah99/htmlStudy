 package kosta.mvc.service;

import java.sql.SQLException;

import kosta.mvc.dto.UserDTO;
import kosta.mvc.exception.AuthenticationException;

public interface UserService {
	/**
	 * �α��� üũ
	 * */
   UserDTO loginCheck(UserDTO userDTO)throws SQLException , AuthenticationException;
}
