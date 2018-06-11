package com.studio.sample.service;

import java.util.List;

import com.studio.sample.entity.Sample;

/**
 * ��Ʒ��Service�ӿ�
 * @author zoushun
 *
 */
public interface SampleService {

	public List<Sample> findAll(Sample sample);

	public void add(Sample sample);

	public void edit(Sample sample);

	public void delete(Sample sample);

}
