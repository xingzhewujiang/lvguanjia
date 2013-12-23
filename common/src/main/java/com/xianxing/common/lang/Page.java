package com.xianxing.common.lang;

import java.util.List;

/**
 * 分页对像含数据
 * @author hua 
 */
public class Page extends Paginator {	
	
	public Page() {
		super();
	}

	public Page(int itemsPerPage, int items) {
		super(itemsPerPage, items);
		// TODO Auto-generated constructor stub
	}

	public Page(int itemsPerPage) {
		super(itemsPerPage);
		// TODO Auto-generated constructor stub
	}

	private List dataList; //分页数据列表

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}	
}
