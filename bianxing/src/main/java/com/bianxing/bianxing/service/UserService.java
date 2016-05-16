package com.bianxing.bianxing.service;

import com.bianxing.bianxing.model.User;

public interface UserService {

	Long save(User user);
	
	User findById(Long id);
	User findByPlatformId(String flatformId) ;
	User findByMobile(String mobile);

	void update(User user);

	
}
