package com.travelsky.ipcollectws.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 代理模式来处理日志
 * @author zhangever
 *
 */
public class LoggerProxy {
	private static Log logger = LogFactory.getLog(LoggerProxy.class);

	public static void info(String log) {
		logger.info(log);
	}

	public static void debug(String log) {
		logger.debug(log);
	}

	public static void warn(String log) {
		logger.warn(log);
	}

	public static void error(String log, Throwable e) {
		logger.error(log, e);
	}
	
	public static void error(String log) {
		logger.error(log);
	}
}
