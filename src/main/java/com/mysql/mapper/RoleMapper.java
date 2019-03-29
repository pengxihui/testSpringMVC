/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月12日上午11:23:50 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mysql.mapper;

import com.mysql.model.Role;

public interface RoleMapper {

	/**
	 * insert:添加角色
	 * @author pxh 
	 * @param role
	 */
	void insert(Role role);
	/**
	 * delete:删除角色信息
	 * @author pxh 
	 * @param roleId
	 */
	void delete(String roleId);
    /**
     * selectById:根据角色id查询角色信息
     * @author pxh 
     * @param roleId
     * @return
     */
	Role selectById(String roleId);
    /**
     * update:更新角色信息
     * @author pxh 
     * @param role
     */
	void update(Role role);
}
  