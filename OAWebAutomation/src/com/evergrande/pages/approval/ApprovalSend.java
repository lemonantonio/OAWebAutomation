
package com.evergrande.pages.approval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


/**
 * 电子审批-发起评审
 * @author 黄志辉
 *
 */
public class ApprovalSend extends Page{
	
	public ApprovalSend(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//*[@id='breadcrumbs']/ul/li[1]")
	@CacheLookup
	public WebElement titlePart1;         //导航title——电子审批
	
	@FindBy(xpath = "//*[@id='breadcrumbs']/ul/li[2]")
	@CacheLookup
	public WebElement titlePart2;         //导航title——发起审批
	//++++++++++++++++++++++++++++++++++++++++++//	
	//5个步骤的提示
	@FindBy(xpath = "//*[@id='popoverSetp1Btn']")
	@CacheLookup
	public WebElement tipStep1;         //上传文档的提示
	
	@FindBy(xpath = "//*[@id='popoverSetp2Btn']")
	@CacheLookup
	public WebElement tipStep2;         //修改文档内容的提示
	
	@FindBy(xpath = "//*[@id='popoverSetp3Btn']")
	@CacheLookup
	public WebElement tipStep3;         //添加流程处理人的提示
	
	@FindBy(xpath = "//*[@id='popoverSetp4Btn']")
	@CacheLookup
	public WebElement tipStep4;         //重复添加流程处理人的提示	
	
	@FindBy(xpath = "//*[@id='popoverSetp5Btn']")
	@CacheLookup
	public WebElement tipStep5;         //流程处理人排序的提示	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++///
	//页面顶端
	@FindBy(css = "#draft")
	@CacheLookup
	public WebElement draft;          //保存草稿
		
	@FindBy(css = "#send")
	@CacheLookup
	public WebElement send;           //发送	

	@FindBy(css = ".launch-title.inline>input")
	@CacheLookup
	public WebElement title;          //标题
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//	
	//右侧上部
	@FindBy(css = "#fileupload")
	@CacheLookup
	public WebElement textUpload;         //正文标签页的上传按钮，“拖拽或上传”
	
	
	@FindBy(css = "#adjunctUpload")
	@CacheLookup
	public WebElement annexUpload;         //附件标签页的上传按钮，“拖拽或上传”
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//右侧中部
	@FindBy(css = "#nav-search-input")
	@CacheLookup
	public WebElement searchText;         //"选择处理人"的搜索文本框
	
	@FindBy(css = "#nav-search-search")
	@CacheLookup
	public WebElement searchBtn;         //"选择处理人"的搜索按钮
	
	public void search(String handler)
	{	
		searchText.clear();
		searchText.sendKeys(handler);
		searchBtn.click();
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	//中央部分
	@FindBy(css = ".innerContent")
	@CacheLookup
	public WebElement innerContent;       //中央	

	
	//中央部分
	@FindBy(css = ".imgBox.img1")
	@CacheLookup
	public WebElement innerContentText;       //中央正文区
	

}
