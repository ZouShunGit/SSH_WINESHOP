package com.studio.sample.dao;

import java.util.List;

import com.studio.sample.entity.SampleCategory;

/**
 * ��Ʒ�����Dao�ӿ�
 * @author zoushun
 *
 */
public interface SampleCategoryDao {
	//��ѯ
	public List<SampleCategory> findAll(SampleCategory sampleCategory);
	//���
	public void add(SampleCategory sampleCategory);
	//�޸�
	public void update(SampleCategory sampleCategory);

}
