package com.bianxing.bianxing.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.bianxing.bianxing.common.util.TimeUtil;

public class Action {
    private Long id;

    private String name;

    private Integer type = 0;

    private Long userId = -1L;

    private Long lastModifyTime = TimeUtil.getCurrentSecond();

    private Integer deleteStatus = 1;
    
    private String source;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    
    public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}