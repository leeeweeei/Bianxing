package com.bianxing.bianxing.dao;

import com.bianxing.bianxing.model.ShowPhotoRel;

public interface ShowPhotoRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShowPhotoRel record);

    int insertSelective(ShowPhotoRel record);

    ShowPhotoRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShowPhotoRel record);

    int updateByPrimaryKey(ShowPhotoRel record);
}