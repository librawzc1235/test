package com.test.cn.test.util.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IoUtil {
	private static Logger log = LoggerFactory.getLogger(IoUtil.class);
	
	/**
	 *  同一台服务器的文件copy
	 * @param inPath
	 * @param outPath
	 * @throws IOException
	 */
	public static void io(String inPath,String outPath) throws IOException {
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(inPath);
			fileOutputStream = new FileOutputStream(outPath);
			byte[] bytes = new byte[1024];
			int num = fileInputStream.read(bytes);
			while (num != -1) {
				fileOutputStream.write(bytes, 0, num);
				num = fileInputStream.read(bytes);
			} 
		} finally {
			if(fileInputStream != null) {
				fileInputStream.close();
			}
			if(fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try {
			String inPath = "E:/install/20190228_docker.mp4";
			String outPath = "F:/nio/b.mp4";
			io(inPath,outPath);
		} catch (IOException e) {
			log.error("io异常"+e.getMessage(),e);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("用时："+(endTime-startTime));
	}
}
