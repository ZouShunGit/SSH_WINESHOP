package com.studio.admin.dao;

import java.util.List;

import com.studio.admin.entity.Admin;

public interface AdminDao {
	//��¼
	public Admin login(Admin admin);
	//��ѯ����Ա��¼
	public List<Admin> findAll(Admin admin);
	//���
	public void add(Admin admin);
	//�޸�ɾ�����
	public void update(Admin admin);

}
