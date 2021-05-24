package log;

public class LoggerTester {

	public static void main(String[] args) {
		EventLogger logger = new EventLogger("log.txt"); //EventLogger 持失切 持失
		logger.log("test"); //log test

	}

}
