package kosta.mvc.dao;

import java.util.List;

import kosta.mvc.dto.CustomerDTO;

public interface CustomerDAO {
	/**
	 * ���̵� �ߺ�üũ
	 * : true�̸� �ߺ�, false�̸� ��밡��
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
