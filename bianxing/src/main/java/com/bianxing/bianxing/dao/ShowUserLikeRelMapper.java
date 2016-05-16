package com.bianxing.bianxing.dao;

import org.apache.ibatis.annotations.Param;

import com.bianxing.bianxing.model.ShowUserLikeRel;

public interface ShowUserLikeRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShowUserLikeRel record);

    int insertSelective(ShowUserLikeRel record);

    ShowUserLikeRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShowUserLikeRel record);

    int updateByPrimaryKey(ShowUserLikeRel record);

	int delete(@Param("userId")Long userId, @Param("showId")Long showId);

	ShowUserLikeRel select(ShowUserLikeRel record);
}