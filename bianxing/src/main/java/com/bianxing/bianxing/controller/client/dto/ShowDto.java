package com.bianxing.bianxing.controller.client.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.bianxing.bianxing.common.constant.CommonConstant;

public class ShowDto {
	private Long id;

	private Long userId;

	private String description;

	private Long createTime = System.currentTimeMillis();

	private Integer likeCount = 0;

	private String nickname;

	private String avatar;

	private String intro;// 简介

	private String address;// 地址

	private Integer gender;// 性别 1男 2女

	private Integer age;// 年龄

	private Integer isLike;

	private String imgUrl;

	private Integer width = 2656;

	private Integer height = 1494;

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		if (avatar != null) {
			this.avatar = CommonConstant.RESOURCE_SERVER + avatar;
		}
	}

	public Integer getIsLike() {
		return isLike;
	}

	public void setIsLike(Integer isLike) {
		this.isLike = isLike;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		if (imgUrl != null) {
			this.imgUrl = CommonConstant.RESOURCE_SERVER + imgUrl;
		}
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
