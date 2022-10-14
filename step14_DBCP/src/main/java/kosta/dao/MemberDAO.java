package kosta.dao;

import java.util.List;

import kosta.dto.Member;

public interface MemberDAO {
	/**
	 * 전체검색
	 * : select * from member order by join_date desc
	 */
	List<Member> selectAll();
	
	
	/**
	 * 등록하기
	 * : insert into member(id,pwd,name,age,phone,addr, join_date)
		values(?,?,?,?,?,?, sysdate)
	 */
	int insert(Member member);
	
	
	/**
	 * id 중복체크
	 * @return : true이면 중복, false이면 중복이 아니다
	 * : select id from member where id=?
	 */
	boolean duplicateCheckById(String id);
	
	
	/**
	 * 삭제하기
	 * : delete from member where id=?
	 */
	int delete(String id);
	
	
	/**
	 * 상세보기
	 * : select * from member where id=?
	 */
	Member selectById(String id);
	
	
	/**
	 * 조건검색
	 * (검색필드와 검색단어를 전달받아 검색필드에 검색단어를 포함한 레코드 검색)
	 * : select * from member where id like ?
	 * : select * from member where name like ?
	 * : select * from member where addr like ?
	 */
	List<Member> searchByKeyWord(String keyField, String keyWord);
}
