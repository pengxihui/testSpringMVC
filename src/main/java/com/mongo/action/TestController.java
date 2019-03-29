/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年10月25日下午12:02:45 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mongo.action;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mongo.model.UserInfo;
import com.mongo.service.UserInfoService;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Controller
@RequestMapping(value = "mongodbTest")
public class TestController {
    @Autowired
	private UserInfoService userInfoService;
    
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
    	UserInfo userInfo = new UserInfo();
    	userInfo.setNickname("pxh003");
    	userInfo.setUsername("aaa6669842");
    	userInfo.setSex("female");
    	userInfo.setAge("18");
    	userInfoService.add(userInfo);
    	return "mongo/test";
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getData(Model model) {
    	DBCollection  userInfoCollection = userInfoService.select("userInfo"); 
    	DBCursor dbCursor = userInfoCollection.find();
    	List userInfoList = new ArrayList();
    	while (dbCursor.hasNext()) {
    		DBObject obj = dbCursor.next();
    		Gson gson = new Gson();
	    	//反转
	    	UserInfo userInfo = gson.fromJson(obj.toString(), UserInfo.class);
	    	userInfoList.add(userInfo);
    	}
    	model.addAttribute("userInfoCollection", userInfoList);
    	return "mongo/test";
    }
}
  