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
import com.bianxing.bianxing.model.Exercise;
import com.bianxing.bianxing.model.ExerciseItem;
import com.bianxing.bianxing.service.ExerciseItemService;
import com.bianxing.bianxing.service.ExerciseService;

/**
 * 日志 Controller
 * @author frank
 *
 */
@Controller
@RequestMapping("exercise")
public class ExerciseController extends BaseController{
	private static final Logger LOGGER = Logger.getLogger(ExerciseController.class);
	
	@Autowired
	ExerciseService exerciseService;
	@Autowired
	ExerciseItemService exerciseItemService;
	
	@RequestMapping(value = "getLastExercises.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String getLastExercises(PagingParams paging, Long lastSyncTime, String token){
		LOGGER.info("getLastExercises lastSyncTime:" + lastSyncTime);
		
		Long userId = getUserId(token);
		return success(exerciseService.findPageFromLastSyncTime(paging, lastSyncTime,userId));
	}
	
	@RequestMapping(value = "saveExercise.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String saveExercise(Exercise exercise,String localId, String token){
		LOGGER.info("saveExercise exercise:" + exercise);
		
		Long userId = getUserId(token);
		exercise.setUserId(userId);
		
		Long id = exerciseService.save(exercise);
		Map<String,Object> result = new HashMap<String,Object> ();
		result.put("id" , id);
		result.put("localId", localId);
		return success(result);
	}
	
	@RequestMapping(value = "saveAllExercise.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String saveAllExercise(String exerciseJsonArray, String token, String from){
		LOGGER.info("saveAllExercise exerciseJsonArray:" + exerciseJsonArray);
		
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		
		Long userId = getUserId(token);
		JSONArray parseArray = JSON.parseArray(exerciseJsonArray);
		for (int j = 0; j < parseArray.size(); j++) {
			JSONObject jsonObject = parseArray.getJSONObject(j);
			
			Exercise exercise = parseArray.getObject(j, Exercise.class);
			if(exercise.getId() != null && exercise.getId() <= 0) {
				exercise.setId(null);
			}
			exercise.setUserId(userId);
			exercise.setSource(from);
			
			String localId = jsonObject.getString("localId");
			
			Long id = exerciseService.save(exercise);
			Map<String,Object> resultMap = new HashMap<String,Object> ();
			resultMap.put("id" , id);
			resultMap.put("localId", localId);
			resultList.add(resultMap);
		}
		return success(resultList);
	}
	
	
	@RequestMapping(value = "getLastExerciseItems.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String getLastExerciseItems(PagingParams paging, Long lastSyncTime, String token){
		LOGGER.info("getLastExerciseItems lastSyncTime:" + lastSyncTime);
		
		Long userId = getUserId(token);
		return success(exerciseItemService.findPageFromLastSyncTime(paging, lastSyncTime,userId));
	}
	
	
	@RequestMapping(value = "saveExerciseItem.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String saveExerciseItem(ExerciseItem exerciseItem,String localId,String token){
		LOGGER.info("saveExerciseItem exerciseItem:" + exerciseItem);
		
		Long userId = getUserId(token);
		exerciseItem.setUserId(userId);
		Long id = exerciseItemService.save(exerciseItem);
		
		Map<String,Object> result = new HashMap<String,Object> ();
		result.put("id" , id);
		result.put("localId", localId);
		return success(result);
	}
	
	
	@RequestMapping(value = "saveAllExerciseItem.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String saveAllExerciseItem(String exerciseItemJsonArray, String token,String from){
		LOGGER.info("saveAllExerciseItem exerciseItemJsonArray:" + exerciseItemJsonArray);
		
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		
		Long userId = getUserId(token);
		JSONArray parseArray = JSON.parseArray(exerciseItemJsonArray);
		for (int j = 0; j < parseArray.size(); j++) {
			JSONObject jsonObject = parseArray.getJSONObject(j);
			
			ExerciseItem exerciseItem = parseArray.getObject(j, ExerciseItem.class);
			if(exerciseItem.getId() != null && exerciseItem.getId() <= 0 ) {
				exerciseItem.setId(null);
			}
			exerciseItem.setUserId(userId);
			exerciseItem.setSource(from);
			
			String localId = jsonObject.getString("localId");
			Long id = exerciseItemService.save(exerciseItem);
			Map<String,Object> resultMap = new HashMap<String,Object> ();
			resultMap.put("id" , id);
			resultMap.put("localId", localId);
			resultList.add(resultMap);
		}
		return success(resultList);
	}
}
