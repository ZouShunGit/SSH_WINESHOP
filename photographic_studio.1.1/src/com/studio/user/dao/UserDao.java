package com.studio.user.dao;

import java.util.List;

import com.studio.user.entity.User;

public interface UserDao {

	//�û�ע��
	public void regist(User user);
	// �û���½
	public User login(User user);
	//ͨ���������ѯ�û�
	public User findByCode(User user);
	//�޸��û���Ϣ
	public void update(User existUser);
	//ͨ�����䷢���û�
	public User findByEmail(User user);
	//�����޸�
	public void editPass(User user);
	//��ѯ���е��û���Ϣ
	public List<User> findAllUser(User user);


}
