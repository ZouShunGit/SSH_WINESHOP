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
 * ��װһ���������Ϊ����
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
	 * ��ѯһ��������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {

		// ��ҳ����
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
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";

	}

	/**
	 * ���ҳ����ת
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";

	}

	/**
	 * �жϼ���������Ƿ��Ѵ���
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		List<Category> categories = categoryService.findAll(category);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (categories.size() != 0) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("0");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("1");
		}
	}

	/**
	 * �������
	 * 
	 * @return
	 */
	public String add() {
		categoryService.add(category);
		return "add";
	}

	/**
	 * �༭ҳ����ת
	 * 
	 * @return
	 */
	public String editPage() {
		List<Category> list = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("list", list);

		return "editPage";
	}

	/**
	 * �༭��Ϣ
	 * 
	 * @return
	 */
	public String edit() {
		categoryService.edit(category);
		return "add";
	}

	/**
	 * ɾ����Ϣ
	 * 
	 * @return
	 */
	public String delete() {
		categoryService.delete(category);
		return "add";

	}

}
