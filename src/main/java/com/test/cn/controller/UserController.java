package com.test.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.test.cn.bean.User;
import com.test.cn.service.UserService;
import com.test.cn.util.ResultBean;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryUserList")
	public List<User> queryUserList() {
		List<User> userList = userService.queryUserList();
//		log.info("UserController queryUser response:{}",JSON.toJSONString(userList));
		return userList;
	}
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}

