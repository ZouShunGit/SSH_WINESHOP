package com.studio.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.user.entity.User;
import com.studio.user.service.UserService;

/**
 * �û���Ϊ����
 * 
 * @author zoushun
 *
 */

public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * ��¼ 
	 */
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("�û������������");
			return "login";
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "index";
		}
	}

	/**
	 * �ж������Ƿ�ע��
	 * 
	 * @throws IOException
	 */
	public void findByEmail() throws IOException {
		// ����Service���в�ѯ:
		User existUser = userService.findByEmail(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (existUser != null) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("1");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("0");
		}
	}

	/**
	 * ע��
	 * 
	 * @return
	 */
	public String regist() {
		userService.regist(user);
		this.addActionMessage("ע��ɹ����뵽������м��");
		return "msg";
	}

	/**
	 * ���伤��
	 * 
	 * @return
	 */
	public String active() {
		// ���ݼ������ѯ�û�:
		User existUser = userService.findByCode(user);
		// �ж�
		if (existUser == null) {
			// ����������

			this.addActionMessage("����ʧ��:���������!");
		} else {
			// ����ɹ�
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("����ɹ�:��ȥ��¼!");
		}
		return "msg";
	}

	/**
	 * �һ�����
	 * 
	 * @return
	 */
	public String findPass() {
		userService.findPass(user);
		this.addActionMessage("�����ѷ��͵���������,�뵽����鿴��");
		return "msg";

	}

	/**
	 * �û���Ϣ�༭ҳ����ת
	 * 
	 * @return
	 */
	public String editInfoPage() {
		user = userService.findByEmail((User) ServletActionContext.getRequest().getSession().getAttribute("existUser"));
		return "editInfo";

	}

	/**
	 * ��Ϣ�޸�
	 * 
	 * @return
	 */
	public String editInfo() {
		userService.update(user);
		return "userlogin";
	}

	/**
	 * ��ѯ������Ϣ
	 * 
	 * @return
	 */
	public String findUserInfo() {
		user = userService.findByEmail((User) ServletActionContext.getRequest().getSession().getAttribute("existUser"));
		return "userlogin";
	}

	/**
	 * ȷ��ԭʼ����
	 * 
	 * @return
	 */
	public String oldPass() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("��������������������룡");
			return "oldPassPage";
		} else {
			return "newPassPage";
		}
	}

	/**
	 * �����޸�
	 * 
	 * @return
	 */
	public String editPass() {
		userService.editPass(user);
		ServletActionContext.getRequest().getSession().setAttribute("existUser", null);
		this.addActionMessage("�����޸ĳɹ��������µ�¼��");
		return "userloginPage";
	}
	
	public String findAllUser() {
		// ��ҳ���� 
	
		List<User> listset = userService.findAll(user);
		user.getPageBean().setListnum(listset.size());
		user.getPageBean().setRows(4);
		user.getPageBean().setTotalPage((user.getPageBean().getListnum() + user.getPageBean().getRows() - 1)
				/ user.getPageBean().getRows());
		user.getPageBean().setStartnum((user.getPageBean().getPage() - 1) * user.getPageBean().getRows());
		user.getPageBean().setEndnum(user.getPageBean().getStartnum() + user.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", user);

		List<User> users = userService.findAll(user);
		if (users.isEmpty()) {
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("users", users);
		}
		return "findAllUser";
	}
	
	
	
	/**
	 * �˳���¼
	 * 
	 * @return
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().setAttribute("existUser", null);
		return "index";
	}
}
