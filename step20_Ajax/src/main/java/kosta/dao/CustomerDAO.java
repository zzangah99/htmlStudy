package kosta.dao;

import java.util.List;
import kosta.dto.CustomerDTO;

public interface CustomerDAO {
	/**
	 * ���̵� �ߺ�üũ
	 * */
	boolean idCheck(String id);
	
	/**
	 * Customer ����ϱ�
	 * */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * ��ü Customer �˻��ϱ�
	 * */
	List<CustomerDTO> selectAll();
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	int delete(String id);
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	int update(CustomerDTO customerDTO);

}
