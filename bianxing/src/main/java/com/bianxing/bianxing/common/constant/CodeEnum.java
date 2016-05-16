package com.bianxing.bianxing.common.constant;

public enum CodeEnum {
	 
	/**  参数异常 **/
	params_error(1,"params error"),
	/** 服务器异常 **/
	server_error(2,"server error"),
	
	/** 电话已存在 **/
	CODE_1004(1004, "Tel already exists."),
	
	smscode_error(1001,"sms code error"),
	not_login(-1, "not login");
	
	
	
	
	private final int code;
	
	private final String msg;

	CodeEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	
}
