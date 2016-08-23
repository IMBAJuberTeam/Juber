package com.louga.utils;

import java.util.List;

public class PageBean {
	private int currentPage;
	private int maxResult;
	private List<?> list;
	
	public PageBean() {
		
	}
	public PageBean(int currentPage, int maxResult, List<?> list) {
		super();
		this.currentPage = currentPage;
		this.maxResult = maxResult;
		this.list = list;
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
}
