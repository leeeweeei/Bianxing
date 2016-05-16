package com.bianxing.bianxing.service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.controller.client.dto.ShowDto;
import com.bianxing.bianxing.model.Show;

public interface ShowService {
	
	void save(Show show, String fileName);
	
	void delete(Long showId, Long userId);

	/** 查询用户秀列表**/
	PagingResults<ShowDto> findPageByUserId(Long userId, Long myUserId,PagingParams paging);
	
	/** 查询所有最新的秀列表**/
	PagingResults<ShowDto> findPage(PagingParams paging,Long myUserId);
	
	/** 被赞 **/
	void like(Long userId, Long showId);
	
	/** 取消赞 **/
	void unLike(Long userId, Long showId);
}
