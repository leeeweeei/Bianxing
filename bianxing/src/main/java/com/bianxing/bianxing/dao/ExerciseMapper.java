package com.bianxing.bianxing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.model.Action;
import com.bianxing.bianxing.model.Exercise;

public interface ExerciseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Exercise record);

    int insertSelective(Exercise record);

    Exercise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Exercise record);

    int updateByPrimaryKey(Exercise record);
    
    List<Exercise> selectFromLastSyncTime(@Param("paging")PagingParams paging, @Param("lastSyncTime")Long lastSyncTime, @Param("userId")Long userId);

   	Long selectTotalFromLastSyncTime(@Param("lastSyncTime")Long lastSyncTime, @Param("userId")Long userId);
}