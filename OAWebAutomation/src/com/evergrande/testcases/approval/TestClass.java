package com.evergrande.testcases.approval;
import org.testng.annotations.Test;
import com.evergrande.utils.HttpJson;
public class TestClass extends BaseTestCase{
	@Test
	public void main(){
		HttpJson ba = new HttpJson();
		System.out.println(ba.httpPostJson("http://v23.egtest.cn/api.php", 
				"service=performance.tplinfo.getinfo&search[depart_id]=16").toString());   
	}

}
