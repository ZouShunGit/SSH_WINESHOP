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
 * 样品的Action类
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
	 * 查询满足条件的信息
	 * 
	 * @return
	 */ 
	public String findAll() {
		if (sample.getSampleCategory() == null) {
			sample.setSampleCategory(new SampleCategory());
		}
		// 分页设置 
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
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}

		List<SampleCategory> categories = sampleCategoryService.findAll(sample.getSampleCategory());
		ActionContext.getContext().getValueStack().set("categories", categories);
		return "findAll";
	}
	/**
	 * 前台页面显示
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
			this.addActionMessage("没有符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("samples", samples);
		}
		return "index";
	}

	/**
	 * 添加页面跳转
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
	 * 判断级别的名称是否已存在
	 * 
	 * @throws IOException
	 */
	public void findSname() throws IOException {
		List<Sample> categories = sampleService.findAll(sample);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (categories.size() != 0) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("0");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("1");
		}
	}

	/**
	 * 图片上传的属性
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
	 * 添加样片信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException {
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sample");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);
			sample.setImg("sample/" + uploadFileName);
		} else {
			sample.setImg(null); 
		}
		sampleService.add(sample);
		return "find";
	}

	/**
	 * 信息编辑页面跳转
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
	 * 编辑信息
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws IOException {
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sample");
			// 创建文件类型对象:
			File diskFile = new File(path + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);
			sample.setImg("sample/" + uploadFileName);
		}
		sampleService.edit(sample);
		return "find";
	}

	/**
	 * 删除级别信息
	 * 
	 * @return
	 */
	public String delete() {
	
		sampleService.delete(sample);
		return "find";
	}
}
