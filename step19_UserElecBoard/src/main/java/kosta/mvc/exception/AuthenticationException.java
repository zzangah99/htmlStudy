package kosta.mvc.exception;

/**
 * �α��� �� �� ���, �н����尡 Ʋ���� ������ ������ �� �߻��ϴ� ����
 */
public class AuthenticationException extends Exception {
	public AuthenticationException() {}
	public AuthenticationException(String message) {
		super(message);
	}
}
