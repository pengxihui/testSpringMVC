/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月21日下午3:11:58 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.redis.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.redis.mapper.UserMapper;
import com.redis.model.User;
@Service("userService")
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserServiceImpl implements IUserService{
    
	@Resource
	private UserMapper iUserDao;
	
	@Cacheable("getUserById")//标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
	@Override
	public User getUserById(int userId) {
		return this.iUserDao.selectByPrimaryKey(userId);
	}
    
	@Cacheable("getAllUser")
	@Override
	public List<User> getAllUser() {
		return this.iUserDao.selectAllUser();
	}
	
    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)//清空缓存，allEntries变量表示所有对象的缓存都清除
	@Override
	public void insertUser(User user) {
        this.iUserDao.insertUser(user);		
	}
    
    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
	@Override
	public void deleteUser(int id) {
        this.iUserDao.deleteUser(id);		
	}
    
    @Cacheable("findUsers")
	@Override
	public List<User> findUsers(String keyWords) {
    	 return iUserDao.findUsers(keyWords);
	}
    
    @CacheEvict(value= {"getAllUser","getUserById","findUsers"},allEntries=true)
	@Override
	public void editUser(User user) {
		 this.iUserDao.editUser(user);
	}
}
  