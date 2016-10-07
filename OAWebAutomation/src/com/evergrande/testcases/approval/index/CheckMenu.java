package com.evergrande.testcases.approval.index;

import com.evergrande.pages.approval.*;
import com.evergrande.testcases.approval.BaseTestCase;
import com.evergrande.actions.approval.OAAssertion;
import org.testng.annotations.Test;
import org.testng.Assert;
/**
 * @author 黄志辉
 * 依次点击 “电子审批”菜单下的子菜单
 *
 */
public class CheckMenu extends BaseTestCase
{
	@Test
	public void LoopCheck() throws InterruptedException 
	{
		boolean flag = false;
		OAAssertion oaA = new OAAssertion();
		
		SideBar sideB = new SideBar(driver);
		ApprovalInbox inBox = new ApprovalInbox(driver);
		ApprovalMessageCenter messageCenter= new ApprovalMessageCenter(driver);
		ApprovalOutbox outBox= new ApprovalOutbox(driver);
		ApprovalSearch search= new ApprovalSearch(driver);
		ApprovalSend send= new ApprovalSend(driver);
		ApprovalSignature signature= new ApprovalSignature(driver);
		ApprovalTemplate template= new ApprovalTemplate(driver);
		
		//电子审批——主菜单
		Thread.sleep(1000);
		sideB.approval.click();
		Thread.sleep(1000);
		
		
		//收件箱
		sideB.inBox.click();
		oaA.assertTextEquals(driver, 2, inBox.titlePart2, "收件箱");		

		//发起审批
		sideB.send.click();
		oaA.assertTextEquals(driver, 2, send.titlePart2, "发起审批");
		
		//发件箱
		sideB.outBox.click();
		oaA.assertTextEquals(driver, 2, outBox.titlePart2, "发件箱");

		//档案查询
		sideB.search.click();
		oaA.assertTextEquals(driver, 2, search.titlePart2, "档案查询");
		
		//签名管理
		sideB.signature.click();
		oaA.assertTextEquals(driver, 2, signature.titlePart2, "签名管理");
		
		//模板管理
		sideB.template.click();
		oaA.assertTextEquals(driver, 2, template.titlePart2, "模板管理");
		
		//消息中心
		sideB.messageCenter.click();
		oaA.assertTextEquals(driver, 2, messageCenter.titlePart2, "消息中心");	
		
		flag = true;
		logger.info("测试通过!");
		Assert.assertEquals(flag, true, "ceshi 通过");
	}	
}
