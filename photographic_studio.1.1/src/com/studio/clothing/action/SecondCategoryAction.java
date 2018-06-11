package com.studio.clothing.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.clothing.entity.Category;
import com.studio.clothing.entity.SecondCategory;
import com.studio.clothing.service.CategoryService;

import com.studio.clothing.service.ClothingService;
import com.studio.clothing.service.SecondCategoryService;
/**
 * 服装二级分类行为控制
 * @author zoushun
 *
 */
public class SecondCategoryAction extends ActionSupport implements ModelDriven<SecondCategory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SecondCategory getModel() {
		// TODO Auto-generated method stub
		return scategory;
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

	/**
	 * @return the clothingService
	 */
	public ClothingService getClothingService() {
		return clothingService;
	}

	/**
	 * @param clothingService
	 *            the clothingService to set
	 */
	public void setClothingService(ClothingService clothingService) {
		this.clothingService = clothingService;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private SecondCategory scategory = new SecondCategory();
	private SecondCategoryService scategoryService;
	private CategoryService categoryService;
	private ClothingService clothingService;
	private Category category = new Category();

	/**
	 * 查询所有的二级分类信息
	 * 
	 * @return
	 */
	public String findAll() {
		List<Category> categories = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		if (scategory.getCategory() == null) {
			scategory.setCategory(new Category());
		}
		// 分页设置
		List<SecondCategory> listset = scategoryService.findAll(scategory);

		scategory.getPageBean().setListnum(listset.size());
		scategory.getPageBean().setRows(5);
		scategory.getPageBean()
				.setTotalPage((scategory.getPageBean().getListnum() + scategory.getPageBean().getRows() - 1)
						/ scategory.getPageBean().getRows());
		scategory.getPageBean()
				.setStartnum((scategory.getPageBean().getPage() - 1) * scategory.getPageBean().getRows());
		scategory.getPageBean().setEndnum(scategory.getPageBean().getStartnum() + scategory.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", scategory);

		List<SecondCategory> list = scategoryService.findAll(scategory);
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
		List<Category> list = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("list", list);
		return "addPage";
	}

	/**
	 * 判断级别的名称是否已存在
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		System.out.println(scategory);
		List<SecondCategory> categories = scategoryService.findAll(scategory);
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
	 * 二级分类信息添加
	 * 
	 * @return
	 */
	public String add() {
		System.out.println(scategory);
		scategoryService.add(scategory);

		return "add";
	}

	/**
	 * 二级分类编辑页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<SecondCategory> list = scategoryService.findAll(scategory);
		ActionContext.getContext().getValueStack().set("list", list);

		List<Category> categories = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("categories", categories);
		return "editPage";
	}

	/**
	 * 二级分类信息编辑
	 * 
	 * @return
	 */
	public String edit() {
		scategoryService.edit(scategory);
		return "add";
	}

	/**
	 * 删除二级类别信息
	 * 
	 * @return
	 */
	public String delete() {
		scategoryService.delete(scategory);
		return "add";
	}
}
