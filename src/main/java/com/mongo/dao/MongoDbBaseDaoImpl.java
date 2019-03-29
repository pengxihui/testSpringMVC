/** 
 * Project Name:testSpringMVC 
 * author pxh
 * Date:2018年10月25日上午11:33:14 
 * Copyright (c) 2018, 迈克医疗电子有限公司  All Rights Reserved. 
 * version 1.0
*/  
  
package com.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
@Repository(value = "baseDaoImpl")
public class MongoDbBaseDaoImpl implements BaseDao{
    @Autowired
    @Qualifier("mongoTemplate") //当多个类实现了同一接口时，不知道哪个是合格者，需要用qualifier来标识
	protected MongoTemplate mongoTemplate;

	@Override
	public void add(Object T) {
		this.mongoTemplate.insert(T);
		
	}

	@Override
	public void delete(Object T) {
		this.mongoTemplate.remove(T);
		
	}

	@Override
	public DBCollection select(String collectionName) {
		return this.mongoTemplate.getCollection(collectionName);
	}

	@Override
	public void update(Query query, Update update, String collectionName) {
        this.mongoTemplate.updateMulti(query, update, collectionName);		
	}
}
  