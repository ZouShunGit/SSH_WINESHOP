package com.studio.employeelevel.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.employeelevel.entity.EmployeeLevel;
import com.studio.employeelevel.service.EmpLevelService;

public class EmpLevelAction extends ActionSupport implements ModelDriven<EmployeeLevel> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeLevel empl = new EmployeeLevel();

	@Override
	public EmployeeLevel getModel() {
		// TODO Auto-generated method stub
		return empl;
	}

	private EmpLevelService empLevelService;

	public EmpLevelService getEmpLevelService() {
		return empLevelService;
	}

	public void setEmpLevelService(EmpLevelService empLevelService) {
		this.empLevelService = empLevelService;
	}

	/**
	 * 分页查询符合条件的信息
	 * 
	 * @return
	 */
	public String findAll() {
		// 分页设置
		List<EmployeeLevel> listset = empLevelService.findAll(empl);

		empl.getPageBean().setListnum(listset.size());
		empl.getPageBean().setRows(5);
		empl.getPageBean().setTotalPage(
				(empl.getPageBean().getListnum() + empl.getPageBean().getRows() - 1) / empl.getPageBean().getRows());
		empl.getPageBean().setStartnum((empl.getPageBean().getPage() - 1) * empl.getPageBean().getRows());
		empl.getPageBean().setEndnum(empl.getPageBean().getStartnum() + empl.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", empl);

		List<EmployeeLevel> list = empLevelService.findAll(empl);
		if (list.isEmpty()) {
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";

	}

	/**
	 * 员工级别信息添加页面跳转
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
		List<EmployeeLevel> categories = empLevelService.findAll(empl);
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
	 * 员工级别信息添加
	 * 
	 * @return
	 */
	public String add() {
		empLevelService.add(empl);
		return "find";
	}

	/**
	 * 员工级别信息编辑页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<EmployeeLevel> list = empLevelService.findAll(empl);
		ServletActionContext.getRequest().getSession().setAttribute("list", list);
		return "editPage";
	}

	/**
	 * 编辑员工级别信息
	 * 
	 * @return
	 */
	public String edit() {
		empLevelService.edit(empl);
		return "find";
	}

	/**
	 * 删除员工级别信息
	 * 
	 * @return
	 */
	public String delete() {
		empLevelService.delete(empl);
		return "find";

	}
}
