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
	 * ��ҳ��ѯ������������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {
		// ��ҳ����
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
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";

	}

	/**
	 * Ա��������Ϣ���ҳ����ת
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
		List<EmployeeLevel> categories = empLevelService.findAll(empl);
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
	 * Ա��������Ϣ���
	 * 
	 * @return
	 */
	public String add() {
		empLevelService.add(empl);
		return "find";
	}

	/**
	 * Ա��������Ϣ�༭ҳ����ת
	 * 
	 * @return
	 */
	public String editPage() {
		List<EmployeeLevel> list = empLevelService.findAll(empl);
		ServletActionContext.getRequest().getSession().setAttribute("list", list);
		return "editPage";
	}

	/**
	 * �༭Ա��������Ϣ
	 * 
	 * @return
	 */
	public String edit() {
		empLevelService.edit(empl);
		return "find";
	}

	/**
	 * ɾ��Ա��������Ϣ
	 * 
	 * @return
	 */
	public String delete() {
		empLevelService.delete(empl);
		return "find";

	}
}
