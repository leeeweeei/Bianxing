package com.bianxing.bianxing.common.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

public class GlobalExceptionHandler implements HandlerExceptionResolver {

	private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object arg2, Exception e) {

		LOGGER.error("", e);
		
		e.printStackTrace();
		response.setContentType("text/html; charset=UTF-8");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 500);
		result.put("message", e.getMessage());
		try {
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException e1) {
		}
		return null;
	}
}