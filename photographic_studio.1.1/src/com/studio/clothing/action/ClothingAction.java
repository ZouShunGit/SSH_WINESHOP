package com.studio.clothing.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.clothing.entity.Category;
import com.studio.clothing.entity.Clothing;
import com.studio.clothing.entity.SecondCategory;
import com.studio.clothing.service.ClothingService;
import com.studio.clothing.service.SecondCategoryService;

/**
 * 服装的Action
 * 
 * @author zoushun
 *
 */
public class ClothingAction extends ActionSupport implements ModelDriven<Clothing> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Clothing clothing = new Clothing();

	@Override
	public Clothing getModel() {
		// TODO Auto-generated method stub
		return clothing;
	}

	public ClothingService getClothingService() {
		return clothingService;
	}

	public void setClothingService(ClothingService clothingService) {
		this.clothingService = clothingService;
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

	private ClothingService clothingService;
	private SecondCategoryService scategoryService;
	private SecondCategory sCategory = new SecondCategory();

	/**
	 * 图片上传的属性
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * 查询服装信息
	 * 
	 * @return
	 */
	public String findAll() {
		List<SecondCategory> categories = scategoryService.findAll(sCategory);
		ActionContext.getContext().getValueStack().set("categories", categories);
		if (sCategory.getCategory() == null) {
			sCategory.setCategory(new Category());
		}
		// 分页设置
		List<Clothing> listset = clothingService.findAll(clothing);

		clothing.getPageBean().setListnum(listset.size());
		clothing.getPageBean().setRows(4);
		clothing.getPageBean().setTotalPage((clothing.getPageBean().getListnum() + clothing.getPageBean().getRows() - 1)
				/ clothing.getPageBean().getRows());
		clothing.getPageBean().setStartnum((clothing.getPageBean().getPage() - 1) * clothing.getPageBean().getRows());
		clothing.getPageBean().setEndnum(clothing.getPageBean().getStartnum() + clothing.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", clothing);

		List<Clothing> list = clothingService.findAll(clothing);
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
		List<SecondCategory> list = scategoryService.findAll(sCategory);
		ActionContext.getContext().getValueStack().set("list", list);
		return "addPage";
	}

	/**
	 * 添加服装信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		if (upload != null) {
			// 将图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/clothings");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			clothing.setCimg("clothings/" + uploadFileName);
		} else {
			clothing.setCimg(null);
		}
		clothingService.add(clothing);
		return "add";
	}

	/**
	 * 信息编辑页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<Clothing> list = clothingService.findAll(clothing);
		ActionContext.getContext().getValueStack().set("list", list);

		List<SecondCategory> sCategories = scategoryService.findAll(sCategory);
		ActionContext.getContext().getValueStack().set("sCategories", sCategories);
		return "editPage";
	}

	/**
	 * 修改服装信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		System.out.println(clothing);
		if (upload != null) {
			// 将图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/clothings");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			clothing.setCimg("clothings/" + uploadFileName);
		}
		clothingService.edit(clothing);
		return "add";
	}

	/**
	 * 服装信息删除
	 * 
	 * @return
	 */
	public String delete() {
		clothingService.delete(clothing);
		return "add";

	}

	/**
	 * 服装信息展示
	 * 
	 * @return
	 */
	public String item() {
		// 分页设置
		List<Clothing> listset = clothingService.findAll(clothing);

		clothing.getPageBean().setListnum(listset.size());
		clothing.getPageBean().setRows(12);
		clothing.getPageBean().setTotalPage((clothing.getPageBean().getListnum() + clothing.getPageBean().getRows() - 1)
				/ clothing.getPageBean().getRows());
		clothing.getPageBean().setStartnum((clothing.getPageBean().getPage() - 1) * clothing.getPageBean().getRows());
		clothing.getPageBean().setEndnum(clothing.getPageBean().getStartnum() + clothing.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", clothing);

		List<Clothing> list = clothingService.findAll(clothing);
		if (list.isEmpty()) {
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "item";
	}
}
