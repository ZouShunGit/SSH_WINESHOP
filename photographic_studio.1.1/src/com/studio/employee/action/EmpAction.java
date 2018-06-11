package com.studio.employee.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.department.entity.Department;
import com.studio.department.service.deptService;
import com.studio.employee.entity.Employee;

import com.studio.employee.service.EmpService;
import com.studio.employeelevel.entity.EmployeeLevel;
import com.studio.employeelevel.service.EmpLevelService;

/**
 * 员工行为类
 * 
 * @author zoushun
 *
 */
public class EmpAction extends ActionSupport implements ModelDriven<Employee> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee emp = new Employee();

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return emp;
	}

	private EmpService empService;

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	private EmpLevelService empLevelService;

	public EmpLevelService getEmpLevelService() {
		return empLevelService;
	}

	public void setEmpLevelService(EmpLevelService empLevelService) {
		this.empLevelService = empLevelService;
	}

	private deptService deptService;

	public deptService getDeptService() {
		return deptService;
	}

	public void setDeptService(deptService deptService) {
		this.deptService = deptService;
	}

	Department dept = new Department();
	EmployeeLevel employeeLevel = new EmployeeLevel();

	/**
	 * 查询员工
	 * 
	 * @return
	 */
	public String findAll() {
		if (emp.getDepartment() == null) {
			emp.setDepartment(new Department());
		}
		if (emp.getEmployeeLevel() == null) {
			emp.setEmployeeLevel(new EmployeeLevel());
		}
		// 分页设置
		List<Employee> listset = empService.findAll(emp);

		emp.getPageBean().setListnum(listset.size());
		emp.getPageBean().setRows(4);
		emp.getPageBean().setTotalPage(
				(emp.getPageBean().getListnum() + emp.getPageBean().getRows() - 1) / emp.getPageBean().getRows());
		emp.getPageBean().setStartnum((emp.getPageBean().getPage() - 1) * emp.getPageBean().getRows());
		emp.getPageBean().setEndnum(emp.getPageBean().getStartnum() + emp.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", emp);

		List<Employee> list = empService.findAll(emp);
		if (list.isEmpty()) {
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}

		List<Department> departments = deptService.findAll(emp.getDepartment());
		// System.err.println(departments.size());
		ActionContext.getContext().getValueStack().set("dept", departments);

		List<EmployeeLevel> employeeLevels = empLevelService.findAll(emp.getEmployeeLevel());
		ActionContext.getContext().getValueStack().set("empl", employeeLevels);
		return "findAll";

	}

	/**
	 *  
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

	///////////////////////////////////////////////////////
	/**
	 * 员工信息添加页面跳转
	 * 
	 * @return
	 */
	public String addPage() {

		dept.setDid(0);
		System.out.println(dept);
		List<Department> depts = deptService.findAll(dept);
		ActionContext.getContext().getValueStack().set("depts", depts);

		employeeLevel.setElid(0);
		List<EmployeeLevel> empls = empLevelService.findAll(employeeLevel);
		ActionContext.getContext().getValueStack().set("empls", empls);
		return "addPage";
	}

	/**
	 * 添加员工信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		System.out.println(emp);
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/emps");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			emp.setEimg("emps/" + uploadFileName);
		} else {
			emp.setEimg(null);
		}
		empService.add(emp);
		return "find";
	}

	/**
	 * 修改页面跳转
	 * 
	 * @return
	 */
	public String editPage() {
		List<Department> depts = deptService.findAll(dept);
		ActionContext.getContext().getValueStack().set("depts", depts);

		employeeLevel.setElid(0);
		List<EmployeeLevel> empls = empLevelService.findAll(employeeLevel);
		ActionContext.getContext().getValueStack().set("empls", empls);

		List<Employee> list = empService.findAll(emp);
		ServletActionContext.getRequest().getSession().setAttribute("list", list);
		return "editPage";
	}

	/**
	 * 员工信息修改
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		System.out.println(emp);
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/emps/photographer");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			emp.setEimg("photographer/" + uploadFileName);
			System.out.println(emp.getEimg());
		} else {
			emp.setEimg(null);
		}
		empService.edit(emp);
		System.out.println(emp);
		return "find";
	}

	/**
	 * 删除员工
	 * 
	 * @return
	 */
	public String delete() {
		empService.delete(emp);
		return "find";

	}

	/**
	 * 查询所有的员工
	 */
	public String index() {
		// 分页设置
		List<Employee> employees = empService.findEmp(emp);
		emp.getPageBean().setListnum(employees.size());
		emp.getPageBean().setRows(12);
		emp.getPageBean().setTotalPage(
				(emp.getPageBean().getListnum() + emp.getPageBean().getRows() - 1) / emp.getPageBean().getRows());
		emp.getPageBean().setStartnum((emp.getPageBean().getPage() - 1) * emp.getPageBean().getRows());
		emp.getPageBean().setEndnum(emp.getPageBean().getStartnum() + emp.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", emp);

		List<Employee> list = empService.findAll(emp);

		ActionContext.getContext().getValueStack().set("emp", list);
		return "index";
	}
}
