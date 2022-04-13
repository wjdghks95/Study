package ch11;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class MyLogger2 {

	Logger logger = Logger.getLogger("mylogger");
	private static MyLogger2 instance = new MyLogger2();
	
	public static final String errorLog = "log2.txt";
	
	private FileHandler logFile = null;
	
	private MyLogger2() {
		
		try {
			logFile = new FileHandler(errorLog, true);
		} catch(SecurityException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		logFile.setFormatter(new SimpleFormatter());
		
		logger.setLevel(Level.WARNING);
		
		logger.addHandler(logFile);
	}
	
	public static MyLogger2 getLogger() {
		return instance;
	}
	
	public void info(String msg) {
		logger.warning(msg);
	}
}

public class MyLoggerTest {
	public static void main(String[] args) {
		
		MyLogger2 myLogger2 = MyLogger2.getLogger();
		
		myLogger2.info(null);
	}
}

