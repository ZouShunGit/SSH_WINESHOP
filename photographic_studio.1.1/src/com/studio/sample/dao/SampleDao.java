package com.studio.sample.dao;

import java.util.List;

import com.studio.sample.entity.Sample;

/**
 * ��Ʒ��dao�ӿ�
 * @author zoushun
 *
 */
public interface SampleDao {
	//�޸�
	public void update(Sample sample);
	//���
	public void add(Sample sample);
	//��ѯ
	public List<Sample> findAll(Sample sample);

}
