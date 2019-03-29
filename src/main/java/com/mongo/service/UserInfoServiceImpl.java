/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年10月25日下午12:00:01 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mongo.service;

import org.springframework.stereotype.Service;

import com.mongo.dao.MongoDbBaseDaoImpl;
@Service("userInfoService")
public class UserInfoServiceImpl extends MongoDbBaseDaoImpl implements UserInfoService {

	

}
  