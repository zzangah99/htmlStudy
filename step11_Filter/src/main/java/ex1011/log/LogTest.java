package ex1011.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log = LogFactory.getLog(super.getClass());
	
	public static void main(String[] arags) {
		System.out.println("--- 메인 시작 ----");
		
		LogTest t = new LogTest();
		t.test();
		
		System.out.println("--- 메인 끝 ---");
	}
	
	public void test() {
		//로그 기록
		log.trace("trace에 관련된 로그입니다");
		log.debug("debug에 관련된 로그입니다");
		log.info("info에 관련된 로그입니다");
		log.warn("warn에 관련된 로그입니다");
		log.error("error에 관련된 로그입니다");
		log.fatal("fatal에 관련된 로그입니다");
	}
}
