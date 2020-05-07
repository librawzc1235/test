package com.test.cn.test.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cn.test.entity.InvExcelDown;
import com.test.cn.test.service.InvExcelDownService;

@RestController
@RequestMapping("/invExcelDown")
public class InvExcelDownController {

	private Logger log = LoggerFactory.getLogger(InvExcelDownController.class);
	@Autowired
	private InvExcelDownService invExcelDownService;
	
	@RequestMapping("/downExcel")
	public void downExcel(InvExcelDown invExcelDown,HttpServletResponse respon){
		try {
			invExcelDownService.downExcel(invExcelDown,respon);
		} catch (Exception e) {
			log.info("InvExcelDownController downExcel exception:",e.getMessage(),e);
		}
	}
}
