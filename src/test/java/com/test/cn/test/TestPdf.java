package com.test.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.cn.util.JacobUtils;

@SpringBootTest(classes = {TestPdf.class})
@RunWith(SpringRunner.class)
public class TestPdf {

	/**
	 * 这个没有空白页，但是只支持windows环境
	 */
	@Test
	public void jacobToPDF() {
		String source = "F:/word2Pdf/HD湘江·半岛核心璟享定向融资计划（线上版）.docx";
		String target = "F:/word2Pdf/HD湘江·半岛核心璟享定向融资计划（线上版）4.pdf";
		JacobUtils.word2pdf(source,target);
	}
	
	public static void main(String[] args) {
		Integer a = null;
		System.out.println(String.valueOf(a));
		System.out.println(a);
	}
}
