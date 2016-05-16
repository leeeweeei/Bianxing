package com.bianxing.bianxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.common.util.TimeUtil;
import com.bianxing.bianxing.dao.ExerciseItemMapper;
import com.bianxing.bianxing.model.Exercise;
import com.bianxing.bianxing.model.ExerciseItem;
import com.bianxing.bianxing.service.ExerciseItemService;

@Service("exerciseItemService")
public class ExerciseItemServiceImpl implements ExerciseItemService {
	
	@Autowired
	ExerciseItemMapper exerciseItemMapper;

	@Override
	public PagingResults<ExerciseItem> findPageFromLastSyncTime(PagingParams paging, Long lastSyncTime, Long userId) {
		PagingResults<ExerciseItem> result = new PagingResults<ExerciseItem>();
		result.setRows(exerciseItemMapper.selectFromLastSyncTime(paging, lastSyncTime,userId));
		result.setTotal(exerciseItemMapper.selectTotalFromLastSyncTime(lastSyncTime,userId));
		return result;
	}


	@Override
	public Long save(ExerciseItem exerciseItem) {
		exerciseItem.setLastModifyTime(TimeUtil.getCurrentSecond());
		if(exerciseItem.getId() != null && exerciseItem.getId() > 0 ) {
			exerciseItemMapper.updateByPrimaryKeySelective(exerciseItem);
		} else {
			exerciseItemMapper.insert(exerciseItem);
		}
		return exerciseItem.getId();

	}

}
