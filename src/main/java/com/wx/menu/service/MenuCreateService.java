/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年9月19日上午11:48:21 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.wx.menu.service;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.menu.domain.ClickButton;
import com.wx.menu.domain.ViewButton;
import com.wx.service.CoreService;
import com.wx.utils.WeiXinUtils;

public class MenuCreateService {
	
	public static void main(String[] args) {
		initMenu();
	}
	
	/**
	 * initMenu:初始化菜单
	 * @author pxh
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void initMenu() {
		ClickButton clickButton = new ClickButton();
		clickButton.setType("click");
		clickButton.setName("点击一");
		clickButton.setKey("click_1");
		
		ClickButton clickButton2 = new ClickButton();
		clickButton2.setType("click");
		clickButton2.setName("点击二");
		clickButton2.setKey("click_2");
		
		ClickButton clickButton3 = new ClickButton();
		clickButton3.setType("click");
		clickButton3.setName("点击三");
		clickButton3.setKey("click_3");
		
		ViewButton viewButton = new ViewButton();
		viewButton.setType("view");
		viewButton.setName("百度");
		viewButton.setUrl("http://www.baidu.com");
		
		ViewButton viewButton2 = new ViewButton();
		viewButton2.setType("view");
		viewButton2.setName("谷歌");
		viewButton2.setUrl("http://www.google.com");
		
		List clickButtonList = new ArrayList();
		clickButtonList.add(clickButton);
		clickButtonList.add(clickButton2);
		clickButtonList.add(clickButton3);
		
		JSONObject buttonOne = new JSONObject();
		buttonOne.put("name", "点击按钮");
		buttonOne.put("sub_button", clickButtonList.toArray());
		
		
		List viewButtonList = new ArrayList();
		viewButtonList.add(viewButton);
		viewButtonList.add(viewButton2);
		
		JSONObject buttonTwo = new JSONObject();
		buttonTwo.put("name", "网站");
		buttonTwo.put("sub_button", viewButtonList.toArray());
		
		JSONArray button = new JSONArray();
		button.add(buttonOne);
		button.add(buttonTwo);
		
		JSONObject menuJson = new JSONObject();
		menuJson.put("button", button);
		System.out.println(menuJson);
		
		//获取access_token
		String accessToken = WeiXinUtils.createAccessToken();
		
		//请求接口的url
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;
        String getMethod = "POST";
        String jsonStr = menuJson.toJSONString();
        CoreService.sendRequest(url,getMethod,jsonStr);
	}
}
  