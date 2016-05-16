package com.bianxing.bianxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.common.util.PagingResults;
import com.bianxing.bianxing.common.util.TimeUtil;
import com.bianxing.bianxing.dao.ActionMapper;
import com.bianxing.bianxing.model.Action;
import com.bianxing.bianxing.service.ActionService;

@Service("actionService")
public class ActionServiceImpl implements ActionService {

	@Autowired
	ActionMapper actionMapper;

	@Override
	public PagingResults<Action> findPageFromLastSyncTime(PagingParams paging, Long lastSyncTime,Long userId) {
		PagingResults<Action> result = new PagingResults<Action>();
		result.setRows(actionMapper.selectFromLastSyncTime(paging, lastSyncTime,userId));
		result.setTotal(actionMapper.selectTotalFromLastSyncTime(lastSyncTime,userId));
		return result;
	}

	@Override
	public Long save(Action action) {
		action.setLastModifyTime(TimeUtil.getCurrentSecond());
		if(action.getId() != null && action.getId() > 0 ) {
			actionMapper.updateByPrimaryKey(action);
		} else {
			actionMapper.insert(action);
		}
		return action.getId();
	}

}
