package com.test.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.cn.util.JacobUtils;

@Controller
@RequestMapping("/ind")
public class IndexController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("toPdf")
	public void toPdf() {
//		String source = "F:/word2Pdf/HD湘江·半岛核心璟享定向融资计划（线上版）.docx";
//		String target = "F:/word2Pdf/HD湘江·半岛核心璟享定向融资计划（线上版）.pdf";
		
		String source = "F:/word2Pdf/HD湘江·半岛核心璟享定向融资计划（线上版）.docx";
		String target = "F:/word2Pdf/HD湘江·半岛核心璟享定向融资计划（线上版）.pdf";
		JacobUtils.word2pdf(source,target);
	}
}
