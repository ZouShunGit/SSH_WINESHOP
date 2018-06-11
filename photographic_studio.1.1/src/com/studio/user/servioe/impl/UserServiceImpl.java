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
	 * ��¼
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	/**
	 * ע��
	 */
	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		user.setUcreattime(new Date());
		user.setCode(UUIDUtils.getUUID());//����ע����
		userDao.regist(user);
		try {
			MailUitls.sendMail(user.getUemail(), user.getCode());//�������伤��
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ͨ��������뷢���û�
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
	 * ͨ�����䷢���û�
	 */
	@Override
	public User findByEmail(User user) {
		// TODO Auto-generated method stub
		User existUser = userDao.findByEmail(user);
		existUser.setPassword(null);
		return existUser;
	}

	/**
	 * �����һ�
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
	 * �޸�����
	 */
	@Override
	public void editPass(User user) {
		// TODO Auto-generated method stub
		userDao.editPass(user);
	}

	/**
	 * ��ѯ�����û�
	 */
	@Override
	public List<User> findAll(User user) {
		// TODO Auto-generated method stub
		return userDao.findAllUser(user);
	}
	

}
