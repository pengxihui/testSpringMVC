/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月12日上午10:55:11 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/

package com.mysql.model;

import java.io.Serializable;

/**
 * description: Date:2018年11月12日上午10:55:11
 */
public class Role implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String roleId;
	private String roleName;
	private int roleState;
	private String roleDesc;

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleState
	 */
	public int getRoleState() {
		return roleState;
	}

	/**
	 * @param roleState
	 *            the roleState to set
	 */
	public void setRoleState(int roleState) {
		this.roleState = roleState;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc
	 *            the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
