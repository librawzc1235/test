package com.test.cn.util;

import java.util.Map;


/** 提示常量，请不要格式化 */
public class ConstantCode extends BaseConstantCode{

	public static final Prompt INVALID_FINANCIALPRODUCT_PRODUCTPERIOD = new  Prompt("1518","产品期限不能为空");
   //**投资回报率不能为空*/
	public static final Prompt INVALID_FINANCIALPRODUCT_RATE = new  Prompt("1521","投资回报率不能为空");
	public static final Prompt INVALID_FINANCIALPRODUCT_LOANHOLDID = new  Prompt("1567","借款项目ID不能为空");

	/**参数不合法*/
	public static final Prompt PARAMETER_ERROR= new Prompt("1702","参数不合法");

	public static final Prompt INVALID_CHECK_BRROWTYPE_PERIOD  = new Prompt("1399","库中已经存在相同的借款期限");

	public static final Prompt INVALID_CHECK_BRROWTYPE_PREFIX = new Prompt("1400","库中已经存在相同的借款类型前缀");

	public static final Prompt INVALID_CHECK_BRROWTYPE_NO = new Prompt("1401","库中已经存在相同的借款类型");

	public static final Prompt INVALID_CHECK_LOANPERIOD = new Prompt("1402","债权回款期限不在 所选债权类型的期限范围内");

	public static final Prompt INVALID_CREATE_FINANCIALPRODUCT_ERROR = new Prompt("1403","创建 产品记录 失败");

	public static final Prompt INVALID_BORROWTYPE_ERROR = new Prompt("1404","借款类型配置不存在");

	public static final Prompt INVALID_LOANTYPE_ERROR = new Prompt("1405","标类型类型配置不存在");

	public static final Prompt INVALID_PLAN_LOANAMOUNT_ERROR = new Prompt("1406","借款金额必须是千的整数倍");

	public static final Prompt INVALID_SUBMIT_DATE_ERROR = new Prompt("1407","发布日期不能小于当前日期");

	public static final Prompt INVALID_LOANHOLD_BORROWTYPE_ERROR = new Prompt("1408","借款类型不能修改");

	public static final Prompt INVALID_LOANHOLD_PLANLOANAMOUNT_ERROR = new Prompt("1409","借款金额不能修改");

	public static final Prompt INVALID_LOANHOLD_LOANPERIOD_ERROR = new Prompt("1410","借款期限不能修改");

	public static final Prompt INVALID_TRANSFER_ASSIGMENT_PROJECTID_ERROR = new Prompt("1411","转让数据没有对应的产品");

	public static final Prompt LOANTYPE_NAME_ERROR = new Prompt("1412","产品类型不允许修改");

	public static final Prompt EXIST_BORROWTYPE=new Prompt("1413", "存在多个启用状态的同借款类型");
	public static final Prompt STOP_BORROWTYPE=new Prompt("1420", "借款类型已停用");
	public static final Prompt STOP_LOANISVAILD=new Prompt("1421", "借款登记已停用");
	public static final Prompt USR10002_ERROR=new Prompt("1414", "请求USR10002失败");
	public static final Prompt USR10039_ERROR=new Prompt("1415", "请求USR10039失败");
	public static final Prompt USR10011_ERROR=new Prompt("1416", "请求USR10011失败");
	public static final Prompt BORROWTYPE_DOUBLE=new Prompt("1417", "存在多条相同的借款类型");
	public static final Prompt BORROWTYPE_ERROR=new Prompt("1418", "缺少借款类型配置");
	public static final Prompt BORROETYPESOME_ERROR=new Prompt("1419","存在多条相同状态的借款类型");
	public static final Prompt PHONE_REGIS_NOTICE = new Prompt("0023","该手机号码已注册，请<a href=\"javascript:loginUser()\" id=\"logindialogId\">登录</a>");
	public static final Prompt INVALID_CHECK_BRROWTYPENAME_NULL = new Prompt("1420","借款类型不能为空");
	public static final Prompt INVALID_CHECK_BRROWTYPENAME_DUPLICATE = new Prompt("1421","借款类型重复");
	public static final Prompt MCH_USER=new Prompt("1420", "手机号码已登记为投资用户，请更换手机号码");
	public static final Prompt SYSTEM = new Prompt("511", "错误代码:");
	public static final Prompt UNKNOWN_ERROR = new Prompt("0007", "系统错误");
	/**ID不能为空*/
	public static final Prompt INVALID_FINANCIALPRODUCT_ID = new  Prompt("1499","产品ID不能为空");

	public static final Prompt ENDDATE_BETWEEN_VALUEDATE=new Prompt("1421", "产品到期日比起息日至少大一天");
		public Map<String, Prompt> getPrompts() {
//			try {
//				return getPrompts(getClass());
//			} catch (IllegalArgumentException | IllegalAccessException e) {
//				e.printStackTrace();
//			}
			return null;
		}
	public static String getErrorMsg(ResultBean<?> bean) {
		if (bean == null)
			return getCode(ConstantCode.UNKNOWN_ERROR);
		return "代码:" + bean.getReturnCode() + ",错误描述:"
				+ bean.getReturnMessage();
	}

	public static String getCode(Prompt prompt){
		return getCode(prompt.getCode());
	}

	public static String getCode(String code){
		return ConstantCode.SYSTEM.getCode()+"-"+code;
	}
}
