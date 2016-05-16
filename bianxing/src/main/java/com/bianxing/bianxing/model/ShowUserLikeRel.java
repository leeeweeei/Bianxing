package com.bianxing.bianxing.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ShowUserLikeRel {
    private Long id;

    private Long showId;

    private Long userId;

    private Long createTime;

    public ShowUserLikeRel() {
		super();
	}

	public ShowUserLikeRel(Long userId, Long showId) {
    	this.userId = userId;
    	this.showId = showId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}