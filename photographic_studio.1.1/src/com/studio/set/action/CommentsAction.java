package com.studio.set.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.set.entity.Comments;
import com.studio.set.entity.Set;
import com.studio.set.service.CommentsService;
import com.studio.set.service.SetService;

public class CommentsAction extends ActionSupport implements ModelDriven<Comments> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Comments getModel() {
		// TODO Auto-generated method stub
		return comments;
	}

	/**
	 * @return the commentsService
	 */
	public CommentsService getCommentsService() {
		return commentsService;
	}

	/**
	 * @param commentsService
	 *            the commentsService to set
	 */
	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	public SetService getSetService() {
		return setService;
	}

	public void setSetService(SetService setService) {
		this.setService = setService;
	}

	private Comments comments = new Comments();
	private CommentsService commentsService;
	private SetService setService;

	/**
	 * ����Ա�����۲�ѯ
	 * 
	 * @return
	 */
	public String findAll() {
		// ��ҳ����
		List<Comments> listcomments = commentsService.findAll(comments);
		comments.getPageBean().setListnum(listcomments.size());
		comments.getPageBean().setRows(6);
		comments.getPageBean().setTotalPage((comments.getPageBean().getListnum() + comments.getPageBean().getRows() - 1)
				/ comments.getPageBean().getRows());
		comments.getPageBean().setStartnum((comments.getPageBean().getPage() - 1) * comments.getPageBean().getRows());
		comments.getPageBean().setEndnum(comments.getPageBean().getStartnum() + comments.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", comments);
		List<Comments> list = commentsService.findAll(comments);
		
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAll";
	}
	/**
	 * �������
	 */
	public void add() {
		commentsService.add(comments);
	}

	public String delete() {
		System.out.println(comments);
		commentsService.delete(comments);
		return "find";
	}

	/**
	 * �ײ�����ҳ���۲�ѯ
	 * 
	 * @return
	 */
	public String index() {
		// �ײͲ�ѯ
		Set set = new Set();
		set.setSetid(comments.getSet().getSetid());
		List<Set> sets = setService.findAll(set);
		for (Set set2 : sets) {
			set = set2;
		}
		ActionContext.getContext().getValueStack().set("set", set);
		// ��ҳ����
		List<Comments> listcomments = commentsService.findAll(comments);
		comments.getPageBean().setListnum(listcomments.size());
		comments.getPageBean().setRows(4);
		comments.getPageBean().setTotalPage((comments.getPageBean().getListnum() + comments.getPageBean().getRows() - 1)
				/ comments.getPageBean().getRows());
		comments.getPageBean().setStartnum((comments.getPageBean().getPage() - 1) * comments.getPageBean().getRows());
		comments.getPageBean().setEndnum(comments.getPageBean().getStartnum() + comments.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", comments);

		List<Comments> list = commentsService.findAll(comments);
		if (list.isEmpty()) {
			this.addActionMessage("���ײͻ�û�����ۣ�");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "index";
	}
}
