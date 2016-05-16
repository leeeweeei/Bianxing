package com.bianxing.bianxing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bianxing.bianxing.common.util.PagingParams;
import com.bianxing.bianxing.controller.client.dto.ShowDto;
import com.bianxing.bianxing.model.Show;

public interface ShowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Show record);

    int insertSelective(Show record);

    Show selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Show record);

    int updateByPrimaryKey(Show record);

    /**
     * 更新为删除状态
     */
	void updateStatus2Delete(@Param("id")Long id, @Param("userId")Long userId);


	Long selectTotal(@Param("userId")Long userId);

	void addLikeCount(Long showId);

	void decreaseLikeCount(Long showId);

	List<ShowDto> selectDtoPage(@Param("paging")PagingParams paging, @Param("userId")Long userId,@Param("myUserId")Long myUserId);

}