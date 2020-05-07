package com.test.cn.test.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.test.cn.test.entity.User;
import com.test.cn.test.mapper.UserMapper;
import com.test.cn.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> getPageList() {
		PageHelper.startPage(2, 10);
		List<User> list = userMapper.getPageList();
		return list;
	}

}
