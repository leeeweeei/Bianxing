package com.bianxing.bianxing.service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.model.ExerciseItem;

public interface ExerciseItemService {
	
	PagingResults<ExerciseItem> findPageFromLastSyncTime(PagingParams paging,Long lastSyncTime, Long userId);

	Long save(ExerciseItem exerciseItem);
	
}
