package com.test.cn.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultBean<T> implements java.io.Serializable {

	private static final long serialVersionUID = -1724546458368592165L;
	private static final int MAX_LOG_LEN = 1000;
	private String returnCode = "0000";// 返回代码
	private String returnMessage;// 错误信息描述
	private String hmac;// 哈希校验值
	private T model;// 返回对象
	private int pageCount;// 分页总页数
	private Integer dataCount;// 数据总条数
	//private String serverName = CommUtil.getHostName(); //服务器名称
	private String serviceClass; //服务类名
	private String serviceMethod; //服务方法名
	private Map countMap;//统计汇总数据

	public Map getCountMap() {
		return countMap;
	}

	public void setCountMap(Map countMap) {
		this.countMap = countMap;
	}

	public ResultBean() {
		
	}
	public Integer getDataCount() {
		return dataCount;
	}

	public void setDataCount(Integer dataCount) {
		this.dataCount = dataCount;
	}
	
	

	/*public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
*/
	
	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	/**
	 * 
	 * @param resultCode
	 *            返回代码
	 * @param hmac
	 *            hash签名内容
	 */
	public ResultBean(Prompt prompt) {
		if (prompt != null) {
			this.returnCode = prompt.getCode();
			this.returnMessage = prompt.getMsg();
		}
	}

	/**
	 * 
	 * @param 业务级别的描述
	 *            返回代码
	 * @param hmac
	 *            hash签名内容
	 */
	@SuppressWarnings("unchecked")
	public ResultBean(Boolean flag) {
		if (flag != null) {
			this.model = (T) flag;
		}
	}

	/**
	 * 
	 * @param resultCode
	 *            返回代码
	 * @param hmac
	 *            hash签名内容
	 */
	public ResultBean(Prompt prompt, String hmac) {
		if (prompt != null) {
			this.returnCode = prompt.getCode();
			this.returnMessage = prompt.getMsg();
		}

		this.hmac = hmac;

	}

	/**
	 * 
	 * @param returnCode
	 *            返回代码
	 * @param returnMessage
	 *            错误信息描述
	 * @param model
	 *            返回对象
	 */
	public ResultBean(Prompt code, T model, String hmac) {
		if (model == null) {
			code = new Prompt("DATA_NOT_FOUND", "DATA_NOT_FOUND");
		}
		if (code != null) {
			this.returnCode = code.getCode();
			this.returnMessage = code.getMsg();
			this.model = model;
		}
		this.hmac = hmac;
	}

	/**
	 * 
	 * @param returnCode
	 *            返回代码
	 * @param returnMessage
	 *            错误信息描述
	 * @param model
	 *            返回对象
	 */
	public ResultBean(Prompt code, T model) {
		if (code != null) {
			this.returnCode = code.getCode();
			this.returnMessage = code.getMsg();
			this.model = model;
		}
	}

	/** 根据model返回相应的code */
//	@SuppressWarnings("rawtypes")
//	private Prompt getCodeByModel(Prompt code, T model) {
//		if (model instanceof List) {
//			if (CollectionUtils.isEmpty((List<?>) model)) {
//				code = BaseConstantCode.DATA_NOT_FOUND;
//			}
//		} else if (model == null) {
//			code = BaseConstantCode.DATA_NOT_FOUND;
//		} else if (model instanceof Map) {
//			if (MapUtils.isEmpty((Map) model)) {
//				code = BaseConstantCode.DATA_NOT_FOUND;
//			}
//		}
//		return code;
//	}

	/** 返回代码,默认值为‘0000（成功）’ */
	public String getReturnCode() {
		return returnCode;
	}

	/** 错误信息描述 */
	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	/** 哈希校验值 */
	public String getHmac() {
		return hmac;
	}

	/** 哈希校验值 */
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

	/** 返回对象 */
	public T getModel() {
		return model;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
