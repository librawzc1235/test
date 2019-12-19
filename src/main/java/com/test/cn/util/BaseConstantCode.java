package com.test.cn.util;

import java.util.HashMap;
import java.util.Map;




/** 提示常量，请不要格式化 */
public abstract class BaseConstantCode{
	/**
	 * 
	 */
	/** 成功 */
	public static final Prompt SUCCESS = new Prompt("0000", "成功！");//
	/** 没有发现数据 */
	public static final Prompt DATA_NOT_FOUND = new Prompt("0001", "没有找到数据！");//
	/** 用户名或密码错误！ */
	public static final Prompt USERNAME_OR_PASSWORD_NOT_CORRECT = new Prompt(
			"0002", "用户名或密码错误！"); //
	/** 找不到用户！ */
	public static final Prompt USER_NOT_FOUND = new Prompt("0003", "找不到用户！"); //
	
	/** 文件上传失败 */
	public static final Prompt UPLOAD_ERROR = new Prompt("2001", "文件上传失败"); 
	
	/** 远程调用超时 */
	public static final Prompt SOCKET_TIMEOUT_EXCEPTION = new Prompt("9002", "远程方法调用超时"); //
	
	/** 未知远程主机错误 */
	public static final Prompt UNKNOWN_HOST_EXCEPTION = new Prompt("9003", "未知远程主机错误"); //
	
	/** 远程连接未启动 */
	public static final Prompt CONNECT_EXCEPTION = new Prompt("9004", "远程连接未启动"); //

	/** 请求参数非法！ */
	public static final Prompt INVALID = new Prompt("1000", "请求参数非法！"); //

	/** 系统发生异常！ */
	public static final Prompt EXCEPTION = new Prompt("6000", "系统发生异常！"); //
	
	
	/** 数据库发生异常！ */
	public static final Prompt EXCEPTION_OCCUR_IN_DB = new Prompt("6001",
			"数据库发生异常！"); //

	/** SQL异常 */
	public static final Prompt SQLEXCEPTION = new Prompt("6002", "SQL异常");
	/** 方法传递了一个不合法或不正确的参数 */
	public static final Prompt ILLEGALARGUMENTEXCEPTION = new Prompt("6003",
			"方法传递了一个不合法或不正确的参数");
	/** 算法异常 */
	public static final Prompt NOSUCHALGORITHMEXCEPTION = new Prompt("6004",
			"没有这样的算法,算法异常");
	/** 线程状态跟改异常 */
	public static final Prompt INTERRUPTEDEXCEPTION = new Prompt("6005",
			"线程状态跟改异常");
	/** 返回结果异常 */
	public static final Prompt RESULTBEANEXCEPTION = new Prompt("6006",
			"返回结果异常");

	/** 系统异常,请稍后再试. */
	public static final Prompt SYSERR = new Prompt("6007", "系统异常,请稍后再试."); 
	
	/** 现金券余额异常，请联系客服！ */
	public static final Prompt AMOUNT_INSUFFICIENT = new Prompt("999", "现金券余额异常，请联系客服！"); //
	
	/** 系统错误！ */
	public static final Prompt ERROR = new Prompt("9000", "系统错误！"); //
	/** 数据库中数据错误 */
	public static final Prompt DATA_ERROR = new Prompt("9001", "数据库中数据错误");
	
	/**流水表有重复信息*/
	public static final Prompt REPEAT_DATA = new Prompt("6110", "流水表有重复信息");
	
	/**流水表有重复信息*/
	public static final Prompt INSERT_FLOW_EXCEPTION = new Prompt("6111", "插入流水表有异常");
	
	/**连接第三方支付超时*/
	public static final Prompt PAY_CONNECT_EXCEPTION = new Prompt("9998", "连接第三方支付超时,请重试");
	
	/**连接第三方支付超时*/
	public static final Prompt PAY_WITHDRAW_AMOUNT_CHECKED_EXCEPTION = new Prompt("6123", "提现金额大于账户可用余额(新网)");
	
	/** 钱包系统发生异常！ */
	public static final Prompt WALLET_EXCEPTION = new Prompt("6666", "钱包系统发生异常！"); //

	/** 理财师报单错误！ */
	public static final Prompt CRM_FORM_COUNT_MAX = new Prompt("8000", "今天报单已超过10次，请明天再试！"); //
	
	/** 用户想要更换的手机号码和身份信息不匹配！ */
	public static final Prompt CELLPHONE_NOT_MATCH = new Prompt("8001", "您填写的手机号与原号不一致，请核实信息后再试。"); //
	
	/** 用户想要更换的新银行卡和旧银行卡相同 */
	public static final Prompt BANK_CARD_NO_SAME = new Prompt("8002", "您填写的新银行卡号和原银行卡号一致,请核实信息后再试");
	
	/**
	 * 获取Prompt对象的map集合
	 * <ul>
	 * <li><font color='red'>key为Prompt的msg</font></li>
	 * <li><font color='red'>value为Prompt对象</font></li>
	 * <ul>
	 * */
	public abstract Map<String, Prompt> getPrompts();

	/**
	 * @see 根据 传入的class内的所有Prompt对象 的map集合
	 * 
	 * @return 所有Prompt对象 的map集合
	 *         <ul>
	 *         <li><font color='red'>key为Prompt的msg</font></li>
	 *         <li><font color='red'>value为Prompt对象</font></li>
	 *         <ul>
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * */

	public  Map<String, Prompt> getPrompts(Class<?> clazz) throws IllegalArgumentException, IllegalAccessException {
		Map<String, Prompt> constantCodeFiledMap = new HashMap<String, Prompt>();
		java.lang.reflect.Field[] fields = clazz.getFields();

		Prompt p1 = BaseConstantCode.SUCCESS;// 定义一下初始化的值

		for (java.lang.reflect.Field field : fields) {
			Prompt p = (Prompt) field.get(p1);
			constantCodeFiledMap.put(p.getMsg(), p);
		}
		return constantCodeFiledMap;
	}

}
