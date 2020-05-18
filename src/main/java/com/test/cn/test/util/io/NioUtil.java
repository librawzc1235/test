package com.test.cn.test.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NioUtil {

	private static Logger log = LoggerFactory.getLogger(NioUtil.class);
	
	/**
	 * 同一台服务器的文件copy
	 * @param inpath
	 * @throws IOException
	 */
	private static void bigToLittle(String inpath,String outPath) throws IOException {
		ByteBuffer buffered = ByteBuffer.allocate(1024);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(inpath);
			FileChannel inChannel = fileInputStream.getChannel();
			
			FileOutputStream out = new FileOutputStream(outPath);
			FileChannel outChannel = out.getChannel();
			while (inChannel.read(buffered) != -1) {
				buffered.flip();
				outChannel.write(buffered);
				buffered.clear();
			} 
		} finally {
			if(fileInputStream != null) {
				fileInputStream.close();
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		long startTime = System.currentTimeMillis();
		String inPath = "E:/install/20190228_docker.mp4";
		String outPath = "F:/nio/e.mp4";
		File file = new File(inPath);
		File file2 = new File(outPath);
//		try {
//			
//			bigToLittle(inPath);
//		} catch (IOException e) {
//			log.error("nio异常："+e.getMessage(),e);
//		}
		
		Files.copy(file.toPath(), file2.toPath());
//		bigToLittle(inPath,outPath);
		long endTime = System.currentTimeMillis();
		System.out.println("用时："+(endTime-startTime));
	}
	
}
