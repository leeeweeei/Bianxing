package com.bianxing.bianxing.service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.model.Exercise;

public interface ExerciseService {
	
	PagingResults<Exercise> findPageFromLastSyncTime(PagingParams paging,Long lastSyncTime, Long userId);

	Long save(Exercise exercise);
	
}
