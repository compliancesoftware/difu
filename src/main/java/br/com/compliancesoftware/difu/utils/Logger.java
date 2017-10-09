package br.com.compliancesoftware.difu.utils;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.BasicConfigurator;

public class Logger extends Log4JLogger {

	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = -6630397917548482495L;
	
	private Logger() {
		super("[DIFU - Log]");
		BasicConfigurator.configure();
	}
	
	private void _info(String clazz, String method, String message) {
		String className = "[" + clazz + "]";
		String buildedMessage = className + " :: " + "[" + method + "] :: " + message;
		super.info(buildedMessage);
	}
	
	public static void info(String clazz, String method, String message) {
		Logger logger = new Logger();
		logger._info(clazz, method, message);
	}
}
