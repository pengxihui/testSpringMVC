/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月21日下午3:09:30 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.redis.service;

import java.util.List;

import com.redis.model.User;

public interface IUserService {
    
	public User getUserById(int userId);
	
	public List<User> getAllUser();
	
	public void insertUser(User user);
	
	public void deleteUser(int id);
	
	public List<User> findUsers(String keyWords);
	
	public void editUser(User user);
}
  