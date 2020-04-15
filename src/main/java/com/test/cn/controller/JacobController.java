package com.test.cn.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.cn.util.JacobUtils;

/**
 * window的方式进行word转pdf,这个需要在windows的bin目录下存放jacob-1.14.3-x64.dll文件
 * @author YQD-190211
 *
 */
@Controller
@RequestMapping("/jacob")
public class JacobController {

	@RequestMapping("/wordToPdf")
	@ResponseBody
	public Map<String, String>  wordToPdf(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		
		try {
			String docName = file.getOriginalFilename();
			System.out.println(docName);
			
			String docPath = "F:\\word2Pdf\\bat\\wps"+File.separator + docName;
			String pdfName = docName.substring(0,docName.lastIndexOf("."));
			System.out.println(pdfName);
			
			String pdfPath = "F:\\word2Pdf\\bat\\wps" + File.separator+ pdfName + ".pdf";
			
			JacobUtils.word2pdf(docPath, pdfPath);
			result.put("status", "true");
			result.put("data", null);
		} catch (Exception e) {
			System.out.println("异常信息打印："+e);
			result.put("status", "false");
			result.put("data", "转换异常");
		}
	    return result;
	}
}
