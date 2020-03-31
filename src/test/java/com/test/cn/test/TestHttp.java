package com.test.cn.test;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.test.cn.entity.User;

public class TestHttp {

	public static void main(String[] args) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://139.196.162.163:8082/user/queryUserList";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		User user = new User();
		user.setUsername("admin");
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		ResponseEntity<User> result = restTemplate.exchange(url, HttpMethod.POST, entity, User.class);
		System.out.println(result.getBody());
	}
}
