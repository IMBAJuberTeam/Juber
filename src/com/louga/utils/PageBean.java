package com.louga.utils;

import java.util.List;

public class PageBean {
	private int currentPage;
	private int maxResult;
	private int dataCount;
	private int totalPages;
	private String[] conditions = new String[]{};
	private List<?> list;
	
	public PageBean() {
		
	}
	
	public PageBean(int currentPage, int maxResult, int dataCount, int totalPages, String[] conditions, List<?> list) {
		super();
		this.currentPage = currentPage;
		this.maxResult = maxResult;
		this.dataCount = dataCount;
		this.list = list;
		this.conditions = conditions;
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public String[] getConditions() {
		return conditions;
	}

	public void setConditions(String...conditions) {
		this.conditions = conditions;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}
