package com.bianxing.bianxing.common.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bianxing.bianxing.common.constant.CodeEnum;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final Logger LOGGER = Logger.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		response.setContentType("text/html; charset=UTF-8");

		String token = request.getParameter("token");
		if (StringUtils.isNotBlank(token)) {
			return true;
		}

		LOGGER.info("user not login");

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", CodeEnum.not_login.getCode());
		result.put("msg", CodeEnum.not_login.getMsg());
		response.getWriter().write(JSON.toJSONString(result));
		return false;
	}

	
	
	
	
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
					throws Exception {
		
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}
}

