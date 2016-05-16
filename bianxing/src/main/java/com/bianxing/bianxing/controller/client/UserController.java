package com.bianxing.bianxing.controller.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bianxing.bianxing.common.constant.CodeEnum;
import com.bianxing.bianxing.common.constant.CommonConstant;
import com.bianxing.bianxing.common.util.FileUploadUtil;
import com.bianxing.bianxing.common.util.TokenUtil;
import com.bianxing.bianxing.common.util.sendsms;
import com.bianxing.bianxing.controller.BaseController;
import com.bianxing.bianxing.controller.client.dto.UserDto;
import com.bianxing.bianxing.model.User;
import com.bianxing.bianxing.service.UserService;

/**
 * 用户Controller
 * @author frank
 *
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController{
	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	
	Map<String, String> smsCodeMap = new HashMap<String,String>();
	@RequestMapping(value = "sendSms.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String sendSms(String mobile){
		if(mobile == null) {
			return error(CodeEnum.params_error);
		}
		
		String smsCode = sendsms.sendMsg(mobile);
		smsCodeMap.put(mobile, smsCode);
		return success(smsCode);
		
		//FIXME: 临时代码
//		return success("1019");
	}

	
	@RequestMapping(value = "mobileLogin.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String mobileLogin(String mobile,String smsCode){
		if(mobile == null ) {  //|| smsCode == null
			return error(CodeEnum.params_error);
		}
		
		if("1104".equals(smsCode)) {} // 1104为登录暗号   FIXME
		else{
			// check验证码
			String code = smsCodeMap.get(mobile);
			if(code == null || !smsCode.equals(code)){
				return error(CodeEnum.smscode_error);
			}
		}
		synchronized (this) {
			User user = userService.findByMobile(mobile);
			
			if(user == null) {
				
//				//FIXME： 临时代码，用户内测用户邀请
//				if(!"1019".equals(smsCode)){
//					return error(CodeEnum.smscode_error);
//				}
				
				User user2 = new User();
				user2.setMobile(mobile);
				userService.save(user2);
				user = userService.findByMobile(mobile);
			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("token", TokenUtil.encode(user.getUserId()));
			resultMap.put("user", UserDto.toDto(user));
			return success(resultMap);
		}
		
	}
	
	@RequestMapping(value = "weixinLogin.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String weixinLogin(User user) {
		LOGGER.info("user third login : " + user) ;
		User u = userService.findByPlatformId(user.getPlatformId());
		if(u == null) {
			// regist
			userService.save(user);
			u = userService.findByPlatformId(user.getPlatformId());
		} else {
			// login 
			userService.update(u);
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("token", TokenUtil.encode(u.getUserId()));
		resultMap.put("user", UserDto.toDto(u));
		return success(resultMap);
	}
	
	@RequestMapping(value = "updateUser.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String updateUser(String token,User user,@RequestParam(value = "avatarFile", required = false) MultipartFile avatar) {
		LOGGER.info("save user  :   token "  + token );
		
		if(token == null) return error(CodeEnum.params_error) ;
		
		Long userId = getUserId(token);
		user.setUserId(userId);
//		User u = userService.findByPlatformId(user.getPlatformId());
//		if(u == null || u.getUserId() != userId) {
//			return errorMsg(CodeEnum.CODE_1);
//		}
		
		try {
			String fileName = null;
			if(avatar != null) {
				fileName = FileUploadUtil.saveFile(avatar, CommonConstant.FILE_STORAGE_PATH);
				user.setAvatar(fileName);
			}
			userService.update(user);
			return success(UserDto.toDto(userService.findById(getUserId(token))));
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = "getUserInfo.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String getUserInfo(String token) {
		LOGGER.info("getUserInfo " );
		User user = userService.findById(getUserId(token));
		return success(UserDto.toDto(user));
	}
}
