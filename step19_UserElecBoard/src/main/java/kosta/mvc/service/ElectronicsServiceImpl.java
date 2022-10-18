package kosta.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import kosta.mvc.dao.ElectronicsDAO;
import kosta.mvc.dao.ElectronicsDAOImpl;
import kosta.mvc.dto.Electronics;
import kosta.mvc.exception.AuthenticationException;

public class ElectronicsServiceImpl implements ElectronicsService {
	private ElectronicsDAO elecDAO = new ElectronicsDAOImpl();

	@Override
	public List<Electronics> select() throws SQLException {
		List<Electronics> list = elecDAO.select();
		
		
		return list;
	}

	@Override
	public List<Electronics> select(int pageNo) throws SQLException {
		List<Electronics> list = elecDAO.getBoardList(pageNo);//����¡ ó���ϴ� dao ȣ��
		
		return list;
	}

	@Override
	public void insert(Electronics electronics) throws SQLException {
		int result = elecDAO.insert(electronics);
		if(result == 0) {
			throw new SQLException("�Է¿� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException {
		if(flag) {
			if(elecDAO.increamentByReadnum(modelNum) == 0) { //��ȸ�� ���� ����
				throw new SQLException("��ȸ�� ���� ������ �˻��� �� �����ϴ�");
			}
		}
		
		Electronics elec = elecDAO.selectByModelNum(modelNum);
		if(elec == null) {
			throw new SQLException("�󼼺��⿡ ������ �߻��߽��ϴ�");
		}
		
		return elec;
	}

	@Override
	public void delete(String modelNum, String password, String saveDir) throws SQLException {
		Electronics dbElec = elecDAO.selectByModelNum(modelNum);
		
		if(dbElec == null) {
			throw new SQLException("�𵨹�ȣ ������ ������ �� �����ϴ�");
		} else if(!dbElec.getPassword().equals(password)){
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���");
		}

		if(elecDAO.delete(modelNum, password) == 0) {
			throw new SQLException("������ �����Ͽ����ϴ�");
		}
		
		//������ �Ǿ��� �� ÷�������� �ִ� ���� save �������� ���ϵ� �����Ѵ�
		if(dbElec.getFname()!=null) {
			String fileName = saveDir + "/" + dbElec.getFname();
			new File(fileName).delete();
		}
	}

	@Override
	public void update(Electronics electronics) throws SQLException {
		//��� ��ȣ ���� - ���޵� ����� DB�� ����� ����� ��ġ�ϴ��� üũ
		Electronics dbElec = elecDAO.selectByModelNum(electronics.getModelNum());
		
		if(dbElec == null) {
			throw new SQLException("�𵨹�ȣ ������ ������ �� �����ϴ�");
		} else if(!dbElec.getPassword().equals(electronics.getPassword())){
			throw new SQLException("��й�ȣ�� �ٽ� Ȯ�����ּ���");
		}
		
		if(elecDAO.update(electronics)==0) {
			throw new SQLException("������ �����Ͽ����ϴ�");
		}
	}

}
