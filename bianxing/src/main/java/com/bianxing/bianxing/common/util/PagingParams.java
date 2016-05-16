package com.bianxing.bianxing.common.util;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 分页参数
 * @author：BShuai
 * @since：2015-8-24 上午10:10:36
 * @version:
 */
public class PagingParams {
	
	private int start = 0;
	
	private int limit = 30;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
