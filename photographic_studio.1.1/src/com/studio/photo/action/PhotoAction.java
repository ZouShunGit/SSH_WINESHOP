package com.studio.photo.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.order.entity.Order;
import com.studio.order.entity.OrderItem;
import com.studio.order.service.OrderItemService;
import com.studio.order.service.OrderService;
import com.studio.photo.entity.Photo;
import com.studio.photo.service.PhotoService;
import com.studio.sample.service.SampleCategoryService;

/**
 * ������Ƭ��Action��
 * 
 * @author zoushun
 *
 */
public class PhotoAction extends ActionSupport implements ModelDriven<Photo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Photo getModel() {
		// TODO Auto-generated method stub
		return photo;
	}

	/**
	 * @return the photoService
	 */
	public PhotoService getPhotoService() {
		return photoService;
	}

	/**
	 * @param photoService
	 *            the photoService to set
	 */
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	/**
	 * @return the orderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}

	/**
	 * @param orderService
	 *            the orderService to set
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	private Photo photo = new Photo();
	private PhotoService photoService;
	private OrderService orderService;
	private SampleCategoryService sampleCategoryService;
	private OrderItemService orderItemService;

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
	 * ����ѡƬ���ҳ�����ת
	 * 
	 * @return
	 */
	public String addPage() {
		Order order = new Order();
		order.setOid(photo.getOid());
		List<Order> orders = orderService.findAll(order);
		for (Order order2 : orders) {
			order = order2;
		}
		ServletActionContext.getRequest().getSession().setAttribute("order", order);
		return "addPage";
	}

	public void add() throws IOException {
		Order order = new Order();
		order = (Order) ServletActionContext.getRequest().getSession().getAttribute("order");
		photo.setOid(order.getOid());
		photo.setPhotodate(order.getPhotodate());
		if (upload != null) {
			// ����ƷͼƬ�ϴ�����������.
			// ����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/images/sample");
			// �����ļ����Ͷ���:
			File diskFile = new File(path + "//" + uploadFileName);
			System.out.println(uploadFileName);
			// �ļ��ϴ�:
			FileUtils.copyFile(upload, diskFile);
			photo.setPimg("photo/" + uploadFileName);
		} else {
			photo.setPimg(null);
		}
		order.setOstate(3);
		orderService.edit(order);
		photoService.add(photo);
	}

	/**
	 * ��������ҳ��ѯ������������Ϣ
	 * 
	 * @return
	 */
	public String findAll() {
		List<Photo> listset = photoService.findAll(photo);
		photo.getPageBean().setListnum(listset.size());
		photo.getPageBean().setRows(7);
		photo.getPageBean().setTotalPage(
				(photo.getPageBean().getListnum() + photo.getPageBean().getRows() - 1) / photo.getPageBean().getRows());
		photo.getPageBean().setStartnum((photo.getPageBean().getPage() - 1) * photo.getPageBean().getRows());
		photo.getPageBean().setEndnum(photo.getPageBean().getStartnum() + photo.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", photo);

		List<Photo> list = photoService.findAll(photo);
		if (list.isEmpty()) {
			this.addActionMessage("û�в�ѯ��������������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";
	}

	/**
	 * ɾ������ѡƬ��Ϣ
	 * 
	 * @return
	 */
	public String delete() {
		photoService.delete(photo);
		return "find";

	}

	/**
	 * �û�����ѡƬҳ����ת
	 * 
	 * @return
	 */
	public String select() {
		List<Photo> listset = photoService.findAll(photo);
		photo.getPageBean().setListnum(listset.size());
		photo.getPageBean().setRows(8);
		photo.getPageBean().setTotalPage(
				(photo.getPageBean().getListnum() + photo.getPageBean().getRows() - 1) / photo.getPageBean().getRows());
		photo.getPageBean().setStartnum((photo.getPageBean().getPage() - 1) * photo.getPageBean().getRows());
		photo.getPageBean().setEndnum(photo.getPageBean().getStartnum() + photo.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", photo);

		List<Photo> list = photoService.findAll(photo);
		if (list.isEmpty()) {
			this.addActionMessage("û�в�ѯ��������������Ϣ��");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}

		return "select";
	}

	/**
	 * ��������ѡƬ
	 * 
	 * @throws IOException
	 */
	public void edit() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// ͳ�Ƹö�������ѡ�����Ƭ��
		OrderItem item = new OrderItem();
		item.setOid(photo.getOid());
		List<OrderItem> items = orderItemService.findAll(item);
		int num = 0;
		for (OrderItem orderItem : items) {
			int sum = orderItem.getSetnum() * orderItem.getSet().getImgnum();
			num += sum;
		}
		// ��ѯ�Ѿ�ѡ�����Ƭ
		Photo photo1 = new Photo();
		photo1.setOid(photo.getOid());
		photo1.setSign(2);
		List<Photo> list = photoService.findAll(photo1);
		if (list.size() + 1 < num) {
			// �޸�����ѡƬ�ı�־
			photoService.edit(photo);
			response.getWriter().println("1");
		} else {
			// �޸�����ѡƬ�ı�־
			photoService.edit(photo);
			if (photoService.findAll(photo1).size() == num) {
				// �����޸�
				Order order = new Order();
				order.setOid(photo1.getOid());
				order.setSelectdate(new Date());
				order.setOstate(4);
				orderService.edit(order);
			}
			response.getWriter().println("0");
		}
	}
}
