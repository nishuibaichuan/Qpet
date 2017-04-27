package com.qpet.vo;

public class Page<T> {
	private int currentPage = 0;// 当前页码 从0开始算起,默认值是0
	private int pageSize = 5;// 分页的大小 默认值是5
	private long totalRecords = 0;// 数据总数

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

}
