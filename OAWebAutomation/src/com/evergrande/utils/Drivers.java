package com.evergrande.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author 黄志辉
 *
 */
public class Drivers 
{
	/**
	 * 创建Chrome实例
	 * @param location 驱动文件的路径
	 * @param timeout  超时
	 * @return         表示chrome实例的driver
	 */
	static public WebDriver CreateChromeDrivers(String location, int timeout)
	{		
		System.setProperty("webdriver.chrome.driver", location);
		WebDriver driver = new ChromeDriver();  
		
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
	}
}
