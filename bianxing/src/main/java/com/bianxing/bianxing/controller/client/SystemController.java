package com.bianxing.bianxing.controller.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bianxing.bianxing.common.constant.CommonConstant;
import com.bianxing.bianxing.controller.BaseController;

/**
 * 系统Controller
 * @author frank
 *
 */
@Controller
@RequestMapping("system")
public class SystemController extends BaseController{
	private static final Logger LOGGER = Logger.getLogger(SystemController.class);
	
	
	@RequestMapping(value = "getSwitch.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String getSwitch(String appVersion){
		LOGGER.info("getSwitch  appVersion : " + appVersion);
		
		Map<String,Object> map = new HashMap<String,Object>();
//		if(appVersion != null && "1.1.4".equals(appVersion)) {
//			map.put("switchXiu", "0");
//		} else {
			map.put("switchXiu", CommonConstant.SWITCH_XIU);
//		}
		return success(map);
	}

}
