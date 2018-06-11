package com.studio.user.service;

import java.util.List;

import com.studio.user.entity.User;

public interface UserService {
	//�û���¼
	public User login(User user);
	//�û�ע��
	public void regist(User user);
	//ͨ�������룬�����û�
	public User findByCode(User user);
	//�����û���Ϣ
	public void update(User existUser);
	//ͨ�����䷢���û�
	public User findByEmail(User user);
	//�һ�����
	public void findPass(User user);
	//�޸�����
	public void editPass(User user);
	//��ѯ���е��û�
	public List<User> findAll(User user);
	
}
