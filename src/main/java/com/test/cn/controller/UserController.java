package com.test.cn.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.test.cn.entity.User;
import com.test.cn.service.UserService;
import com.test.cn.util.ResultBean;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/put")
	public String put() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("A", "a");
		map.put("B", "b");
		map.put("C", "c");
		log.info("UserController put response:{}",JSON.toJSONString(map));
		return JSON.toJSONString(map);
	}

	@RequestMapping("/queryUserList")
	public List<User> queryUserList(@RequestBody User user) {
		List<User> userList = userService.queryUserList(user);
		log.info("UserController queryUser response:{}",JSON.toJSONString(userList));
		return userList;
	}
	
	public static void main(String[] args) {
		BigDecimal parm = null;
		BigDecimal parm2 = null;
		BigDecimal str = parm != null ? parm :parm2 != null ? parm2 : new BigDecimal("2");
		System.out.println(str);
	}
	
}

