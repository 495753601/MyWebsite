package com.xjl.learn.exception;

/**
 * @className: 登录时的异常
 * @description: 登录时或拿取信息时统一的报错返回信息
 * @author: xjl
 */
public class LoginCheckException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 501;
    
    public LoginCheckException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public LoginCheckException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public LoginCheckException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public LoginCheckException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
