/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年9月19日下午3:53:37 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.wx.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wx.menu.MyX509TrustManager;
import com.wx.utils.MessageUtil;

/**
 * 处理微信发来的请求
 * description: 
 * Date:2018年9月19日下午3:54:15
 */
public class CoreService {
	
	/**
	 * sendRequest:向微信服务器发送请求
	 * @author pxh 
	 * @param url  请求地址
	 * @param getMethod 请求方式
	 * @param jsonStr 发送的数据包
	 */
	public static JSONObject  sendRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
 
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);
 
			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
 
			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
 
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSON.parseObject(buffer.toString());
		} catch (ConnectException ce) {
		//	log.error("连接超时：{}", ce);
			System.out.println("连接超时：{}");
		} catch (Exception e) {
		//	log.error("https请求异常：{}", e);
			System.out.println("https请求异常：{"+e.getMessage()+"}");
		}
		return jsonObject;
	}
	
   
	/**
	 * processRequest:处理微信服务器发来的请求
	 * @author pxh 
	 * @param request
	 * @return
	 */
   public static String processRequest(HttpServletRequest request) {
	   //默认返回的文本信息内容
	   String respContent = "请求处理异常，请稍后尝试";
	   
	   Map<String,String> requestMap = MessageUtil.parseXml(request);
	   
	   String toUserName = requestMap.get("ToUserName");//开发者微信号
	   String fromUserName = requestMap.get("FromUserName");//发送方帐号（一个OpenID）
	   String createTime = requestMap.get("CreateTime");//消息创建时间 （整型）
	   String msgType = requestMap.get("MsgType");//消息类型，event
	   String event = requestMap.get("Event");//事件类型，CLICK
	   String eventKey = requestMap.get("EventKey");//事件KEY值，与自定义菜单接口中KEY值对应
	   
	   // 回复文本消息  
       String responseXml = "<xml><ToUserName>"+toUserName+"</ToUserName><FromUserName>"+fromUserName+"</FromUserName><CreateTime>"+18457925+"</CreateTime><MsgType>"+msgType+"</MsgType><Content>"+"我回复你消息啦，哈哈哈哈哈"+"</Content><MsgId>1234567890123456</MsgId></xml>";
       
       /**
        * 文本消息XML数据格式
        * <xml>
        <ToUserName><![CDATA[toUser]]></ToUserName>
        <FromUserName><![CDATA[fromUser]]></FromUserName>
        <CreateTime>1348831860</CreateTime>
        <MsgType><![CDATA[text]]></MsgType>
        <Content><![CDATA[this is a test]]></Content>
        <MsgId>1234567890123456</MsgId>
        </xml>
        */
       //回复文本消息
       if(msgType.equals("text")) {
    	   return String.format(
	               "<xml>" +
	                       "<ToUserName><![CDATA[%s]]></ToUserName>" +
	                       "<FromUserName><![CDATA[%s]]></FromUserName>" +
	                       "<CreateTime>%s</CreateTime>" +
	                       "<MsgType><![CDATA[text]]></MsgType>" +
	                       "<Content><![CDATA[%s]]></Content>" +
	                       "</xml>",
	                   fromUserName, toUserName, 1245896, "我回复你的信息啦，哈哈哈哈");
       }
       
//	   if(event.equals("CLICK")) {
		   
//	   }
       return "";
   }
}
  