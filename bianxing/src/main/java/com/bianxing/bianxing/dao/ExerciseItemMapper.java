package com.bianxing.bianxing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.model.ExerciseItem;

public interface ExerciseItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExerciseItem record);

    int insertSelective(ExerciseItem record);

    ExerciseItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExerciseItem record);

    int updateByPrimaryKey(ExerciseItem record);
    
    List<ExerciseItem> selectFromLastSyncTime(@Param("paging")PagingParams paging, @Param("lastSyncTime")Long lastSyncTime, @Param("userId")Long userId);

   	Long selectTotalFromLastSyncTime(@Param("lastSyncTime")Long lastSyncTime, @Param("userId")Long userId);

}