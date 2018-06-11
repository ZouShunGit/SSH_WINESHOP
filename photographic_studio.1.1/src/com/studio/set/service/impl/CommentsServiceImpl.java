package com.studio.set.service.impl;

import java.util.Date;
import java.util.List;

import com.studio.set.dao.CommentsDao;
import com.studio.set.entity.Comments;
import com.studio.set.service.CommentsService;

public class CommentsServiceImpl implements CommentsService {
	private CommentsDao commentsDao;

	/**
	 * @return the commentsDao
	 */
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	/**
	 * @param commentsDao the commentsDao to set
	 */
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	@Override
	public List<Comments> findAll(Comments comments) {
		// TODO Auto-generated method stub
		return commentsDao.findAll(comments);
	}

	@Override
	public void add(Comments comments) {
		// TODO Auto-generated method stub
		comments.setCreattime(new Date());
		commentsDao.add(comments);
	}

	@Override
	public void delete(Comments comments) {
		// TODO Auto-generated method stub
		comments.setIs_delete(1);
		commentsDao.update(comments);
	}
}
