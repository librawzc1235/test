package com.test.cn.test.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cn.test.mongo.entity.UserMd;
import com.test.cn.test.mongo.service.UserMgCrudService;

/**
 * mongodb增删改查
 * @author YQD-190211
 *
 */
@RestController
@RequestMapping("/userMg")
public class UserMgCrudController {
	private static Logger log = LoggerFactory.getLogger(UserMgCrudController.class);
	
	@Autowired
	private UserMgCrudService userMgCrudService;
	
	@RequestMapping("/insert")
	public String insert() {
		try {
			boolean  flag = userMgCrudService.insert();
			if(flag) {
				return "mongodb 新增数据成功";
			}
		} catch (Exception e) {
			log.error("UserMgCrudController insert exception:{}",e.getMessage(),e);
		}
		return "失败";
	}
	
	@RequestMapping("/queryList")
	public List<UserMd> queryList() {
		try {
			int age = 20;
			return userMgCrudService.queryList(age);
		} catch (Exception e) {
			log.error("UserMgCrudController queryList exception:{}",e.getMessage(),e);
			return null;
		}
	}
	
	@RequestMapping("/updateUserName")
	public String updateUserName() {
		try {
			int age = 20;
			boolean  flag = userMgCrudService.updateUserName(age);
			if(flag) {
				return "mongodb 修改数据成功";
			}
		} catch (Exception e) {
			log.error("UserMgCrudController update exception:{}",e.getMessage(),e);
		}
		return "失败";
	}
	
	@RequestMapping("/deleteUserMg")
	public String deleteUserMg() {
		try {
			int age = 20;
			boolean  flag = userMgCrudService.deleteUserMg(age);
			if(flag) {
				return "mongodb 删除数据成功";
			}
		} catch (Exception e) {
			log.error("UserMgCrudController update exception:{}",e.getMessage(),e);
		}
		return "失败";
	}
}
