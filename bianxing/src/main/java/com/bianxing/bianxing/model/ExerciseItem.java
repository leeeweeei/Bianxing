package com.bianxing.bianxing.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.bianxing.bianxing.common.util.TimeUtil;

public class ExerciseItem {
    private Long id;

    private Long exerciseId;

    private Long userId;

    private Float weight;

    private Integer count;

    private Integer hard;

    private Double distance;

    private Integer during;

    private Integer deleteStatus = 1;

    private Long lastModifyTime = TimeUtil.getCurrentSecond();
    
    private String source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getHard() {
        return hard;
    }

    public void setHard(Integer hard) {
        this.hard = hard;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getDuring() {
        return during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
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