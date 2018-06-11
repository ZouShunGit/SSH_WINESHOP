package com.studio.sample.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.sample.entity.SampleCategory;
import com.studio.sample.service.SampleCategoryService;

/**
 * 样品级别的Action类
 * 
 * @author zoushun
 *
 */
public class SampleCategoryAction extends ActionSupport implements ModelDriven<SampleCategory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SampleCategory getModel() {
		// TODO Auto-generated method stub
		return sampleCategory;
	}

	/**
	 * @return the sampleCategoryService
	 */
	public SampleCategoryService getSampleCategoryService() {
		return sampleCategoryService;
	}

	/**
	 * @param sampleCategoryService
	 *            the sampleCategoryService to set
	 */
	public void setSampleCategoryService(SampleCategoryService sampleCategoryService) {
		this.sampleCategoryService = sampleCategoryService;
	}

	private SampleCategory sampleCategory = new SampleCategory();
	private SampleCategoryService sampleCategoryService;

	/**
	 * 查询满足条件的信息
	 * 
	 * @return
	 */
	public String findAll() {
		// 分页设置
		List<SampleCategory> listset = sampleCategoryService.findAll(sampleCategory);
		sampleCategory.getPageBean().setListnum(listset.size());
		sampleCategory.getPageBean().setRows(3);
		sampleCategory.getPageBean()
				.setTotalPage((sampleCategory.getPageBean().getListnum() + sampleCategory.getPageBean().getRows() - 1)
						/ sampleCategory.getPageBean().getRows());
		sampleCategory.getPageBean()
				.setStartnum((sampleCategory.getPageBean().getPage() - 1) * sampleCategory.getPageBean().getRows());
		sampleCategory.getPageBean()
				.setEndnum(sampleCategory.getPageBean().getStartnum() + sampleCategory.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", sampleCategory);

		List<SampleCategory> list = sampleCategoryService.findAll(sampleCategory);
		if (list.isEmpty()) {
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";
	}

	/**
	 * 添加页面跳转
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";
	}

	/**
	 * 判断级别的名称是否已存在
	 * 
	 * @throws IOException
	 */
	public void findByscname() throws IOException {
		List<SampleCategory> categories = sampleCategoryService.findAll(sampleCategory);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (categories.size() != 0) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("0");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("1");
		}
	}

	/**
	 * 添加级别信息
	 * 
	 * @return
	 */
	public String add() {
		sampleCategoryService.add(sampleCategory);
		return "find";
	}

	/**
	 * 信息编辑页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		System.err.println(sampleCategory);
		List<SampleCategory> categories = sampleCategoryService.findAll(sampleCategory);
		for (SampleCategory sampleCategory1 : categories) {
			sampleCategory = sampleCategory1;
		}
		return "editPage";
	}

	/**
	 * 编辑信息
	 * 
	 * @return
	 */
	public String edit() {
		sampleCategoryService.edit(sampleCategory);
		return "find";
	}

	/**
	 * 删除级别信息
	 * 
	 * @return
	 */
	public String delete() {
		sampleCategoryService.delete(sampleCategory);
		return "find";

	}
}
