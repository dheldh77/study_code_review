package sensor.log4j_wrapper;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class LogTest {

	@Test
	public void testLogCreate() {
		Logger logger = Logger.getLogger("MyLogger");
		logger.info("hello");
	}

	@Test
	public void testLogAddAppender() {
	    Logger logger = Logger.getLogger("MyLogger");
	    ConsoleAppender appender = new ConsoleAppender();
	    logger.addAppender(appender);
	    logger.info("hello");
	}

//	@Test
//	public void testLogAddAppender2() {
//	    Logger logger = Logger.getLogger("MyLogger");
//	    logger.removeAllAppenders();
//	    logger.addAppender(new ConsoleAppender(
//	        new PatternLayout("%p %t %m%n"),
//	        ConsoleAppender.SYSTEM_OUT));
//	    logger.info("hello");
//	}
//
//	@Test
//	public void testLogAddAppender3() {
//	    Logger logger = Logger.getLogger("MyLogger");
//	    logger.removeAllAppenders();
//	    logger.addAppender(new ConsoleAppender(
//	        new PatternLayout("%p %t %m%n"),
//			ConsoleAppender.SYSTEM_OUT));
//	    logger.info("hello");
//	}
}
