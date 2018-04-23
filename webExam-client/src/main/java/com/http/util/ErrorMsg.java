package com.http.util;


/**
 * 
 * @ClassName: ErrorMsg.java
 * @Description: 错误提示语
 * @author huanghc
 * @date 2018年3月19日 下午3:21:27
 */
public class ErrorMsg {

	//成功
	public static final String SUCCESS = "000000";
	/**
	 * 
	 * @ClassName: MobileService
	 * @Description:
	 * @author huanghc
	 * @date 2018年3月19日 下午3:21:27
	 */
	public enum MobileService {
		
		//----------------- 1：请求参数错误----------------------------
		M100000("100000","请求参数不能为空"),
		M100001("100000","请输入手机号码"),
		M100002("100000","证件类型格式错误"),
		M100003("100000","请输入证件号码"),
		M100004("100000","证件号码格式错误，请重新输入"),
		M100005("100000","请输入姓名"),
		
		
		
		
		//MobileService.M900000.getErrCode());
		//----------------- 9：其他错误（会话超时，客户端版本异常...）-------------
		M900000("900000","系统繁忙,请稍后再试"),
		M900001("900001","客户端版本检测失败，请重新安装客户端"),
		M900002("900002","版本更新检查失败"),
		M900003("900003","客户端已过期，请安装最新客户端"),
		M900004("900004","服务器通讯失败，请稍后再试"),
		M900006("900006","客户端参数有误");
		
		
		//错误码
		private String errCode;
		//错误信息
		private String errMsg;


		public String getErrCode() {
			return errCode;
		}

		public String getErrMsg() {
			return errMsg;
		}

		private MobileService(String errCode, String errMsg) {
			this.errCode = errCode;
			this.errMsg = errMsg;
		}

		public static String getMsgByCode(String errCode) {
			for (MobileService ms : MobileService.values()) {
				if (ms.errCode .equals(errCode)) {
					return ms.errMsg;
				}
			}
			return null;
		}

	}
	public static void main(String[] args) {
		System.out.println(MobileService.getMsgByCode("100000"));
	}
	
}
