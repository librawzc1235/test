package com.test.cn.wps.util;

public class ExcelConstant {
	/**
     * 每个sheet存储的记录数 100W
     */
    public static final Integer PER_SHEET_ROW_COUNT = 1000000;
 
    /**
                * 每次向EXCEL写入的记录数(查询每页数据大小) 1000条
     */
    public static final Integer PER_WRITE_ROW_COUNT =1000;
 
 
    /**
               * 每个sheet的写入次数 1000(即每个sheet需要执行的sql次数)
     */
    public static final Integer PER_SHEET_WRITE_COUNT = PER_SHEET_ROW_COUNT / PER_WRITE_ROW_COUNT;
    
}
