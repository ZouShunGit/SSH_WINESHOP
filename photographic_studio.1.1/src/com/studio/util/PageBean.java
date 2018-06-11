package com.studio.util;

/**
 * 分页设计的实体类
 * 
 * @author zoushun
 *
 */

public class PageBean {
	private int page;// 当前页面
	private int rows;// 每页显示的数目
	private int listnum;// 符合条件的总数
	private int totalPage;// 总页数
	private int startnum;// 页面起始数
	private int endnum;// 页面结束页

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getListnum() {
		return listnum;
	}

	public void setListnum(int listnum) {
		this.listnum = listnum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the startnum
	 */
	public int getStartnum() {
		return startnum;
	}

	/**
	 * @param startnum
	 *            the startnum to set
	 */
	public void setStartnum(int startnum) {
		this.startnum = startnum;
	}

	/**
	 * @return the endnum
	 */
	public int getEndnum() {
		return endnum;
	}

	/**
	 * @param endnum
	 *            the endnum to set
	 */
	public void setEndnum(int endnum) {
		this.endnum = endnum;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", listnum=" + listnum + ", totalPage=" + totalPage
				+ ", startnum=" + startnum + ", endnum=" + endnum + "]";
	}

}
