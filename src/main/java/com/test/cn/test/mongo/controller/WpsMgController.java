package com.test.cn.test.mongo.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cn.test.mongo.service.WpsMgService;

@RestController
@RequestMapping("/wpsMg")
public class WpsMgController {

	private static Logger log = LoggerFactory.getLogger(WpsMgController.class);
	
	@Resource
	private WpsMgService wpsMgService;
		
	@RequestMapping("/uploadPicture")
	public Object uploadPicture() {
		try {
			return wpsMgService.uploadPicture();
		} catch (Exception e) {
			log.error("WpsMgController insertPicture Exception:{}",e.getMessage(),e);
			return new ObjectId("插入图片失败");
		}
	}
	
	@RequestMapping("/downPicture")
	public void downPicture(HttpServletResponse response) {
		try {
			wpsMgService.downPicture(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
