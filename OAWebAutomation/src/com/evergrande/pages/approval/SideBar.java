
package com.evergrande.pages.approval;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
/**
 * 
 * @author 黄志辉
 * @date  2016年10月2日
 */
public class SideBar extends Page{

	public SideBar(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/a")
	@CacheLookup
	public WebElement approval;         //电子审批
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[1]/a")
	@CacheLookup
	public WebElement inBox;         //收件箱
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[2]/a")
	@CacheLookup
	public WebElement send;         //发起审批
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[3]/a")
	@CacheLookup
	public WebElement outBox;         //发件箱
	
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[4]/a")
	@CacheLookup
	public WebElement search;         //档案查询
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[5]/a")
	@CacheLookup
	public WebElement signature;         //签名管理
	
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[6]/a")
	@CacheLookup
	public WebElement template;         //模板管理
	
	
	@FindBy(xpath = ".//*[@id='sidebar']/ul/li[5]/ul/li[7]/a")
	@CacheLookup
	public WebElement messageCenter;         //消息中心
	
	
	

}
