package com.studio.set.service;

import java.util.List;

import com.studio.set.entity.Comments;

public interface CommentsService {

	public List<Comments> findAll(Comments comments);

	public void add(Comments comments);

	public void delete(Comments comments);

}
