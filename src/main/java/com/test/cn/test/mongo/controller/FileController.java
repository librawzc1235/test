package com.test.cn.test.mongo.controller;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
 
 
/**
 * 文件上传下载
 *
 * @author yangfeng
 * @date 2018-06-04 12:57
 * 
 *     浏览器访问地址：http://localhost:8080/swagger-ui.html
 **/
@RestController
@RequestMapping("/file")
public class FileController {
 
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
 
    // 获得SpringBoot提供的mongodb的GridFS对象
    @Autowired
    private GridFsTemplate  gridFsTemplate;
    
   /**
    * 文件上传
    * PngTest.upload()
    */
    @RequestMapping(value = "/upload")
    public void upload() {
    	log.info("文件上传开始");
		File file = new File("F:\\springbootMongoDB\\推荐资料和合同.png");
		// 获得提交的文件名
        String fileName = file.getName();
        
		try {
			// 获取文件输入流
			FileInputStream fis = new FileInputStream(file);
			// 获取文件类型
			String contentType = "png";
			// 将文件存储到mongodb中
			ObjectId gGridFSFile = gridFsTemplate.store(fis, fileName, contentType);
			log.info("保存成功，objectId:" + gGridFSFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.info("保存失败");
		}
	}
    /**
     * 下载
     *
     * @param fileId   文件id
     * @param response
     * @return
     */
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(@RequestParam(name = "file_id") String fileId, HttpServletRequest request, HttpServletResponse response){
    	log.info("文件下载开始");
    	Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件   
       GridFSFile gfsfile = gridFsTemplate.findOne(query);
//        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        log.info("文件信息:{}",JSON.toJSONString(gfsfile));
        if (gfsfile == null) {
            return;
        }
 
        String fileName = gfsfile.getFilename().replace(",", "");
        log.info("fileName:"+fileName);
        InputStream inputStream = null ;
        ServletOutputStream outputStream = null;
        
        try {
			//处理中文文件名乱码
			if (request.getHeader("User-Agent").toUpperCase().contains("MSIE") ||
			        request.getHeader("User-Agent").toUpperCase().contains("TRIDENT")
			        || request.getHeader("User-Agent").toUpperCase().contains("EDGE")) {
			    fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			}else {
			    //非IE浏览器的处理：
			    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			// 通知浏览器进行文件下载
			response.setContentType(gfsfile.getContentType());
			response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
			
			inputStream = gridFsTemplate.getResource(gfsfile).getInputStream();
			outputStream = response.getOutputStream();
			byte[] bytes = new byte[1024];
			int lenth;
			if((lenth = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, lenth);
			}
			log.info("下载成功");
		} catch (UnsupportedEncodingException e) {
			log.info("下载失败:"+e);
			e.printStackTrace();
		} catch (IOException e) {
			log.info("下载失败:"+e);
			e.printStackTrace();
		}finally {
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        
    }
 
    /**
             * 删除文件
     *
     * @param fileId
     * @return
     */
    @PostMapping(value = "/deleteFile")
    public void deleteFile(@RequestParam(name = "file_id") String fileId) {
        Query query = Query.query(Criteria.where("_id").is(fileId));
        // 查询单个文件  
        GridFSFile gfsfile = gridFsTemplate.findOne(query);
//        com.mongodb.client.gridfs.model.GridFSFile gfsfile = gridFsTemplate.findOne(query);
        if (gfsfile == null) {
        	log.info("文件没有查到");
        }else {
        	gridFsTemplate.delete(query);
        	log.info("删除成功");
        }
        
    }
}