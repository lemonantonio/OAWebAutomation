
package com.evergrande.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


/**
 * @author 黄志辉
 *
 */
public class CookiesRW
{
	
	public Set<Cookie> cookieSet;
	
	
	public void save(WebDriver driver){
		cookieSet = driver.manage().getCookies();	
	}
	
	public void show(){
		if (!cookieSet.isEmpty()){
			for(Cookie ck : cookieSet){
				System.out.println(ck);
			}
		}
	}
	
	public void read(WebDriver driver){
		for(Cookie ck : cookieSet){
			driver.manage().addCookie(ck);
		}		
	}
	
	/**
	 * 获取cookies，保存到文件
	 * @param driver
	 * @param filename          保存到此文件
	 */
	public void saveToFile(WebDriver driver, String filename)
	{
		//保存cookie
		File file = new File(filename);
		try(FileWriter fw = new FileWriter(file);
	        BufferedWriter bw = new BufferedWriter(fw);)
		{
		  for (Cookie ck : driver.manage().getCookies()) 
		  {
			  bw.write(ck.getName() + ";" + ck.getValue() + ";"
					  + ck.getDomain() + ";" + ck.getPath() + ";"
		              + ck.getExpiry() + ";" + ck.isSecure());
		              bw.newLine();
		  }
		  bw.flush();
		} catch (Exception e) {
		     e.printStackTrace();
		  } finally { }		        
	}
	
	/**
	 * 从文件读取cookies
	 * @param driver
	 * @param filename  从该文件读取cookies
	 */
	public void readFromFile(WebDriver driver, String filename)
	{
		 //读取cookie
        try(FileReader fr=new FileReader(new File(filename));
            BufferedReader br=new BufferedReader(fr);) 
        {            
            String line;
            while((line=br.readLine())!= null)
            {
                StringTokenizer str=new StringTokenizer(line,";");
                while(str.hasMoreTokens())
                {
                    String name=str.nextToken();
                    String value=str.nextToken();
                    String domain=str.nextToken();
                    String path=str.nextToken();
                    Date expiry=null;
                    String dt;
                    if(!(dt=str.nextToken()).equals("null"))                    
                    {	
                    	String pattern = "EEE MMM dd HH:mm:ss zzz yyyy";
                    	expiry=new SimpleDateFormat(pattern, Locale.US).parse(dt);  
                    	
                    }
                    boolean isSecure=new Boolean(str.nextToken()).booleanValue();
                    Cookie ck=new Cookie(name,value,domain,path,expiry,isSecure);
                    driver.manage().addCookie(ck);
                }
            }     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
	}
}