package com.bianxing.bianxing.common.util;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PagingResults<T> {

	/**
	 * 总数
	 */
	private Long total = 0L;

	/**
	 * 查询结果
	 */
	private List<T> rows;


	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
