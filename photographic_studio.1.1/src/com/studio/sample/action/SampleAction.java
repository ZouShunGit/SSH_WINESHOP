package com.studio.sample.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.sample.entity.Sample;
import com.studio.sample.entity.SampleCategory;
import com.studio.sample.service.SampleCategoryService;
import com.studio.sample.service.SampleService;

/**
 * ��Ʒ��Action��
 * 
 * @author zoushun
 * 
 */
public class SampleAction extends ActionSupport implements ModelDriven<Sample> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Sample getModel() {
		// TODO Auto-generated method stub
		return sample;
	}

	/**
	 * @return the sampleService
	 */
	public SampleService getSampleService() {
		return sampleService;
	}

	/**
	 * @param sampleService
	 *            the sampleService to set
	 */
	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
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

	private Sample sample = new Sample();
	private SampleService sampleService;
	private SampleCategoryService sampleCategoryService;

	/**
	 * ��ѯ������������Ϣ
	 * 
	 * @return
	 */ 
	public String findAll() {
		if (sample.getSampleCategory() == null) {
			sample.setSampleCategory(new SampleCategory());
		}
		// ��ҳ���� 
		List<Sample> listset = sampleService.findAll(sample);

		sample.getPageBean().setListnum(listset.size());
		sample.getPageBean().setRows(4);
		sample.getPageBean().setTotalPage((sample.getPageBean().getListnum() + sample.getPageBean().getRows() - 1)
				/ sample.getPageBean().getRows());
		sample.getPageBean().setStartnum((sample.getPageBean().getPage() - 1) * sample.getPageBean().getRows());
		sample.getPageBean().setEndnum(sample.getPageBean().getStartnum() + sample.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", sample);

		List<Sample> list = sampleService.findAll(sample);
		
		if (list.isEmpty()) {
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}

		List<SampleCategory> categories = sampleCategoryService.findAll(sample.getSampleCategory());
		ActionContext.getContext().getValueStack().set("categories", categories);
		return "findAll";
	}
	/**
	 * ǰ̨ҳ����ʾ
	 * @return
	 */
	public String index() {
		List<Sample> listset = sampleService.findAll(sample);

		sample.getPageBean().setListnum(listset.size());
		sample.getPageBean().setRows(16);
		sample.getPageBean().setTotalPage((sample.getPageBean().getListnum() + sample.getPageBean().getRows() - 1)
				/ sample.getPageBean().getRows());
		sample.getPageBean().setStartnum((sample.getPageBean().getPage() - 1) * sample.getPageBean().getRows());
		sample.getPageBean().setEndnum(sample.getPageBean().getStartnum() + sample.getPageBean().getRows());
		
		List<Sample> samples = sampleService.findAll(sample);
		
		if (samples.isEmpty()) {
			this.addActionMessage("û�з�����������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("samples", samples);
		}
		return "index";
	}

	/**
	 * ���ҳ����ת
	 * 
	 * @return
	 */
	public String addPage() {
		SampleCategory sampleCategory = new SampleCategory();
		List<SampleCategory> categories = sampleCategoryService.findAll(sampleCategory);
		ActionContext.getContext().getValueStack().set("categories", categories);
		return "addPage";
	}

	/**
	 * �жϼ���������Ƿ��Ѵ���
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		List<Sample> categories = sampleService.findAll(sample);
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
	 * �����Ƭ��Ϣ
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		if (upload != null) {
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sample");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);
			sample.setImg("sample/" + uploadFileName);
		} else {
			sample.setImg(null); 
		}
		sampleService.add(sample);
		return "find";
	}

	/**
	 * ��Ϣ�༭ҳ����ת
	 * 
	 * @return
	 */
	public String editPage() {
		SampleCategory sampleCategory = new SampleCategory();
		List<SampleCategory> categories = sampleCategoryService.findAll(sampleCategory);
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		List<Sample> samples = sampleService.findAll(sample);
		for (Sample sample1 : samples) {
			sample = sample1;
		}
		return "editPage";
	}

	/**
	 * �༭��Ϣ
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws IOException {
		if (upload != null) {
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sample");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);
			sample.setImg("sample/" + uploadFileName);
		}
		sampleService.edit(sample);
		return "find";
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @return
	 */
	public String delete() {
	
		sampleService.delete(sample);
		return "find";
	}
}
