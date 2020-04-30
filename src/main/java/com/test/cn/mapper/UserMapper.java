package com.test.cn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.cn.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> queryUserList(User user);

	List<User> getAllUser();

	List<User> getAllUser2();
}