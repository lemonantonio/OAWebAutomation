package com.evergrande.actions.approval;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
/**
 * 
 * @author 黄志辉
 * @date  2016年10月2日
 */
public class Login extends BaseAction
{
     /**
     * @param driver      
     * @param url         登录url
     * @param username    登录用户名
     * @param password    登录密码
     * @throws InterruptedException
     */
    public void login(WebDriver driver, String url, String username, String password) 
    		throws InterruptedException 
    {
         driver.get(url);
         WebElement acc = driver.findElement(By.id("account"));
         acc.clear();
         acc.sendKeys(username);                                              
         driver.findElement(By.id("password")).sendKeys(password);
         WebElement btn = driver.findElement(By.xpath(
        		 "/html/body/div[1]/div/table/tbody/tr[1]/th/form/div[2]/button"));
         btn.click();
         
/*         //保存登录后的cookie，以后免用户名和密码登录
         Thread.sleep(1000);      //必须隔一段时间才保存cookie，否则保存的cookie不完整   
         new CookiesRW().saveToFile(driver, "login_cookie.data");   
*/     
      } 
 }