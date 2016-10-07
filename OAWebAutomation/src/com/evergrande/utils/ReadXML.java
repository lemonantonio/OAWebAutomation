package com.evergrande.utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author 黄志辉
 * @date  2016年10月4日
 */
public class ReadXML{
	
	public SAXReader reader;
	public Document doc;
	
	public ReadXML(String fileName){
		reader = new SAXReader();
		try {
			doc = reader.read(new File(fileName));
		} catch (DocumentException e) {
			e.printStackTrace();			
		}
	}
	
	/**
	 * 读取第三层节点的内容
	 * @param node 第二层节点
	 * @param key 第三层节点
	 * @return 第三层节点的值
	 */
	public String read(String node,String key){
		Element root = doc.getRootElement();
		Element element = root.element(node);
		return element.element(key).getStringValue();
	}
}
