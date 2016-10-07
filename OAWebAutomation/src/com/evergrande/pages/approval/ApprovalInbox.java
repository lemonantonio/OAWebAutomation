package com.evergrande.pages.approval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


/**
 * 
 * @author 黄志辉
 * @date  2016年10月2日
 */
public class ApprovalInbox extends Page{
	public ApprovalInbox(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath = "//*[@id='breadcrumbs']/ul/li[1]")
	@CacheLookup
	public WebElement titlePart1;         //导航title——电子审批
	
	@FindBy(xpath = "//*[@id='breadcrumbs']/ul/li[2]")
	@CacheLookup
	public WebElement titlePart2;         //导航title——收件箱	
}
