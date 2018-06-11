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
 * ����Ա��Ϊ��
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
	 * ����Ա��¼
	 * 
	 * @return
	 */
	public String login() {
		Admin existAdmin = adminService.login(admin);
		if (existAdmin != null) {
			ServletActionContext.getRequest().getSession().setAttribute("existAdmin", existAdmin);
			return "index";
		} else {
			this.addActionError("����������������");
			return "login";
		}
	}

	/**
	 * ��ѯ���еĹ���Ա
	 * 
	 * @return
	 */
	public String findAll() {
		// ��ҳ����
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
	 * ��ѯ�����Ƿ��ѱ�ʹ��
	 * 
	 * @return
	 * @throws IOException
	 */
	public void findByAemail() throws IOException {
		List<Admin> admins = adminService.findAll(admin);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж� 
		if (admins.size() != 0) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("0");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("1");
		}
	}

	/**
	 * ����Ա���
	 * 
	 * @return
	 */
	public String add() {
		adminService.add(admin);
		return "find";
	}

	/**
	 * ����Ա��Ϣ�޸�ҳ����ת
	 * 
	 * @return
	 */
	public String editPage() {
		List<Admin> list = adminService.findAll(admin);
		ActionContext.getContext().getValueStack().set("list", list);
		return "editPage";
	}
	/**
	 * ����Ա��Ϣ�޸�ҳ����
	 * 
	 * @return
	 */
	public String edit() {
		adminService.edit(admin);
		return "find";
	}
	
	/**
	 * �����޸�ҳ����ת
	 * 
	 * @return
	 */
	public String editPassPage() {
		return "editPassPage";
	}

	/**
	 * ȷ��ԭ����
	 * 
	 * @return
	 */
	public String oldPass() {
		Admin existAdmin = adminService.login(admin);
		if (existAdmin == null) {
			this.addActionError("ԭʼ�����������");
			return "editPage";
		} else
			return "newPass";
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public String editPass() {
		adminService.editPass(admin);
		ServletActionContext.getRequest().getSession().setAttribute("existUser", null);
		this.addActionMessage("�����޸ĳɹ��������µ�¼��");
		return "login";

	}

	/**
	 * ɾ������Ա
	 * 
	 * @return
	 */
	public String delete() {
		adminService.delete(admin);
		return "find";
	}

	/**
	 * ע����¼
	 * 
	 * @return
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().setAttribute("existAdmin", null);
		return "login";
	}

}
