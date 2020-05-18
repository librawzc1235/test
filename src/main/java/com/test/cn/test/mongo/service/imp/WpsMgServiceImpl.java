package com.test.cn.test.mongo.service.imp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.test.cn.test.mongo.service.WpsMgService;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@Slf4j
public class WpsMgServiceImpl implements WpsMgService {

	@Autowired
    private  GridFsTemplate gridFsTemplate;
	
	@Override
	public ObjectId uploadPicture() throws IOException {
		 String filePath = "F:/a/apache-tomcat-7.0.57-src.zip";
		 String filename = "apache-tomcat-7.0.57-src.zip";
		 String only = UUID.randomUUID().toString();//可以是唯一标致,方便取出
		 
		 Document document = new Document();
		 document.put("userName", "abc");
		 document.put("aliases", only);
		 document.put("filename", filename);
		 document.put("contentType", filename.substring(filename.lastIndexOf(".")));
		 ObjectId store = gridFsTemplate.store(new FileInputStream(filePath), filename, document);
		 //mongoId为主键ID
		 String mongoId = store.toString();
		 log.info(mongoId);
		 return store;
	}
	@Override
	public void downPicture(HttpServletResponse response) throws IOException {
		Query query = query(where("filename").is("apache-tomcat-7.0.57-src.zip"));
		GridFSFile gridFSFile = gridFsTemplate.findOne(query);
		GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
		InputStream inputStream = resource.getInputStream();
		OutputStream outputStream = new FileOutputStream("F:/"+UUID.randomUUID().toString()+".zip");
		byte[] bytes = new byte[1024];
		int lenth;
		while((lenth = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes,0,lenth);
		}
		outputStream.close();
		inputStream.close();
	}

}
