package log;

public class LoggerTester {

	public static void main(String[] args) {
		EventLogger logger = new EventLogger("log.txt"); //EventLogger 생성자 생성
		logger.log("test"); //log test.

	}

}
