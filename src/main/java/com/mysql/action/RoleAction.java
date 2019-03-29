/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年11月12日上午11:23:13 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mysql.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.mysql.model.Role;
import com.mysql.service.RoleService;

/** 
 * description: 
 * Date:2018年11月12日上午11:23:13 
 */
@Controller
@RequestMapping("/role")
public class RoleAction {
	@Autowired
	private RoleService roleService;
	
    @RequestMapping(value="/init",method=RequestMethod.GET)
	public String initRolePage(HttpServletRequest request) {
	     return "mysql/role";	
	}
	
	@RequestMapping(value="/get",produces="application/json;charset=UTF-8",method = RequestMethod.GET)
	@ResponseBody
	public String getRoleInfo(String roleId,HttpServletRequest request) {
		Role role = roleService.selectById(roleId);
        return resultSuccess(role);
	}
	
	/**
     * 
     * @param obj
     * @return
     */
    public String  resultSuccess(Object obj) {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("success",true);
        jsonObject.put("data",obj);
        return jsonObject.toJSONString();
    }
    
    /**
     * 
     * @param error
     * @return
     */
    public String  resultError(String error) {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("success",false);
        jsonObject.put("error",error);
        return jsonObject.toJSONString();
    }
}
  