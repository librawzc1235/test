package com.test.cn.service;

import java.util.List;

import com.test.cn.entity.User;

public interface UserService {

	User selectByPrimaryKey(int id);

	List<User> queryUserList(User user);

	List<User> getAllUser();

	List<User> getAllUser2();

}
