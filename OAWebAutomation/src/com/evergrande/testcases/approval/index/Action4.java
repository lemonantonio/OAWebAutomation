
package com.evergrande.testcases.approval.index;



import java.util.List;






import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.evergrande.actions.approval.Login;
import com.evergrande.pages.approval.ApprovalSend;
import com.evergrande.pages.approval.SideBar;
import com.evergrande.utils.CookiesRW;
import com.evergrande.utils.Drivers;


/**
 * @author 011300193
 * 实验
 */
public class Action4
{

	protected final String cname = this.getClass().getName();

WebDriver driver;
WebElement t;	
String s;
ApprovalSend as = new ApprovalSend(driver);
WebElement To = as.innerContentText;
//Actions builder = new Actions(driver);


@BeforeClass
public void prepare() throws InterruptedException{
	driver =Drivers.CreateChromeDrivers(".//chromedriver.exe", 10);

	String DEMO_PAGE = "<p>Demo page for how to get text from hidden elements using Selenium WebDriver.</p>"
			+ "<div id='demo-div'>Demo div <p style='display:none'>with a hidden paragraph inside.</p><hr /><br /></div>";
	driver.get("http://172.18.150.34/test.php");

//	new Login().login(driver, "http://beta.evergrande.cn/index/login", "huangzhihui", "Test123");
	
}	

	@Test
	public void go() throws InterruptedException 
	{
		

//		WebElement wb = driver.findElement(By.xpath(".//*[@id='demo-div']"));
//		
//		System.out.println("innerHTML: "+wb.getAttribute("innerHTML"));
//		System.out.println("innerText: "+wb.getAttribute("innerText"));
//		System.out.println("ContentText: "+wb.getAttribute("ContentText"));
		

		
		
		/*new Login().login(driver, "http://beta.evergrande.cn/index/login", "huangzhihui", "Test123");	
		driver.get("http://beta.egtest.cn/api.php?v=approval/send&pk=1488");    //某个发件箱地址
		
		driver.get(url);
		
		List<WebElement> l = driver.findElements(By.cssSelector(".currentName"));
			
		int i = 0;
		for(WebElement wb:l){
			System.out.println("innerHTML: "+wb.getAttribute("innerHTML"));
			System.out.println("innerText: "+wb.getAttribute("innerText"));
			System.out.println("ContentText: "+wb.getAttribute("ContentText"));
			
			
			builder.clickAndHold(wb).moveToElement(To, 960, 200*i).release().perform();   //正文区宽度为960，每个签名控件垂直相隔200
			Thread.sleep(2000);
			i += 1;
		}*/
	}
}
