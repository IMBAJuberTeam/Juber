package com.juber.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class PageBean {
	private int currentPage;   //当前页数
	private int maxResult = 10;  //每页显示数量
	private int dataCount;    //总数据条数
	private int totalPages;   //总页数
	private String[] conditions = new String[]{};    //查询条件
	private List<?> list;    //结果集
	
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
	
	public PageBean(int currentPage, int maxResult, int dataCount) {
		super();
		this.currentPage = currentPage;
		if(maxResult == 0){
			this.maxResult = maxResult;
		}
		this.dataCount = dataCount;
	}
	
	public PageBean(String currentPage, String dataCount, String maxResult, String...conditions){
    	if(currentPage == null || currentPage.equals("") || 
    			!StringUtils.isNumeric(currentPage) || Integer.parseInt(currentPage) < 1){
    		setCurrentPage(1);
    	}else{
    		setCurrentPage(Integer.parseInt(currentPage));
    	}
    	if(maxResult== null || maxResult.equals("") || 
    			!StringUtils.isNumeric(maxResult) || Integer.parseInt(maxResult) < 1){
    	}else{
    		setMaxResult(Integer.parseInt(maxResult));
    	}
    	if(dataCount== null || dataCount.equals("") || 
    			!StringUtils.isNumeric(dataCount) || Integer.parseInt(currentPage) < 1){
    		setDataCount(0);
    	}else{
    		setDataCount(Integer.parseInt(dataCount));
    	}
    	setConditions(conditions);
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		//对页码进行过滤
		if(currentPage <= 0){
			currentPage = 1;
		}
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
		this.totalPages = dataCount/maxResult + (dataCount%maxResult == 0?0:1);
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

}
