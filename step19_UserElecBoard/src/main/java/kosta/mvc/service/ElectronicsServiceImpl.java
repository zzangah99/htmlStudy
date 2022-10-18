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
		List<Electronics> list = elecDAO.getBoardList(pageNo);//페이징 처리하는 dao 호출
		
		return list;
	}

	@Override
	public void insert(Electronics electronics) throws SQLException {
		int result = elecDAO.insert(electronics);
		if(result == 0) {
			throw new SQLException("입력에 실패하였습니다.");
		}
	}

	@Override
	public Electronics selectByModelnum(String modelNum, boolean flag) throws SQLException {
		if(flag) {
			if(elecDAO.increamentByReadnum(modelNum) == 0) { //조회수 증가 여부
				throw new SQLException("조회수 증가 오류로 검색할 수 없습니다");
			}
		}
		
		Electronics elec = elecDAO.selectByModelNum(modelNum);
		if(elec == null) {
			throw new SQLException("상세보기에 오류가 발생했습니다");
		}
		
		return elec;
	}

	@Override
	public void delete(String modelNum, String password, String saveDir) throws SQLException {
		Electronics dbElec = elecDAO.selectByModelNum(modelNum);
		
		if(dbElec == null) {
			throw new SQLException("모델번호 오류로 삭제할 수 없습니다");
		} else if(!dbElec.getPassword().equals(password)){
			throw new SQLException("비밀번호를 다시 확인해주세요");
		}

		if(elecDAO.delete(modelNum, password) == 0) {
			throw new SQLException("삭제에 실패하였습니다");
		}
		
		//삭제가 되었을 때 첨부파일이 있는 경우는 save 폴더에서 파일도 삭제한다
		if(dbElec.getFname()!=null) {
			String fileName = saveDir + "/" + dbElec.getFname();
			new File(fileName).delete();
		}
	}

	@Override
	public void update(Electronics electronics) throws SQLException {
		//비밀 번호 검증 - 전달된 비번과 DB에 저장된 비번이 일치하는지 체크
		Electronics dbElec = elecDAO.selectByModelNum(electronics.getModelNum());
		
		if(dbElec == null) {
			throw new SQLException("모델번호 오류로 수정할 수 없습니다");
		} else if(!dbElec.getPassword().equals(electronics.getPassword())){
			throw new SQLException("비밀번호를 다시 확인해주세요");
		}
		
		if(elecDAO.update(electronics)==0) {
			throw new SQLException("수정에 실패하였습니다");
		}
	}

}
