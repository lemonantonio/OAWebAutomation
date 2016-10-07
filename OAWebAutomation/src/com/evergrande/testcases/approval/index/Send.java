
package com.evergrande.testcases.approval.index;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.evergrande.actions.approval.Login;
import com.evergrande.pages.approval.*;
import com.evergrande.testcases.approval.BaseTestCase;
import com.evergrande.utils.Drivers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author 011300193
 * 通过读取cookie达到身份验证，直接访问指定url
 * 发起审批主流程
 *
 */
public class Send extends BaseTestCase
{	
/*	@BeforeClass
	public void prepare() throws InterruptedException{
		
		//运行方式1：批量运行——这时候不需要重新登录，driver用上一个操作的driver实例
		driver = Action1.driver;    
		
		
		//运行方式2:单独运行，需要重新登录
		driver = Drivers.CreateChromeDrivers(".//chromedriver.exe", 10);
		
		new Login().login(driver, "http://beta.evergrande.cn/index/login", "huangzhihui", "Test123");
		
		//运行方式3：单独运行，通过读cookies文件绕开登录，可以避免做自动化时频繁登录系统，前提是先运行Action1（或其他操作）得到登录的cookie
		driver = Drivers.CreateChromeDrivers(".//chromedriver.exe", 10);
		driver.get("http://beta.egtest.cn/index/login");        
        new CookiesRW().readFromFile(driver, "login_cookie.data"); 

		
	}*/	

	@Test                                   
	public void go3() throws Exception 
	{	
        //直接访问指定的url：发起审批
		Thread.sleep(1000);
        driver.get("http://beta.evergrande.cn/api.php?v=approval/send");
        System.out.println("Action3");
//        driver.quit();

 /*       ApprovalSend as = new ApprovalSend(driver);
        
        //点击所有的流程提示
        as.tipStep1.click();
		Thread.sleep(100);
        as.tipStep2.click();
		Thread.sleep(100);
        as.tipStep3.click();
		Thread.sleep(100);
        as.tipStep4.click();
		Thread.sleep(100);
        as.tipStep5.click();
		Thread.sleep(100);
		
		//上传正文
		as.textUpload.sendKeys("D:\\auto\\HZHaaa.docx");		
		try{    		
            new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                	WebElement wb = d.findElement(By.xpath("//*[contains(@id, 'gritter-item')]/div[2]/div[2]/p"));
                	return wb.getText().equals("上传文件成功");
                }
            });
   			}
		catch (Exception timeoutE){ 
			logger.error("上传正文失败：", timeoutE);     //上传超时      
			return;				
		}		
		
		//上传附件
		as.annexUpload.sendKeys("D:\\auto\\HZH2.docx");
		try{    		
            new WebDriverWait(driver, 5).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                	WebElement wb = d.findElement(By.xpath("//*[contains(@id, 'gritter-item')]/div[2]/div[2]/p"));
                	return wb.getText().equals("上传文件成功");
                }
            });
   			}
		catch (Exception timeoutE){ 
			logger.error("上传附件失败:", timeoutE);     //上传超时      
			return;				
		}
				
		//设置标题
		as.title.clear();
		as.title.sendKeys("HZH22");
		
		Thread.sleep(2000);              //必须等待直到其他提示框消失
		//搜索		
		as.search("test001");
		//拖动审批人节点到中央
		WebElement From = driver.findElement(By.xpath("//*[@id='searchResult']/ul/li[1]"));
		WebElement To = as.innerContentText;
		Actions builder = new Actions(driver);
		builder.clickAndHold(From)
				.moveToElement(To, (960), 0)
				.release().perform();
			
		//搜索		
		as.search("test002");
		//拖动审批人节点到中央		
		From = driver.findElement(By.xpath("//*[@id='searchResult']/ul/li[1]"));		 
		Action dad = builder.clickAndHold(From)
				.moveToElement(To, (960), 200)
				.release()
				.build();
		dad.perform();
		
		Thread.sleep(2000);   //等待2秒，直到提示框消失才能点“保存草稿”按钮
		as.draft.click();   //保存草稿
		//断言成功
		
//		as.send.click();     //发起审批
			*/
	}
	
	
}
