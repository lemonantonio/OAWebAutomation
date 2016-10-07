
package com.evergrande.pages.approval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 电子审批-签名管理
 * @author 黄志辉
 *
 */
public class ApprovalSignature extends Page{

	public ApprovalSignature(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id='breadcrumbs']/ul/li[1]")
	@CacheLookup
	public WebElement titlePart1;         //导航title——电子审批
	
	@FindBy(xpath = "//*[@id='breadcrumbs']/ul/li[2]")
	@CacheLookup
	public WebElement titlePart2;         //导航title——签名管理
}
