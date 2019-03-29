/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月21日下午2:25:30 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.redis.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -4135517288939641518L;

	private int id;
	
	private String userName;
	
	private String sex;
	
	private int age;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id 
	 * the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName 
	 * the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex 
	 * the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age 
	 * the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", sex=" + sex + ", age=" + age + "]";
	}
}
  