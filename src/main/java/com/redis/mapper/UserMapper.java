/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月21日下午2:28:38 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.redis.mapper;

import java.util.List;

import com.redis.model.User;

public interface UserMapper {
   
	public User selectByPrimaryKey(int userId);
	
	public List<User> selectAllUser();
	
	public void insertUser(User user);
	
	public void deleteUser(int id);
	
	public List<User> findUsers(String keyWords);
	
	public void editUser(User user);
}
  