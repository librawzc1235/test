package com.test.cn.test.mongo.service;

import java.util.List;

import com.test.cn.test.mongo.entity.UserMd;

public interface UserMgCrudService {

	boolean insert() throws Exception;

	List<UserMd> queryList(int age) throws Exception;

	boolean updateUserName(int age) throws Exception;

	boolean deleteUserMg(int age);

}
