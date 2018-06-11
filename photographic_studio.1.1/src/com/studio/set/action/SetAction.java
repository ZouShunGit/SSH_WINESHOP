package com.studio.set.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.set.entity.Set;
import com.studio.set.service.SetService;

public class SetAction extends ActionSupport implements ModelDriven<Set> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Set getModel() {
		// TODO Auto-generated method stub
		return set;
	}

	/**
	 * @return the setService
	 */
	public SetService getSetService() {
		return setService;
	}

	/**
	 * @param setService
	 *            the setService to set
	 */
	public void setSetService(SetService setService) {
		this.setService = setService;
	}

	private Set set = new Set();
	private SetService setService;

	/**
	 * ͼƬ�ϴ�������
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * ��ѯ���з�����������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {
		// ��ҳ����
		List<Set> listset = setService.findAll(set);
		set.getPageBean().setListnum(listset.size());
		set.getPageBean().setRows(4);
		set.getPageBean().setTotalPage( 
				(set.getPageBean().getListnum() + set.getPageBean().getRows() - 1) / set.getPageBean().getRows());
		set.getPageBean().setStartnum((set.getPageBean().getPage() - 1) * set.getPageBean().getRows());
		set.getPageBean().setEndnum(set.getPageBean().getStartnum()+ set.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", set);

		List<Set> list = setService.findAll(set);
		if (list.isEmpty()) {
			this.addActionMessage("û�з�����������Ϣ��");
		}else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";
	}

	/**
	 * ���ҳ�����ת
	 * 
	 * @return
	 */
	public String addPage() {

		return "addPage";
	}
	/**
	 * ��ѯ�ײ����Ƿ����
	 * @throws IOException
	 */
	public void findSetname() throws IOException{
		List<Set> sets = setService.findAll(set);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж� 
		if (sets.size() != 0) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("0");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("1");
		}
		
	}
	/**
	 * ����ײ���Ϣ
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		if (upload != null) {
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sets");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			set.setSetimg("sets/" + uploadFileName);
		} else {
			set.setSetimg(null);
		}
		setService.add(set);
		return "find";
	}

	/**
	 * �༭ҳ�����ת
	 * 
	 * @return
	 * 
	 */
	public String editPage() {
		List<Set> list = setService.findAll(set);
		ActionContext.getContext().getValueStack().set("list", list);
		return "editPage";
	}

	/**
	 * �ײ���Ϣ�޸�
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException {
		if (upload != null) {
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sets");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			// System.out.println(uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			set.setSetimg("sets/" + uploadFileName);
		} else {
			set.setSetimg(null);
		}
		setService.edit(set);
		return "find";
	}

	/**
	 * �ײ���Ϣɾ��
	 * 
	 * @return
	 */
	public String delete() {
		setService.delete(set);
		return "find";

	}

	/**
	 * ǰ̨ҳ����Ϣչʾ
	 * 
	 * @return
	 */
	public String index() {
		// ��ҳ����
		List<Set> listset = setService.findAll(set);
		set.getPageBean().setListnum(listset.size());
		set.getPageBean().setRows(5);
		set.getPageBean().setTotalPage(
				(set.getPageBean().getListnum() + set.getPageBean().getRows() - 1) / set.getPageBean().getRows());
		set.getPageBean().setStartnum((set.getPageBean().getPage() - 1) * set.getPageBean().getRows());
		set.getPageBean().setEndnum(set.getPageBean().getStartnum() + set.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", set);

		List<Set> list = setService.findAll(set);
		if (list.isEmpty()) {
			this.addActionMessage("û������Ҫ����Ϣ��");
		}else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "index";
	}
}
