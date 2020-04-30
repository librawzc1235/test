package com.test.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.cn.entity.User;
import com.test.cn.mapper.UserMapper;
import com.test.cn.service.UserService;
import com.test.cn.util.PageUtil;
import com.test.cn.util.ResultBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User selectByPrimaryKey(int id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<User> queryUserList(User user) {
//		PageHelper.startPage(0, 10);
		List<User> list = userMapper.queryUserList(user);
		return list;
	}
	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}
	@Override
	public List<User> getAllUser2() {
		return userMapper.getAllUser2();
	}

}
