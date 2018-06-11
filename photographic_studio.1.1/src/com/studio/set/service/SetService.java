package com.studio.set.service;

import java.util.List;

import com.studio.set.entity.Set;

public interface SetService {

	public List<Set> findAll(Set set);

	public void add(Set set);

	public void edit(Set set);

	public void delete(Set set);

}
