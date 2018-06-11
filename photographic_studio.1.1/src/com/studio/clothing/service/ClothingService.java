package com.studio.clothing.service;

import java.util.List;

import com.studio.clothing.entity.Clothing;

public interface ClothingService {
	//��ѯ��װ��Ϣ
	public List<Clothing> findAll(Clothing clothing);
	//��ӷ�װ��Ϣ
	public void add(Clothing clothing);
	//�޸ķ�װ��Ϣ
	public void edit(Clothing clothing);
	//ɾ����װ��Ϣ
	public void delete(Clothing clothing);

}
