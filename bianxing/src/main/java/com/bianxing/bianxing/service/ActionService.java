package com.bianxing.bianxing.service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.model.Action;

public interface ActionService {
	
	PagingResults<Action> findPageFromLastSyncTime(PagingParams paging,Long lastSyncTime, Long userId);

	Long save(Action action);
	
}
