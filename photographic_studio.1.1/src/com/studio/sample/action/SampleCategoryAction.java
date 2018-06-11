package com.studio.sample.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.sample.entity.SampleCategory;
import com.studio.sample.service.SampleCategoryService;

/**
 * ��Ʒ�����Action��
 * 
 * @author zoushun
 *
 */
public class SampleCategoryAction extends ActionSupport implements ModelDriven<SampleCategory> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SampleCategory getModel() {
		// TODO Auto-generated method stub
		return sampleCategory;
	}

	/**
	 * @return the sampleCategoryService
	 */
	public SampleCategoryService getSampleCategoryService() {
		return sampleCategoryService;
	}

	/**
	 * @param sampleCategoryService
	 *            the sampleCategoryService to set
	 */
	public void setSampleCategoryService(SampleCategoryService sampleCategoryService) {
		this.sampleCategoryService = sampleCategoryService;
	}

	private SampleCategory sampleCategory = new SampleCategory();
	private SampleCategoryService sampleCategoryService;

	/**
	 * ��ѯ������������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {
		// ��ҳ����
		List<SampleCategory> listset = sampleCategoryService.findAll(sampleCategory);
		sampleCategory.getPageBean().setListnum(listset.size());
		sampleCategory.getPageBean().setRows(3);
		sampleCategory.getPageBean()
				.setTotalPage((sampleCategory.getPageBean().getListnum() + sampleCategory.getPageBean().getRows() - 1)
						/ sampleCategory.getPageBean().getRows());
		sampleCategory.getPageBean()
				.setStartnum((sampleCategory.getPageBean().getPage() - 1) * sampleCategory.getPageBean().getRows());
		sampleCategory.getPageBean()
				.setEndnum(sampleCategory.getPageBean().getStartnum() + sampleCategory.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", sampleCategory);

		List<SampleCategory> list = sampleCategoryService.findAll(sampleCategory);
		if (list.isEmpty()) {
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";
	}

	/**
	 * ���ҳ����ת
	 * 
	 * @return
	 */
	public String addPage() {
		return "addPage";
	}

	/**
	 * �жϼ���������Ƿ��Ѵ���
	 * 
	 * @throws IOException
	 */
	public void findByscname() throws IOException {
		List<SampleCategory> categories = sampleCategoryService.findAll(sampleCategory);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (categories.size() != 0) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("0");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("1");
		}
	}

	/**
	 * ��Ӽ�����Ϣ
	 * 
	 * @return
	 */
	public String add() {
		sampleCategoryService.add(sampleCategory);
		return "find";
	}

	/**
	 * ��Ϣ�༭ҳ����ת
	 * 
	 * @return
	 */
	public String editPage() {
		System.err.println(sampleCategory);
		List<SampleCategory> categories = sampleCategoryService.findAll(sampleCategory);
		for (SampleCategory sampleCategory1 : categories) {
			sampleCategory = sampleCategory1;
		}
		return "editPage";
	}

	/**
	 * �༭��Ϣ
	 * 
	 * @return
	 */
	public String edit() {
		sampleCategoryService.edit(sampleCategory);
		return "find";
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @return
	 */
	public String delete() {
		sampleCategoryService.delete(sampleCategory);
		return "find";

	}
}
