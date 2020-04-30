package com.test.cn.wps.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;

public interface WriteExcelDataDelegated {

	/**
	 * 
	 * @param countSql  		每个sheet需要执行sql的次数
	 * @param pageSize          每页的数据条数
	 * @param startRowCount		sql从第几行数据开始查起 
	 * @param writer			写数据
	 * @param sheet				excel的sheet
	 * @param table             标题
	 */
	public abstract void writeExcelData(Integer countSql, Integer pageSize, Integer startRowCount, ExcelWriter writer,Sheet sheet, Table table);
}
