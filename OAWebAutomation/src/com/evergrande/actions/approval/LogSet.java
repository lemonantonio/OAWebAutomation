package com.evergrande.actions.approval;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

/**
 * 封装Log4j和Report
 * @author 黄志辉
 * @date  2016年10月4日
 */
public class LogSet	{
	private Logger logger;
	
	public LogSet() {
		logger = getLogger();
	}
	
	public void fatal(String str){
		logger.fatal(str);
		Reporter.log(str);
	}
	
	public void error(String str){
		logger.error(str);
		Reporter.log(str);
	}
	
	public void info(String str){
		logger.info(str);
		Reporter.log(str);
	}
	
	
	public void debug(String str){
		logger.debug(str);
		Reporter.log(str);
	}
	public Logger getLogger(){
		initLog();
		return Logger.getLogger(this.getClass());
	}
	
	/**
	 * log4j的配置信息
	 */
	private void initLog(){
		Date date = new Date();
		  SimpleDateFormat time=new SimpleDateFormat("yyyy_MM_dd"); 
		  String infoLog = "info_"+time.format(date);
		  String infoLogPath = "./logs/approval/" + infoLog + ".log";
		  String errorLog = "error_"+time.format(date);
		  String errorLogPath = "./logs/approval/" + errorLog + ".log";
		  
		//配置日志输出的格式
		  Properties prop = new Properties();
		  prop.setProperty("log4j.rootLogger","INFO, toConsole, D, E");
		  prop.setProperty("log4j.appender.file.encoding","UTF-8" );
		  
		  //控制台日志
		  prop.setProperty("log4j.appender.toConsole","org.apache.log4j.ConsoleAppender");
		  prop.setProperty("log4j.appender.toConsole.Target","System.out");
		  prop.setProperty("log4j.appender.toConsole.Threshold","INFO");
		  prop.setProperty("log4j.appender.toConsole.layout","org.apache.log4j.PatternLayout ");
		  prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern","[%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");
		  
		  //INFO信息的日志
		  prop.setProperty("log4j.appender.D", "org.apache.log4j.DailyRollingFileAppender");
		  prop.setProperty("log4j.appender.D.file", infoLogPath);
		  prop.setProperty("log4j.appender.D.append", "true");
		  prop.setProperty("log4j.appender.D.Threshold", "info");
		  prop.setProperty("log4j.appender.D.layout", "org.apache.log4j.PatternLayout");
		  prop.setProperty("log4j.appender.D.layout.ConversionPattern", "[%d{yyyy/MM/dd HH:mm:ss}] [%p] %m [%c:%L]%n");
			//使配置生效
		  
		//ERROR信息的日志
		  prop.setProperty("log4j.appender.E", "org.apache.log4j.DailyRollingFileAppender");
		  prop.setProperty("log4j.appender.E.file", errorLogPath);
		  prop.setProperty("log4j.appender.E.append", "true");
		  prop.setProperty("log4j.appender.E.Threshold", "error");
		  prop.setProperty("log4j.appender.E.layout", "org.apache.log4j.PatternLayout");
		  prop.setProperty("log4j.appender.E.layout.ConversionPattern", "[%d{yyyy/MM/dd HH:mm:ss}] [%p] %m [%c:%L]%n");
		  PropertyConfigurator.configure(prop);
	}
	

}
