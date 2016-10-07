package com.evergrande.testcases.approval;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import com.evergrande.actions.approval.BaseAction;
import com.evergrande.actions.approval.Login;
import com.evergrande.utils.Drivers;
import com.evergrande.utils.ReadXML;

/**
 * 基础测试用例，其它测试用例类继承本类
 * @author 黄志辉
 * @date  2016年10月2日
 */
public  class BaseTestCase extends BaseAction{
	public WebDriver driver;
	String module;                    //测试用例所在模块
	String testCase;                  //测试用例

	
	@BeforeSuite
	public void init(){
		
		logger.info("=============Suite开始=============");
	}
	
	@AfterSuite
	public void end(){
		logger.info("=============Suite结束=============");
	}
	
	@BeforeTest
	public void beginTest() throws InterruptedException{
		logger.info("=============Test开始=============");
		driver = Drivers.CreateChromeDrivers("./chromedriver.exe", 10);  
		
		ReadXML loginData =  xmlReader(BasicData);		
		String url = loginData.read("url", "baseTestBeta") + loginData.read("url", "login");
		String usr = loginData.read("login", "username");
		String pwd = loginData.read("login", "password");
		new Login().login(driver, url, usr, pwd);
		logger.info("登录"+url+"    用户："+usr+"/"+pwd);
	}
	
	/**
	 * 在每个class的测试运行之前，都会初始化一次日志机制，只要继承Base，就会自动调用
	 */
	@BeforeClass
	public void BeforeClass(){
		testCase = this.getClass().getSimpleName();
		logger.info("=====测试用例【"+testCase+"】开始====");
	}
	
	@AfterClass
	public void AfterClass(){
		logger.info("=====测试用例【"+testCase+"】结束====");		
	}
	
	@AfterTest
	public void finishTesting(){
		logger.info("=============Test结束=============");
	}
}
