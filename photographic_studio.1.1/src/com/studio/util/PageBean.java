package com.studio.util;

/**
 * ��ҳ��Ƶ�ʵ����
 * 
 * @author zoushun
 *
 */

public class PageBean {
	private int page;// ��ǰҳ��
	private int rows;// ÿҳ��ʾ����Ŀ
	private int listnum;// ��������������
	private int totalPage;// ��ҳ��
	private int startnum;// ҳ����ʼ��
	private int endnum;// ҳ�����ҳ

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
