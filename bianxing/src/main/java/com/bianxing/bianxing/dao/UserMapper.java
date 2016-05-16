package com.bianxing.bianxing.dao;

import com.bianxing.bianxing.model.User;

public interface UserMapper {
	Long insert(User user);
	User selectByPlatformId(String platformId);
	User selectByMobile(String mobile);
	
	int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
}
