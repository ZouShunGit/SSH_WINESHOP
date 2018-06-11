package com.studio.set.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.set.dao.SetDao;
import com.studio.set.entity.Set;
import com.studio.set.service.SetService;

public class SetServiceImpl implements SetService {
	
	private SetDao setDao;

	/**
	 * @return the setDao
	 */
	public SetDao getSetDao() {
		return setDao;
	}

	/**
	 * @param setDao the setDao to set
	 */
	public void setSetDao(SetDao setDao) {
		this.setDao = setDao;
	}
	/**
	 * ��ѯ�ײ���Ϣ
	 */
	@Override
	public List<Set> findAll(Set set) {
		// TODO Auto-generated method stub
		return setDao.findAll(set);
	}
	
	/**
	 * �����Ϣ
	 */
	@Override
	public void add(Set set) {
		// TODO Auto-generated method stub
		set.setCreattime(new Date());
		setDao.add(set);
	}
	
	/**
	 * �༭��Ϣ
	 */
	@Override
	public void edit(Set set) {
		// TODO Auto-generated method stub
		setDao.update(set);
	}
	/**
	 * ��Ϣɾ��
	 */
	@Override
	public void delete(Set set) {
		// TODO Auto-generated method stub
		set.setIs_delete(1);
		setDao.update(set);
	}
	
}
