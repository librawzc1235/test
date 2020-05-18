package com.test.cn.test.mongo.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
 
public interface WpsMgService {

	Object uploadPicture() throws IOException;

	void downPicture(HttpServletResponse response) throws IOException;

}
