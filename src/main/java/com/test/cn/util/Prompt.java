package com.test.cn.util;

/** 提示类 */
public class Prompt implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3043932158079937817L;
	private String code;// 提示编码
	private String msg;// 提示编信息

	public Prompt(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/** 提示编码 */
	public String getCode() {
		return code;
	}

	/** 提示编码 */
	public void setCode(String code) {
		this.code = code;
	}

	/** 提示编信息 */
	public String getMsg() {
		return msg;
	}

	/** 提示编信息 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
