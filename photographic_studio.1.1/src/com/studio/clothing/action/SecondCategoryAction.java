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
 * ��װ����������Ϊ����
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
	 * ��ѯ���еĶ���������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {
		List<Category> categories = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		if (scategory.getCategory() == null) {
			scategory.setCategory(new Category());
		}
		// ��ҳ����
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
		List<Category> list = categoryService.findAll(category);
		ActionContext.getContext().getValueStack().set("list", list);
		return "addPage";
	}

	/**
	 * �жϼ���������Ƿ��Ѵ���
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		System.out.println(scategory);
		List<SecondCategory> categories = scategoryService.findAll(scategory);
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
	 * ����������Ϣ���
	 * 
	 * @return
	 */
	public String add() {
		System.out.println(scategory);
		scategoryService.add(scategory);

		return "add";
	}

	/**
	 * ��������༭ҳ����ת
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
	 * ����������Ϣ�༭
	 * 
	 * @return
	 */
	public String edit() {
		scategoryService.edit(scategory);
		return "add";
	}

	/**
	 * ɾ�����������Ϣ
	 * 
	 * @return
	 */
	public String delete() {
		scategoryService.delete(scategory);
		return "add";
	}
}
