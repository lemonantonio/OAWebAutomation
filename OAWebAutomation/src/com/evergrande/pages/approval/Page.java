package com.evergrande.pages.approval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/**
 * 所有页面继承本类
 * @author 黄志辉
 * @date  2016年10月4日
 */
public class Page {
	public Page(WebDriver driver){
		PageFactory.initElements(driver, this);		
	}
}
