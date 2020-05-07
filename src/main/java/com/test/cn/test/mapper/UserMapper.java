package com.test.cn.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.cn.test.entity.User;

@Mapper
public interface UserMapper {
	List<User> getPageList();
}