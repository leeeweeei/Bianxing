package com.bianxing.bianxing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.model.Action;

public interface ActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
    
    List<Action> selectFromLastSyncTime(@Param("paging")PagingParams paging, @Param("lastSyncTime")Long lastSyncTime, @Param("userId")Long userId);

	Long selectTotalFromLastSyncTime(@Param("lastSyncTime")Long lastSyncTime, @Param("userId")Long userId);
}