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
 * 用户行为控制
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
	 * 登录 
	 */
	public String login() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("用户名或密码错误");
			return "login";
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "index";
		}
	}

	/**
	 * 判断邮箱是否被注册
	 * 
	 * @throws IOException
	 */
	public void findByEmail() throws IOException {
		// 调用Service进行查询:
		User existUser = userService.findByEmail(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("1");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("0");
		}
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String regist() {
		userService.regist(user);
		this.addActionMessage("注册成功，请到邮箱进行激活！");
		return "msg";
	}

	/**
	 * 邮箱激活
	 * 
	 * @return
	 */
	public String active() {
		// 根据激活码查询用户:
		User existUser = userService.findByCode(user);
		// 判断
		if (existUser == null) {
			// 激活码错误的

			this.addActionMessage("激活失败:激活码错误!");
		} else {
			// 激活成功
			existUser.setCode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "msg";
	}

	/**
	 * 找回密码
	 * 
	 * @return
	 */
	public String findPass() {
		userService.findPass(user);
		this.addActionMessage("密码已发送到您的邮箱,请到邮箱查看！");
		return "msg";

	}

	/**
	 * 用户信息编辑页面跳转
	 * 
	 * @return
	 */
	public String editInfoPage() {
		user = userService.findByEmail((User) ServletActionContext.getRequest().getSession().getAttribute("existUser"));
		return "editInfo";

	}

	/**
	 * 信息修改
	 * 
	 * @return
	 */
	public String editInfo() {
		userService.update(user);
		return "userlogin";
	}

	/**
	 * 查询个人信息
	 * 
	 * @return
	 */
	public String findUserInfo() {
		user = userService.findByEmail((User) ServletActionContext.getRequest().getSession().getAttribute("existUser"));
		return "userlogin";
	}

	/**
	 * 确认原始密码
	 * 
	 * @return
	 */
	public String oldPass() {
		User existUser = userService.login(user);
		if (existUser == null) {
			this.addActionError("密码输入错误，请重新输入！");
			return "oldPassPage";
		} else {
			return "newPassPage";
		}
	}

	/**
	 * 密码修改
	 * 
	 * @return
	 */
	public String editPass() {
		userService.editPass(user);
		ServletActionContext.getRequest().getSession().setAttribute("existUser", null);
		this.addActionMessage("密码修改成功，请重新登录！");
		return "userloginPage";
	}
	
	public String findAllUser() {
		// 分页设置 
	
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
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("users", users);
		}
		return "findAllUser";
	}
	
	
	
	/**
	 * 退出登录
	 * 
	 * @return
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession().setAttribute("existUser", null);
		return "index";
	}
}
