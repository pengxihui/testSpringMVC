/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月12日上午11:16:01 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mysql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.mapper.RoleMapper;
import com.mysql.model.Role;
import com.mysql.service.RoleService;
@Service
public class RoleDaoImpl implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public void insert(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public void delete(String roleId) {
		roleMapper.delete(roleId);
	}

	@Override
	public Role selectById(String roleId) {
		Role role = roleMapper.selectById(roleId);
		return role;
	}

	@Override
	public void update(Role role) {
		roleMapper.update(role);
	}
}
  