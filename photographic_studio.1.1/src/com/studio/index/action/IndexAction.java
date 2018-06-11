package com.studio.index.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studio.clothing.entity.SecondCategory;
import com.studio.clothing.service.SecondCategoryService;
import com.studio.sample.entity.Sample;
import com.studio.sample.entity.SampleCategory;
import com.studio.sample.service.SampleCategoryService;
import com.studio.sample.service.SampleService;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return the sampleService
	 */
	public SampleService getSampleService() {
		return sampleService;
	}

	/**
	 * @param sampleService the sampleService to set
	 */
	public void setSampleService(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	public SampleCategoryService getSampleCategoryService() {
		return sampleCategoryService;
	}

	public void setSampleCategoryService(SampleCategoryService sampleCategoryService) {
		this.sampleCategoryService = sampleCategoryService;
	}





	/**
	 * @return the scategoryService
	 */
	public SecondCategoryService getScategoryService() {
		return scategoryService;
	}

	/**
	 * @param scategoryService the scategoryService to set
	 */
	public void setScategoryService(SecondCategoryService scategoryService) {
		this.scategoryService = scategoryService;
	}

	private SampleService sampleService;
	private SampleCategoryService sampleCategoryService;
	private SecondCategoryService scategoryService;

	
	public String find() {
		Sample sample = new Sample();
		
		List<Sample> samples = sampleService.findAll(sample);
		ServletActionContext.getRequest().getSession().setAttribute("samples", samples);

		SampleCategory category = new SampleCategory();
		List<SampleCategory> categories =sampleCategoryService.findAll(category);
		ServletActionContext.getRequest().getSession().setAttribute("categories", categories);
		
		SecondCategory secondCategory = new SecondCategory();
		List<SecondCategory> secondCategories = scategoryService.findAll(secondCategory);
		ServletActionContext.getRequest().getSession().setAttribute("secondCategories", secondCategories);
		return "index";	
	}

	

}
