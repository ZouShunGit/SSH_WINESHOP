package com.studio.admin.service;

import java.util.List;
/**
 * ����Ա��Service�ӿ�
 */
import com.studio.admin.entity.Admin;

public interface AdminService {
	//����Ա��¼
	public Admin login(Admin admin);
	//����Ա��ѯ
	public List<Admin> findAll(Admin admin);
	//��ӹ���Ա
	public void add(Admin admin);
	//����Աɾ��
	public void delete(Admin admin);
	//�����޸�
	public void editPass(Admin admin);
	//����Ա��Ϣ�޸�
	public void edit(Admin admin);

}
