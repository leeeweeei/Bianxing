package com.bianxing.bianxing.controller.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.controller.BaseController;
import com.bianxing.bianxing.model.Action;
import com.bianxing.bianxing.service.ActionService;

/**
 * Action Controller
 * @author frank
 *
 */
@Controller
@RequestMapping("action")
public class ActionController extends BaseController{
	private static final Logger LOGGER = Logger.getLogger(ActionController.class);
	
	@Autowired
	ActionService actionService;
	
	@RequestMapping(value = "getLastActions.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String getLastActions(PagingParams paging, Long lastSyncTime, String token){
		LOGGER.info("getActions lastSyncTime:" + lastSyncTime);
		
		Long userId = getUserId(token);
		return success(actionService.findPageFromLastSyncTime(paging, lastSyncTime,userId));
	}
	
	@RequestMapping(value = "saveAction.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String saveAction(Action action,String localId, String token){
		LOGGER.info("saveAction action:" + action);
		
		Long userId = getUserId(token);
		action.setUserId(userId);
		Long id = actionService.save(action);
		
		Map<String,Object> result = new HashMap<String,Object> ();
		result.put("id" , id);
		result.put("localId", localId);
		return success(result);
	}
	
	@RequestMapping(value = "saveAllAction.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String saveAllAction(String actionJsonArray, String token,String from){
		LOGGER.info("saveAllAction actionJsonArray:" + actionJsonArray);
		
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		
		Long userId = getUserId(token);
		JSONArray parseArray = JSON.parseArray(actionJsonArray);
		for (int j = 0; j < parseArray.size(); j++) {
			JSONObject jsonObject = parseArray.getJSONObject(j);
			
			Action action = parseArray.getObject(j, Action.class);
			if(action.getId() != null && action.getId() <= 0 ) {
				action.setId(null);
			}
			if(action.getId() < 184) {
				//保护default数据 TODO 应该用另一种方案 ：  想查询判断这个Action是否属于该用户
				continue;
			}
			
			action.setUserId(userId);
			action.setSource(from);
			
			String localId = jsonObject.getString("localId");
			
			Long id = actionService.save(action);
			Map<String,Object> resultMap = new HashMap<String,Object> ();
			resultMap.put("id" , id);
			resultMap.put("localId", localId);
			resultList.add(resultMap);
		}
		return success(resultList);
	}
	

}
