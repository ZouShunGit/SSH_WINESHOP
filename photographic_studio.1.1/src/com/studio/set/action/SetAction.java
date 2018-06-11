package com.studio.set.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.set.entity.Set;
import com.studio.set.service.SetService;

public class SetAction extends ActionSupport implements ModelDriven<Set> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set getModel() {
		// TODO Auto-generated method stub
		return set;
	}

	/**
	 * @return the setService
	 */
	public SetService getSetService() {
		return setService;
	}

	/**
	 * @param setService
	 *            the setService to set
	 */
	public void setSetService(SetService setService) {
		this.setService = setService;
	}

	private Set set = new Set();
	private SetService setService;

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
	 * 查询所有符合条件的信息
	 * 
	 * @return
	 */
	public String findAll() {
		// 分页设置
		List<Set> listset = setService.findAll(set);
		set.getPageBean().setListnum(listset.size());
		set.getPageBean().setRows(4);
		set.getPageBean().setTotalPage( 
				(set.getPageBean().getListnum() + set.getPageBean().getRows() - 1) / set.getPageBean().getRows());
		set.getPageBean().setStartnum((set.getPageBean().getPage() - 1) * set.getPageBean().getRows());
		set.getPageBean().setEndnum(set.getPageBean().getStartnum()+ set.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", set);

		List<Set> list = setService.findAll(set);
		if (list.isEmpty()) {
			this.addActionMessage("没有符合条件的信息！");
		}else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";
	}

	/**
	 * 添加页面的跳转
	 * 
	 * @return
	 */
	public String addPage() {

		return "addPage";
	}
	/**
	 * 查询套餐名是否存在
	 * @throws IOException
	 */
	public void findSetname() throws IOException{
		List<Set> sets = setService.findAll(set);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断 
		if (sets.size() != 0) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("0");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("1");
		}
		
	}
	/**
	 * 添加套餐信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sets");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			set.setSetimg("sets/" + uploadFileName);
		} else {
			set.setSetimg(null);
		}
		setService.add(set);
		return "find";
	}

	/**
	 * 编辑页面的跳转
	 * 
	 * @return
	 * 
	 */
	public String editPage() {
		List<Set> list = setService.findAll(set);
		ActionContext.getContext().getValueStack().set("list", list);
		return "editPage";
	}

	/**
	 * 套餐信息修改
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sets");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			set.setSetimg("sets/" + uploadFileName);
		} else {
			set.setSetimg(null);
		}
		setService.edit(set);
		return "find";
	}

	/**
	 * 套餐信息删除
	 * 
	 * @return
	 */
	public String delete() {
		setService.delete(set);
		return "find";

	}

	/**
	 * 前台页面信息展示
	 * 
	 * @return
	 */
	public String index() {
		// 分页设置
		List<Set> listset = setService.findAll(set);
		set.getPageBean().setListnum(listset.size());
		set.getPageBean().setRows(5);
		set.getPageBean().setTotalPage(
				(set.getPageBean().getListnum() + set.getPageBean().getRows() - 1) / set.getPageBean().getRows());
		set.getPageBean().setStartnum((set.getPageBean().getPage() - 1) * set.getPageBean().getRows());
		set.getPageBean().setEndnum(set.getPageBean().getStartnum() + set.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", set);

		List<Set> list = setService.findAll(set);
		if (list.isEmpty()) {
			this.addActionMessage("没有你需要的信息！");
		}else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "index";
	}
}
