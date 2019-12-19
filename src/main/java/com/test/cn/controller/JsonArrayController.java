package com.test.cn.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.test.cn.entity.JsonObjects;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/json")
@Slf4j
public class JsonArrayController {

	@RequestMapping("/getJsObject")
	public String getJsObject(@RequestBody JsonObjects jsonObjects) {
		log.info("对请求参数打印：{}",JSON.toJSONString(jsonObjects));
		return JSON.toJSONString(jsonObjects);
	}
}
