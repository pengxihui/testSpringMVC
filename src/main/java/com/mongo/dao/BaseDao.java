/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年10月25日上午11:29:29 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mongo.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBCollection;

public interface BaseDao {
	/**
	 * add:添加
	 * @author pxh 
	 * @param obj
	 */
     void add(Object T);
     
     /**
      * delete:删除
      * @author pxh 
      * @param key
      */
     void delete(Object T);
     /**
      * select:查询
      * @author pxh 
      * @param key
      */
     DBCollection select(String collectionName);
     /**
      * update:修改
      * @author pxh 
      * @param obj
      */
     void update(Query query,Update update,String collectionName);
}
  