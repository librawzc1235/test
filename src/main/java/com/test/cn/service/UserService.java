package com.test.cn.service;

import java.util.List;

import com.test.cn.bean.User;

public interface UserService {

	User selectByPrimaryKey(int id);

	List<User> queryUserList();

}
