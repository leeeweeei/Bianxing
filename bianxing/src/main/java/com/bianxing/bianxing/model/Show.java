package com.bianxing.bianxing.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.bianxing.bianxing.common.constant.CommonConstant;

public class Show {
    private Long id;

    private Long userId;

    private String description;

    private Long createTime = System.currentTimeMillis();

    private Integer likeCount = 0;

    private Integer deleteStatus = 1;
    
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
        this.description = description == null ? null : description.trim();
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

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    
    public String getImgUrl() {
    	if(StringUtils.isNotBlank(imgUrl)){
    		return CommonConstant.RESOURCE_SERVER + imgUrl;
    	}
		return "";
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}