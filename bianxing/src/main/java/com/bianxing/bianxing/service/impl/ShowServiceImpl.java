package com.bianxing.bianxing.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bianxing.bianxing.common.constant.CommonConstant;
import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.controller.client.dto.ShowDto;
import com.bianxing.bianxing.dao.PhotoMapper;
import com.bianxing.bianxing.dao.ShowMapper;
import com.bianxing.bianxing.dao.ShowPhotoRelMapper;
import com.bianxing.bianxing.dao.ShowUserLikeRelMapper;
import com.bianxing.bianxing.model.Photo;
import com.bianxing.bianxing.model.Show;
import com.bianxing.bianxing.model.ShowPhotoRel;
import com.bianxing.bianxing.model.ShowUserLikeRel;
import com.bianxing.bianxing.service.ShowService;

@Service("showService")
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowMapper showMapper;

	@Autowired
	ShowPhotoRelMapper showPhotoRelMapper;

	@Autowired
	PhotoMapper photoMapper;
	
	@Autowired
	ShowUserLikeRelMapper showUserLikeRelMapper;

	private static final Logger LOGGER = Logger
			.getLogger(ShowServiceImpl.class);

	@Override
	public void save(Show show, String fileName) {
		LOGGER.info(show);
		showMapper.insertSelective(show);
		
		Photo po = new Photo();
		po.setFileName(fileName);
		po.setCreateUserId(show.getUserId());
		po.setCreateTime(System.currentTimeMillis());
		photoMapper.insert(po);
		
		ShowPhotoRel record = new ShowPhotoRel();
		record.setShowId(show.getId());
		record.setPhotoId(po.getId());
		showPhotoRelMapper.insertSelective(record);
	}

	@Override
	public void delete(Long showId, Long userId) {
		LOGGER.info("showId: " + showId + ", userId: " + userId);
		showMapper.updateStatus2Delete(showId, userId);
	}

	@Override
	public PagingResults<ShowDto> findPageByUserId(Long userId,Long myUserId, PagingParams paging) {
		PagingResults<ShowDto> result = new PagingResults<ShowDto>();
		result.setRows(showMapper.selectDtoPage(paging, userId,myUserId));
		result.setTotal(showMapper.selectTotal(userId));
		return result;
	}

	@Override
	public PagingResults<ShowDto> findPage(PagingParams paging,Long myUserId) {
		PagingResults<ShowDto> result = new PagingResults<ShowDto>();
		List<ShowDto> showDtoList = showMapper.selectDtoPage(paging, null,myUserId);
		result.setRows(showDtoList);
		result.setTotal(showMapper.selectTotal(null));
		return result;
	}

	@Override
	public void like(Long userId, Long showId) {
		ShowUserLikeRel record = new ShowUserLikeRel(userId, showId);
		ShowUserLikeRel find = showUserLikeRelMapper.select(record);
		if(find != null){
			//已经点过赞，直接返回
			return ;
		}
		
		record.setCreateTime(System.currentTimeMillis());
		
		int count = showUserLikeRelMapper.insertSelective(record);
		if(count == 1){
			//累积被赞次数
			showMapper.addLikeCount(showId);
		}
	}

	@Override
	public void unLike(Long userId, Long showId) {
		int count = showUserLikeRelMapper.delete(userId, showId);
		if(count == 1){
			//被赞次数减1
			showMapper.decreaseLikeCount(showId);
		}
	}

}
