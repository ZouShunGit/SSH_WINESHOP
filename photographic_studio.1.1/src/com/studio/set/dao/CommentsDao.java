package com.studio.set.dao;

import java.util.List;

import com.studio.set.entity.Comments;

public interface CommentsDao {

	public List<Comments> findAll(Comments comments);

	public void add(Comments comments);

	public void update(Comments comments);

}
