package com.bianxing.bianxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.common.util.TimeUtil;
import com.bianxing.bianxing.dao.ExerciseMapper;
import com.bianxing.bianxing.model.Exercise;
import com.bianxing.bianxing.service.ExerciseService;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {
	
	@Autowired
	ExerciseMapper exerciseMapper;

	@Override
	public PagingResults<Exercise> findPageFromLastSyncTime(PagingParams paging, Long lastSyncTime, Long userId) {
		PagingResults<Exercise> result = new PagingResults<Exercise>();
		result.setRows(exerciseMapper.selectFromLastSyncTime(paging, lastSyncTime,userId));
		result.setTotal(exerciseMapper.selectTotalFromLastSyncTime(lastSyncTime,userId));
		return result;
	}

	@Override
	public Long save(Exercise exercise) {
		exercise.setLastModifyTime(TimeUtil.getCurrentSecond());
		if(exercise.getId() != null && exercise.getId() > 0 ) {
			exerciseMapper.updateByPrimaryKeySelective(exercise);
		} else {
			exerciseMapper.insert(exercise);
		}
		return exercise.getId();
	}

}
