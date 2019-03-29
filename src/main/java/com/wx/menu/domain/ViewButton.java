/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年9月19日上午11:40:20 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.wx.menu.domain;  

/**
 * 
 * description: 视图型菜单事件
 * Date:2018年9月19日上午11:42:33
 */
public class ViewButton {
	
     private String type;
     private String name;
     private String url;
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type 
	 * the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 
	 * the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url 
	 * the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
  