package com.test.cn.test.service;

import javax.servlet.http.HttpServletResponse;

import com.test.cn.test.entity.InvExcelDown;

public interface InvExcelDownService {

	void downExcel(InvExcelDown invExcelDown, HttpServletResponse response) throws Exception;

}
