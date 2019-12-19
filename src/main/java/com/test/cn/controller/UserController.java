package com.test.cn.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.test.cn.entity.User;
import com.test.cn.service.UserService;

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
	
	@RequestMapping("/getList")
	public String getList(User user) {
		List list = userService.pageList(user);
		return JSON.toJSONString(list);
	}
	
	public static void main(String[] args) {
		BigDecimal parm = null;
		BigDecimal parm2 = null;
		BigDecimal str = parm != null ? parm :parm2 != null ? parm2 : new BigDecimal("2");
		System.out.println(str);
	}
	
}
