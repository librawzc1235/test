package com.test.cn.test.util.wps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aspose.words.Document;
import com.aspose.words.FontSettings;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

public class Word2PDFUtil {

	static Logger LOG_TRACE = LoggerFactory.getLogger(Word2PDFUtil.class);

	public static boolean getLicense() {
		boolean result = false;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream is = loader.getResource("license.xml").openStream()) {
			License aposeLic = new License();
			aposeLic.setLicense(is);
			result = true;
		} catch (Exception e) {
			LOG_TRACE.error("getLicense excetion:"+e.getMessage(),e);
		}
		return result;
	}

	public static void doc2pdf(String inPath, String outPath, String fontPath) {
		LOG_TRACE.info("验证PDF去水印License");
		if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
			return;
		}
		long old = System.currentTimeMillis();
		File file = new File(outPath); // 新建一个空白pdf文档
		try (FileOutputStream os = new FileOutputStream(file)) {
			LOG_TRACE.info("Font配置地址："+fontPath);
			FontSettings.getDefaultInstance().setFontsFolder(fontPath + File.separator, true);
			Document doc = new Document(inPath); // Address是将要被转化的word文档
			doc.getBuiltInDocumentProperties().setTitle(" ");
			doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
			
			// EPUB, XPS, SWF 相互转换
			long now = System.currentTimeMillis();
			LOG_TRACE.info("共耗时：" + ((now - old) / 1000.0) + "秒");// 转化用时
		} catch (Exception e) {
			LOG_TRACE.info("Font配置信息异常："+e.getMessage(),e);
		}
	}

	public static void doc2pdf(String inPath, String outPath) {
		LOG_TRACE.info("验证PDF去水印License_Nopath");
		if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
			return;
		}
		try {
			long old = System.currentTimeMillis();
			File file = new File(outPath); // 新建一个空白pdf文档
			FileOutputStream os = new FileOutputStream(file);
			FontSettings.getDefaultInstance().setFontsFolder("/yqd/fonts/", true);
			Document doc = new Document(inPath); // Address是将要被转化的word文档
			doc.getBuiltInDocumentProperties().setTitle(" ");
			doc.save(os, SaveFormat.PDF);// 全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF,
			// EPUB, XPS, SWF 相互转换
			long now = System.currentTimeMillis();
			LOG_TRACE.info("共耗时：" + ((now - old) / 1000.0) + "秒");// 转化用时
		} catch (Exception e) {
			LOG_TRACE.error("doc2pdf excetion:"+e.getMessage(),e);
		}
	}
}
