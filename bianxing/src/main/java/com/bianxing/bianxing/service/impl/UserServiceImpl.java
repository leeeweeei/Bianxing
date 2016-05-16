package com.bianxing.bianxing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bianxing.bianxing.dao.UserMapper;
import com.bianxing.bianxing.model.User;
import com.bianxing.bianxing.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Long save(User user) {
		long currentTimeMillis = System.currentTimeMillis();
		user.setCreateTime(currentTimeMillis);
		user.setLastLoginTime(currentTimeMillis);
		return userMapper.insert(user);
	}

	@Override
	public User findByPlatformId(String platformId) {
		return userMapper.selectByPlatformId(platformId);
	}
	@Override
	public User findByMobile(String mobile) {
		return userMapper.selectByMobile(mobile);
	}

	@Override
	public void update(User user) {
		long currentTimeMillis = System.currentTimeMillis();
		user.setLastLoginTime(currentTimeMillis);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User findById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}


}
