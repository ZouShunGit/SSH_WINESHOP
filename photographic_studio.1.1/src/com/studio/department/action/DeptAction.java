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
 * ���ŵ���Ϊ��
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
	 * ��ҳ��ѯ������������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {
		// ��ҳ����
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
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";
	}

	/**
	 * ���ҳ�����ת
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";
	}

	/**
	 * �жϲ��ŵ������Ƿ��Ѵ���
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		List<Department> categories = deptService.findAll(dept);
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
	 * ������Ϣ���
	 * 
	 * @return
	 */
	public String add() {
		deptService.add(dept);
		return "find";
	}

	/**
	 * ������Ϣ�༭ҳ����ת
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
	 * �༭������Ϣ
	 * 
	 * @return
	 */
	public String edit() {
		deptService.edit(dept);
		return "find";
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @return
	 */
	public String delete() {
		deptService.delete(dept);
		return "find";

	}

}
