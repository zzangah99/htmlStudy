package ex1006.dto;

public class BoardDTO {
	private int no;
	private String subject;
	
	public BoardDTO() {
		
	}

	public BoardDTO(int no, String subject) {
		super();
		this.no = no;
		this.subject = subject;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
