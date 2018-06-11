package com.studio.department.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.department.entity.Department;

import com.studio.department.service.deptService;

/**
 * 部门的行为类
 * 
 * @author zoushun
 *
 */
public class DeptAction extends ActionSupport implements ModelDriven<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Department dept = new Department();

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return dept;
	}

	private deptService deptService;

	public deptService getDeptService() {
		return deptService;
	}

	public void setDeptService(deptService deptService) {
		this.deptService = deptService;
	}

	/**
	 * 分页查询符合条件的信息
	 * 
	 * @return
	 */
	public String findAll() {
		// 分页设置
		List<Department> listset = deptService.findAll(dept);

		dept.getPageBean().setListnum(listset.size());
		dept.getPageBean().setRows(5);
		dept.getPageBean().setTotalPage(
				(dept.getPageBean().getListnum() + dept.getPageBean().getRows() - 1) / dept.getPageBean().getRows());
		dept.getPageBean().setStartnum((dept.getPageBean().getPage() - 1) * dept.getPageBean().getRows());
		dept.getPageBean().setEndnum(dept.getPageBean().getStartnum() + dept.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", dept);

		List<Department> list = deptService.findAll(dept);
		if (list.isEmpty()) {
			this.addActionMessage("没有符合条件的信息！");
		} else {
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
	 * 判断部门的名称是否已存在
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		List<Department> categories = deptService.findAll(dept);
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
	 * 部门信息添加
	 * 
	 * @return
	 */
	public String add() {
		deptService.add(dept);
		return "find";
	}

	/**
	 * 部门信息编辑页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<Department> list = deptService.findAll(dept);
		for (Department department : list) {
			System.out.println(department);
		}
		ServletActionContext.getRequest().getSession().setAttribute("list", list);
		return "editPage";
	}

	/**
	 * 编辑部门信息
	 * 
	 * @return
	 */
	public String edit() {
		deptService.edit(dept);
		return "find";
	}

	/**
	 * 删除部门信息
	 * 
	 * @return
	 */
	public String delete() {
		deptService.delete(dept);
		return "find";

	}

}
