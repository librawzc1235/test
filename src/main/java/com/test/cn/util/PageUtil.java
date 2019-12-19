package com.test.cn.util;

import java.util.List;

import com.github.pagehelper.Page;

public class PageUtil {

	public static <T> ResultBean<List<T>> creatBean(Page<T> list){
		int pageCount =list.getPages();
		 List<T> listObj= list.getResult();
		 ResultBean bean = new ResultBean<List<T>>(ConstantCode.SUCCESS,listObj);
		 bean.setPageCount(pageCount);
		 bean.setDataCount(Integer.valueOf(Long.toString(list.getTotal())));
		return bean;
	}
}
