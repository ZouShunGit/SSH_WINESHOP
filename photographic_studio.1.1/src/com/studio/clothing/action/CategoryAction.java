package com.studio.clothing.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.clothing.entity.Category;
import com.studio.clothing.service.CategoryService;
import com.studio.clothing.service.SecondCategoryService;

/**
 * 服装一级分类的行为控制
 * 
 * @author zoushun
 *
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Category category = new Category();

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}

	/**
	 * @return the categoryService
	 */
	public CategoryService getCategoryService() {
		return categoryService;
	}

	/**
	 * @param categoryService
	 *            the categoryService to set
	 */
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	/**
	 * @return the scategoryService
	 */
	public SecondCategoryService getScategoryService() {
		return scategoryService;
	}

	/**
	 * @param scategoryService
	 *            the scategoryService to set
	 */
	public void setScategoryService(SecondCategoryService scategoryService) {
		this.scategoryService = scategoryService;
	}

	private CategoryService categoryService;
	private SecondCategoryService scategoryService;

	/**
	 * 查询一级分类信息
	 * 
	 * @return
	 */
	public String findAll() {

		// 分页设置
		List<Category> listset = categoryService.findAll(category);

		category.getPageBean().setListnum(listset.size());
		category.getPageBean().setRows(4);
		category.getPageBean().setTotalPage((category.getPageBean().getListnum() + category.getPageBean().getRows() - 1)
				/ category.getPageBean().getRows());
		category.getPageBean().setStartnum((category.getPageBean().getPage() - 1) * category.getPageBean().getRows());
		category.getPageBean().setEndnum(category.getPageBean().getStartnum() + category.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", category);

		List<Category> list = categoryService.findAll(category);
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
	public void findSname() throws IOException {
		List<Category> categories = categoryService.findAll(category);
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
	 * 级别添加
	 * 
	 * @return
	 */
	public String add() {
		categoryService.add(category);
		return "add";
	}

	/**
	 * 编辑页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<Category> list = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("list", list);

		return "editPage";
	}

	/**
	 * 编辑信息
	 * 
	 * @return
	 */
	public String edit() {
		categoryService.edit(category);
		return "add";
	}

	/**
	 * 删除信息
	 * 
	 * @return
	 */
	public String delete() {
		categoryService.delete(category);
		return "add";

	}

}
