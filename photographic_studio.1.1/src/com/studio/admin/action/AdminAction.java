package com.studio.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.admin.entity.Admin;
import com.studio.admin.service.AdminService;

/**
 * 管理员行为类
 * 
 * @author zoushun
 *
 */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Admin admin = new Admin();

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}

	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	/**
	 * 管理员登录
	 * 
	 * @return
	 */
	public String login() {
		Admin existAdmin = adminService.login(admin);
		if (existAdmin != null) {
			ServletActionContext.getRequest().getSession().setAttribute("existAdmin", existAdmin);
			return "index";
		} else {
			this.addActionError("邮箱或密码输入错误");
			return "login";
		}
	}

	/**
	 * 查询所有的管理员
	 * 
	 * @return
	 */
	public String findAll() {
		// 分页设置
		List<Admin> listset = adminService.findAll(admin);

		admin.getPageBean().setListnum(listset.size());
		admin.getPageBean().setRows(8);
		admin.getPageBean().setTotalPage((admin.getPageBean().getListnum() + admin.getPageBean().getRows() - 1)
				/ admin.getPageBean().getRows());
		admin.getPageBean().setStartnum((admin.getPageBean().getPage() - 1) * admin.getPageBean().getRows());
		admin.getPageBean().setEndnum(admin.getPageBean().getStartnum() + admin.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", admin);
System.out.println(admin);
		List<Admin> list = adminService.findAll(admin);
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
	 * 查询邮箱是否已被使用
	 * 
	 * @return
	 * @throws IOException
	 */
	public void findByAemail() throws IOException {
		List<Admin> admins = adminService.findAll(admin);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断 
		if (admins.size() != 0) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("0");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("1");
		}
	}

	/**
	 * 管理员添加
	 * 
	 * @return
	 */
	public String add() {
		adminService.add(admin);
		return "find";
	}

	/**
	 * 管理员信息修改页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<Admin> list = adminService.findAll(admin);
		ActionContext.getContext().getValueStack().set("list", list);
		return "editPage";
	}
	/**
	 * 管理员信息修改页面跳
	 * 
	 * @return
	 */
	public String edit() {
		adminService.edit(admin);
		return "find";
	}
	
	/**
	 * 密码修改页面跳转
	 * 
	 * @return
	 */
	public String editPassPage() {
		return "editPassPage";
	}

	/**
	 * 确认原密码
	 * 
	 * @return
	 */
	public String oldPass() {
		Admin existAdmin = adminService.login(admin);
		if (existAdmin == null) {
			this.addActionError("原始密码输入错误");
			return "editPage";
		} else
			return "newPass";
	}

	/**
	 * 更新密码
	 * 
	 * @return
	 */
	public String editPass() {
		adminService.editPass(admin);
		ServletActionContext.getRequest().getSession().setAttribute("existUser", null);
		this.addActionMessage("密码修改成功，请重新登录！");
		return "login";

	}

	/**
	 * 删除管理员
	 * 
	 * @return
	 */
	public String delete() {
		adminService.delete(admin);
		return "find";
	}

	/**
	 * 注销登录
	 * 
	 * @return
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().setAttribute("existAdmin", null);
		return "login";
	}

}
