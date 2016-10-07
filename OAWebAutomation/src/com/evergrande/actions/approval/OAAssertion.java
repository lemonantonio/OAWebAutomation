package com.evergrande.actions.approval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
/**
 * 封装断言
 * @author 黄志辉
 * @date  2016年10月4日
 */
public class OAAssertion extends BaseAction
{	
	
	/**
	 * 
	 * @param driver
	 * @param timeOut  超时时间，单位秒
	 * @param element  元素
	 * @param text     元素文本
	 * @throws InterruptedException
	 */
	public  void assertTextEquals(WebDriver driver, long timeOut, final WebElement element, final String text) 
    		throws InterruptedException 
    {	
		boolean flag = false;
    	try{    		
            new WebDriverWait(driver, timeOut).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                	return element.getText().equals(text);
                }
            });
            logger.info("元素【"+text +"】存在");
   			}
		catch (Exception timeoutE){
			logger.error("元素不存在，或者元素文本不是【"+text +"】");
			logger.error("测试失败!");
			Assert.assertTrue(flag);				
		}
      } 
 }