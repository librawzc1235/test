package com.test.cn.test.mongo.service.imp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.test.cn.test.mongo.entity.Address;
import com.test.cn.test.mongo.entity.Favorites;
import com.test.cn.test.mongo.entity.UserMd;
import com.test.cn.test.mongo.service.UserMgCrudService;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class UserMgCrudServiceImpl implements UserMgCrudService {

	@Resource 
	private MongoOperations tempelate;
	
	@Override
	public boolean insert() throws Exception{
		boolean flag = false;
		UserMd user = new UserMd(); 
		user.setUsername("cang"); 
		user.setCountry("USA"); 
		user.setAge(20); 
		user.setLenght(1.77f); 
		user.setSalary(new BigDecimal("6265.22"));

		//添加“address”子文档
		Address address1 = new Address();
		
		address1.setaCode("411222"); 
		address1.setAdd("sdfsdf"); 
		user.setAddress(address1);
		//添加“favorites”子文档，其中两个属性是数组
		Favorites favorites1 = new Favorites(); 
		favorites1.setCites(Arrays.asList("东莞","东京")); 
		favorites1.setMovies(Arrays.asList("西游记","一路向西")); 
		user.setFavorites(favorites1);

		UserMd user1 = new UserMd(); 
		user1.setUsername("chen"); 
		user1.setCountry("China"); 
		user1.setAge(30); 
		user1.setLenght(1.77f); 
		user1.setSalary(new BigDecimal("6885.22"));
		
		Address address2 = new Address(); 
		address2.setaCode("411000"); 
		address2.setAdd("我的地址 2"); 
		user1.setAddress(address2);
		Favorites favorites2 = new Favorites(); 
		favorites2.setCites(Arrays.asList("珠海","东京")); 
		favorites2.setMovies(Arrays.asList("东游记","一路向东")); 
		user1.setFavorites(favorites2);
		flag = tempelate.insertAll(Arrays.asList(user,user1)) != null;
		return flag;
	}

	@Override
	public List<UserMd> queryList(int age) throws Exception {
		Query query = query(where("age").is(age));
		List<UserMd> list = tempelate.find(query, UserMd.class);
		return list;
	}

	@Override
	public boolean updateUserName(int age) throws Exception  {
		Query query = query(where("age").is(age));
		Update update = update("username","王志成1");
		UpdateResult updateFirst = tempelate.updateFirst(query, update, UserMd.class);
		return updateFirst.getModifiedCount() > 0 ? true:false;
	}

	@Override
	public boolean deleteUserMg(int age) {
		Query query = query(where("age").is(age));
		DeleteResult deleteResult = tempelate.remove(query, UserMd.class);
		return deleteResult.getDeletedCount() > 0 ? true:false;
	}
}
