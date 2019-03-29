package com.wx.utils;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wx.service.CoreService;

@Controller
@RequestMapping("/weixin")
public class WeiXinUtils extends HttpServlet{
	
	private final static String appId = "wx4e97182f13ff1ece";
	
	private final static String appSecret = "2743fc896e7256bcc55508ab49fe77c7";
	
	
	
	/**
	 * createAccessToken:动态生成 access_token
	 * @author pxh 
	 * @return
	 */
	public static String createAccessToken() {
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appId+"&secret="+appSecret;
		JSONObject jsonObject = CoreService.sendRequest(requestUrl, "GET", "");
		String accessToken = jsonObject.getString("access_token");
		return accessToken;
	}
	
	
	

	@Override
//	@RequestMapping(value = "/get")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//微信加密签名，signature结合了开发者填写的token 参数和请求中的timestamp,nonce参数
		String signature = req.getParameter("signature");
		//时间戳
		String timestamp = req.getParameter("timestamp");
		//随机数
		String nonce = req.getParameter("nonce");
		//随机字符串
		String echostr = req.getParameter("echostr");
		if(SignUtil.checkSignature(signature, timestamp, nonce)) {
			 System.out.println("[signature: "+signature + "]<-->[timestamp: "+ timestamp+"]<-->[nonce: "+nonce+"]<-->[echostr: "+echostr+"]");
			 resp.getOutputStream().println(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	
	/**
     * 接收来自微信发来的消息
     * 
     * @param out
     * @param request
     * @param response
	 * @throws IOException 
     */
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public void wechatServicePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	String responseMessage = CoreService.processRequest(request);
    	System.out.println(responseMessage);
    	response.getWriter().write(responseMessage);
    }
}
