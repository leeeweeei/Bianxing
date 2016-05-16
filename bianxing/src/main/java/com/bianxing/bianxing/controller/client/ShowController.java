package com.bianxing.bianxing.controller.client;

import java.io.IOException;

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
import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.common.util.TokenUtil;
import com.bianxing.bianxing.controller.BaseController;
import com.bianxing.bianxing.controller.client.dto.ShowDto;
import com.bianxing.bianxing.model.Show;
import com.bianxing.bianxing.service.ShowService;

/**
 * 秀 Controller
 * @author BiShuai
 *
 */
@Controller
@RequestMapping("show")
public class ShowController extends BaseController{
	
	private static final Logger LOGGER = Logger.getLogger(ShowController.class);

	@Autowired
	private ShowService showService;
	
	/**
	 * 分页查询 我的秀信息
	 */
	@RequestMapping(value = "listMine.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String listMine(PagingParams paging, String token) {
		LOGGER.info(paging+", token"+token);
		Long userId = getUserId(token);
		PagingResults<ShowDto> page = showService.findPageByUserId(userId,userId,paging);
		return success(page);
	}
	/**
	 * 分页查询 根据userId查询
	 */
	@RequestMapping(value = "listByUserId.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String listByUserId(PagingParams paging, String token,Long userId) {
		LOGGER.info(paging+", token"+token + " ,userId " + userId);
		Long myUserId = TokenUtil.getIdByToken(token);
		PagingResults<ShowDto> page = showService.findPageByUserId(userId,myUserId,paging);
		return success(page);
	}
	
	/**
	 * 分页查询 所有秀信息
	 */
	@RequestMapping(value = "list.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String list(PagingParams paging, String token ) {
		LOGGER.info(paging + " ,token " + token );
		Long myUserId = TokenUtil.getIdByToken(token);
		PagingResults<ShowDto> page = showService.findPage(paging,myUserId);
		return success(page);
	}
	
	/**
	 * 发表信息
	 */
	@RequestMapping(value = "publish.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String publish(@RequestParam(value = "file", required = false) MultipartFile file, String token, String description,Integer width,Integer height) {
		String fileName;
		try {
			fileName = FileUploadUtil.saveFile(file, CommonConstant.FILE_STORAGE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error("", e);
			return error(CodeEnum.server_error);
		}
		
		Show show = new Show();
		show.setUserId(getUserId(token));
		show.setDescription(description);
		if(width != null && height != null) {
			show.setWidth(width);
			show.setHeight(height);
		}
		showService.save(show, fileName);
		return success(show.getId());
	}
	
	/**
	 * 删除信息
	 */
	@RequestMapping(value = "remove.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String remove(Long showId, String token) {
		Long userId = getUserId(token);
		showService.delete(showId, userId);
		return success();
	}
	
	/**
	 * 赞
	 */
	@RequestMapping(value = "like.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String like(Long showId, String token) {
		Long userId = getUserId(token);
		showService.like(userId, showId);
		return success();
	}
	
	/**
	 * 取消赞
	 */
	@RequestMapping(value = "unLike.do" , method = {RequestMethod.GET,RequestMethod.POST})
	public String unLike(Long showId, String token) {
		Long userId = getUserId(token);
		showService.unLike(userId, showId);
		return success();
	}
}
