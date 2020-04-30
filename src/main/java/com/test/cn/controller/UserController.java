package com.test.cn.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.cn.entity.PageRequest;
import com.test.cn.entity.User;
import com.test.cn.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController{

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
	
	@RequestMapping("/pageList")
	public List<User> queryUserList(@RequestBody PageRequest pageRequest) {
		Page page= PageHelper.startPage(pageRequest.getStartPage(), pageRequest.getEndPage(),false);
		//  ASC是根据id 正向排序，DESC是反向排序
//        PageHelper.orderBy("id ASC");
		List<User> userList = userService.getAllUser();
		// 获取查询记录总数，必须位于从数据库查询数据的语句之后，否则不生效
//        long total = page.getTotal();
//        log.info("数据总条数:{}",total);
		log.info("UserController queryUser response:{}",JSON.toJSONString(userList));
		List<User> userList3 = userService.getAllUser2();
		return userList;
	}
	
	public static void main(String[] args) {
		BigDecimal parm = null;
		BigDecimal parm2 = null;
		BigDecimal str = parm != null ? parm :parm2 != null ? parm2 : new BigDecimal("2");
		System.out.println(str);
		
		String str3 = "000036";
		System.out.println(Long.valueOf(str3));
	}
	
	
}

