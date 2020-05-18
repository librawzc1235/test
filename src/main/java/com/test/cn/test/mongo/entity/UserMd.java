package com.test.cn.test.mongo.entity;

import java.math.BigDecimal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class UserMd {
	private ObjectId id;
	
	private String username;
	
	private String country;
	
	private Address address;
	
	private Favorites favorites;
	
	private int age;
	
	private BigDecimal salary;
	
	private float lenght;
}
