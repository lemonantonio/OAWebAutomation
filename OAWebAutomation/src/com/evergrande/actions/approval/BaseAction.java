package com.evergrande.actions.approval;
import com.evergrande.utils.ReadXML;

public class BaseAction {
	public static final String BasicData = "./data/Approval/basicData.xml";
	
	public  ReadXML xmlReader(String data){
		return new ReadXML(data);
	}
	protected LogSet logger = new LogSet();         //使用log4j记录日志
}
