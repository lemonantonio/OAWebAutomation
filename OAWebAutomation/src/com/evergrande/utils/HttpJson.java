package com.evergrande.utils;

import java.io.File;
import java.io.IOException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 基础类
 * @author 
 */
public class HttpJson {
   
	public static OkHttpClient client;

	public HttpJson(){
		client = new OkHttpClient.Builder().build();
	}
	/**
	 * get请求方法
	 * @param url 请求地址
	 * @return 返回json格式的响应数据
	 */
	public JSONObject httpGetJson(String url){
		Request request = new Request.Builder().url(url).build();
		JSONObject jsonResponse = null;
		try {
			Response response = client.newCall(request).execute();
			jsonResponse = JSON.parseObject(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	}
	
	/**
	 * get请求方法
	 * @param url 请求地址
	 * @return 返回字符串格式的响应数据
	 */
	public String httpGetStr(String url){
		Request request = new Request.Builder().url(url).build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("没有获取到响应，返回null");
			return null;
		}
	}
	
	/**
	 * post请求方法
	 * @param url 请求地址
	 * @param values 格式是“key=value&key1=value1”
	 * @return 返回json格式的响应数据
	 */
	public JSONObject httpPostJson(String url,String values){
		String[] valueArray = values.split("&");
		/*System.out.println(url);
		for(String s: valueArray){
			System.out.println(s);
		}*/
				
		RequestBody body = addParams(valueArray).build();
		Request request = new Request
				.Builder()
				.url(url)
				.post(body)
				.build();
		JSONObject jsonResponse = null;
		try {
			Response response = client.newCall(request).execute();
			jsonResponse = JSON.parseObject(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	}
	
	/**
	 * 添加多个参数
	 * @param values 不定参数
	 * @return 返回FormBody.Builder格式数据，作为Request.post的参数
	 */
	public FormBody.Builder addParams(String ... values){
		FormBody.Builder builder = new FormBody.Builder();
		for(String value:values){
			String[] subValue = value.split("=");
			try{
				builder.add(subValue[0], subValue[1]);
			}catch(ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
				System.out.println("以=作为分隔符分割字符串出错");
			}
			
		}
		return builder;
	}
	
	/**
	 * post请求方法
	 * @param url 请求地址
	 * @param values 格式是“key=value&key1=value1”
	 * @return 返回字符串格式的响应数据
	 */
	public String httpPostStr(String url,String values){
		String[] valueArray = null;
		try{
			valueArray = values.split("&");
		}catch(Exception e){
			System.out.println("以&作为分隔符分割字符串出错");
		}
		RequestBody body = addParams(valueArray).build();
		Request request = new Request
				.Builder()
				.url(url)
				.post(body)
				.build();
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 上传文件
	 * @param url 上传文件地址
	 * @param values 上传参数，格式是“key=value&key1=value1”
	 * @param file 上传的文件
	 * @param msgForUpload 上传的文件信息字段
	 * @return
	 */
	public JSONObject upFile(String url,String values, File file,String msgForUpload){  
	    RequestBody requestBody = RequestBody.create(MediaType.parse("application/octet-stream") , file);  
	    String fileName = file.getName();  
	    String[] valueArray = null;
	    try{
			valueArray = values.split("&");
		}catch(Exception e){
			System.out.println("以&作为分隔符分割字符串出错");
		}
	    MultipartBody mBody = addValues(valueArray).setType(MultipartBody.FORM)  
	            .addFormDataPart(msgForUpload , fileName , requestBody) //msgForUpload为上传信息字段
	            .build();  
	    Request request = new Request.Builder().url(url).post(mBody).build();  
	    JSONObject jsonResponse = null;
		Response response = null;
		try {
			response = client.newCall(request).execute();
			jsonResponse = JSON.parseObject(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse; 
	} 
	
	public MultipartBody.Builder addValues(String ... values){
		MultipartBody.Builder mBody = new MultipartBody.Builder();
		for(String value:values){
			String[] subValue = value.split("=");
			try{
				mBody.addFormDataPart(subValue[0], subValue[1]);
			}catch(ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
				System.out.println("以=作为分隔符分割字符串出错");
			}
			
		}
		return mBody;
	}
}
