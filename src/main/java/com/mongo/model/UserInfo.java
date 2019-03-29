/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年10月25日上午11:21:52 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserInfo {
    
	private String id;
    
	private String username;
    
	private String nickname;
	
	private String sex;
	
	private String age;
	
	public UserInfo() {}
	
    public UserInfo(String username,String nickname,String sex,String age) {
    	super();
    	this.username = username;
    	this.nickname = nickname;
    	this.sex = sex;
    	this.age = age;
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 
	 * the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username 
	 * the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname 
	 * the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getAge() {
		return age;
	}

	/**
	 * @param age 
	 * the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
    
    
}
  