package com.test.cn.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.test.cn.test.entity.User;
import com.test.cn.test.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getPageList")
	public String getPageList() {
		List<User> list = userService.getPageList();
		return JSON.toJSONString(list);
	}
}
