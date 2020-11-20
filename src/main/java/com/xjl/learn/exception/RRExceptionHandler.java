package com.xjl.learn.exception;

import com.xjl.learn.entity.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;





/**
 * @className: RRExceptionHandler
 * @description: 异常处理
 * @author: xjl
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@InitBinder
	public void initBinder(WebDataBinder binder) {

	}

	/**
	 * 处理自定义异常 @
	 */
	@ExceptionHandler(RRException.class)
	public R handleRRException(RRException e) {
		logger.error(e.getMessage(), e);
		return R.error(e.getMessage());
	}

	/**
	 * 登录失效统一返回的异常信息
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(LoginCheckException.class)
	@ResponseBody
	public R handleLoginCheckException(LoginCheckException e) {
		logger.error(e.getMessage(), e);
		return R.error(e.getCode(), e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e) {
		logger.error(e.getMessage(), e);
		return R.error(e.getMessage());
	}
	/*
	 * @ExceptionHandler(value = LoginCheckNetException.class) public ModelAndView
	 * handleLoginCheckNetException(LoginCheckNetException ex) { ModelAndView
	 * modelAndView = new ModelAndView(); modelAndView.setViewName("login/login");
	 * modelAndView.addObject("code", ex.getCode()); modelAndView.addObject("msg",
	 * ex.getMsg()); return modelAndView; }
	 */

}
