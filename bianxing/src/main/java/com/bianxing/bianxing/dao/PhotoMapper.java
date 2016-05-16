package com.bianxing.bianxing.dao;

import com.bianxing.bianxing.model.Photo;

public interface PhotoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Photo record);

    int insertSelective(Photo record);

    Photo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}