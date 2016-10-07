package com.evergrande.actions.approval;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

import com.evergrande.utils.FileUtils;


/**
 * 打印日志工具，这个工具只是用来记录一些操作轨迹
 * @author 周浩
 */

@Deprecated
public class Printer{

	public static String folder = "Public";
	
	public static void init(String name){
		folder = name;
	}
	
	

	/**
	 * 打印一些执行方法的提醒到./logs/Sys/日期.log下,同时在控制台进行输出,和Logger类不同
	 * @param str 需要提醒的语句
	 */
	public static void println(String str){
		Date date = new Date();
	    SimpleDateFormat dateTime=new SimpleDateFormat("yyyy_MM_dd_HH"); 
	    SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String logName = dateTime.format(date);
	    String logTime = time.format(date).toString();
	    FileUtils.CreateFolder("./logs/"+folder);
	    try{
	    	if(str.startsWith("====")){
	    		FileUtils.writeFileWithNewLine("./logs/"+folder+"/"+logName+".log", logTime+":    "+str);
	    	}else{
	    		FileUtils.writeFileWithNewLine("./logs/"+folder+"/"+logName+".log", logTime+":    "+">>>>"+str);
	    	}
	    	
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    Reporter.log(str);
	    System.out.println(str);
	}
}
