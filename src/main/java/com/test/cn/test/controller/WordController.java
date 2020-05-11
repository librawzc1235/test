package com.test.cn.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cn.test.util.wps.Word2PDFUtil;

@RestController
@RequestMapping("/word")
public class WordController {

	@RequestMapping("/toPdf")
	public String toPdf() {
//		String inPath = "E:/wordToPdf/trans-568002.docx";
//		String outPath = "E:/wordToPdf/trans-568002.pdf";
//		String fontPath = "C:/Windows/Fonts";
//		Word2PDFUtil.doc2pdf(inPath, outPath, fontPath);
		
		String inPath = "/test/trans-568002.docx";
		String outPath = "/wordToPdf/trans-568002.pdf";
		String fontPath = "/usr/share/fonts/chinese";
		Word2PDFUtil.doc2pdf(inPath, outPath, fontPath);
		return null;
	}
}
