package com.studio.user.servioe.impl;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import com.studio.user.dao.UserDao;
import com.studio.user.entity.User;
import com.studio.user.service.UserService;
import com.studio.util.MailUitls;
import com.studio.util.UUIDUtils;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 登录
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	/**
	 * 注册
	 */
	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		user.setUcreattime(new Date());
		user.setCode(UUIDUtils.getUUID());//建立注册码
		userDao.regist(user);
		try {
			MailUitls.sendMail(user.getUemail(), user.getCode());//发送邮箱激活
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过激活代码发现用户
	 */
	@Override
	public User findByCode(User user) {
		// TODO Auto-generated method stub
		return userDao.findByCode(user);
	}


	@Override
	public void update(User existUser) {
		// TODO Auto-generated method stub
		userDao.update(existUser);
	}

	/**
	 * 通过邮箱发现用户
	 */
	@Override
	public User findByEmail(User user) {
		// TODO Auto-generated method stub
		User existUser = userDao.findByEmail(user);
		existUser.setPassword(null);
		return existUser;
	}

	/**
	 * 密码找回
	 */
	@Override
	public void findPass(User user) {
		// TODO Auto-generated method stub
		try {
			MailUitls.sendPassByMail(user.getUemail(), userDao.findByEmail(user).getPassword());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改密码
	 */
	@Override
	public void editPass(User user) {
		// TODO Auto-generated method stub
		userDao.editPass(user);
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> findAll(User user) {
		// TODO Auto-generated method stub
		return userDao.findAllUser(user);
	}
	

}
