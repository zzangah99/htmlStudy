package ex1011.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log = LogFactory.getLog(super.getClass());
	
	public static void main(String[] arags) {
		System.out.println("--- ���� ���� ----");
		
		LogTest t = new LogTest();
		t.test();
		
		System.out.println("--- ���� �� ---");
	}
	
	public void test() {
		//�α� ���
		log.trace("trace�� ���õ� �α��Դϴ�");
		log.debug("debug�� ���õ� �α��Դϴ�");
		log.info("info�� ���õ� �α��Դϴ�");
		log.warn("warn�� ���õ� �α��Դϴ�");
		log.error("error�� ���õ� �α��Դϴ�");
		log.fatal("fatal�� ���õ� �α��Դϴ�");
	}
}
