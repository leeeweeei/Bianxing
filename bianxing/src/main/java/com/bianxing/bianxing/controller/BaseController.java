package com.bianxing.bianxing.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSON;
import com.bianxing.bianxing.common.constant.CodeEnum;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.common.util.TokenUtil;

public class BaseController {

	private HttpServletResponse response;
	
	private final int SUCCESS_CODE = 0;
	private final String SUCCESS_MSG = "success";
	
	@ModelAttribute
	public void preHandle(HttpServletResponse response){
		this.response = response;
		response.setContentType("text/html; charset=UTF-8");
	}
	
	protected Long getUserId(String token) {
		return TokenUtil.getIdByToken(token);
	}

	public String jsonMsg(int code, String message, Object data, Long rows) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", code);
		if(code == SUCCESS_CODE){
			result.put("success", true);
		}
		if(data != null){
			result.put("data", data);
		}
		if(rows != null){
			result.put("count", rows);
		}
		try {
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String error(int code, String message) {
		return jsonMsg(code, message, null, null);
	}

	public String error(CodeEnum ce) {
		return error(ce.getCode(), ce.getMsg());
	}

	public String success(Object entity) {
		return jsonMsg(SUCCESS_CODE, SUCCESS_MSG, entity, null);
	}
	
	public String success(){
		return jsonMsg(SUCCESS_CODE, SUCCESS_MSG, null, null);
	}

	/**
	 * 分页查询返回JSON串
	 * 
	 * @param hospitalInfo
	 * @return
	 */
	public String success(PagingResults<?> info) {

		return jsonMsg(SUCCESS_CODE, SUCCESS_MSG, info.getRows(), info.getTotal());
	}

	public Long getCurrentUserId(HttpServletRequest request) {
		return 8L;
	}

	public Long getCurrentUser(HttpServletRequest request) {
		return 8L;
	}
}
