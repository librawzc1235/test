package com.test.cn.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.cn.test.entity.InvExcelDown;

@Mapper
public interface InvExcelDownMapper {
	Integer queryCount();

	List<InvExcelDown> downInvExcelDownList(InvExcelDown invExcelDown);
	
	List<InvExcelDown> downInvExcelDownPageList(InvExcelDown invExcelDown);
}