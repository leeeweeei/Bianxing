package com.bianxing.bianxing.controller.client.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.bianxing.bianxing.common.constant.CommonConstant;
import com.bianxing.bianxing.model.User;

public class UserDto {
	private Long userId;

	private String platformId;// 第三方平台ID
	
	private String mobile;//手机号

	private String avatar;// 头像

	private String intro;// 简介

	private String nickname;// 昵称

	private Integer gender;// 性别 1男 2女

	private String address;// 地址

	private Float height;// 身高

	private Float weight;// 体重

	private Integer age;// 年龄

	private Float rateFat;// 脂肪率

	private String goal;// 健身目标
	
	public static UserDto toDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setPlatformId(user.getPlatformId());
		userDto.setMobile(user.getMobile());
		if(user.getAvatar() != null)
			userDto.setAvatar(CommonConstant.RESOURCE_SERVER + user.getAvatar());
		userDto.setIntro(user.getIntro());
		userDto.setNickname(user.getNickname());
		userDto.setGender(user.getGender());
		userDto.setAddress(user.getAddress());
		userDto.setHeight(user.getHeight());
		userDto.setWeight(user.getWeight());
		userDto.setAge(user.getAge());
		userDto.setRateFat(user.getRateFat());
		userDto.setGoal(user.getGoal());
		return userDto;
	}
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getRateFat() {
		return rateFat;
	}

	public void setRateFat(Float rateFat) {
		this.rateFat = rateFat;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
