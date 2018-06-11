package com.studio.order.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.studio.car.entity.Car;
import com.studio.car.service.CarService;
import com.studio.employee.entity.Employee;
import com.studio.employee.service.EmpService;
import com.studio.order.entity.Order;
import com.studio.order.entity.OrderItem;
import com.studio.order.service.OrderItemService;
import com.studio.order.service.OrderService;
import com.studio.user.entity.User;

/**
 * 订单的Action类
 * 
 * @author zoushun
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
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
	 * @return the orderItemService
	 */
	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	/**
	 * @param orderItemService
	 *            the orderItemService to set
	 */
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	/**
	 * @return the carService
	 */
	public CarService getCarService() {
		return carService;
	}

	/**
	 * @param carService
	 *            the carService to set
	 */
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	private Order order = new Order();
	private OrderService orderService;
	private OrderItemService orderItemService;
	private CarService carService;
	private EmpService empService;

	/**
	 * 保存订单
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String add() {
		order.setUser((User) ActionContext.getContext().getSession().get("existUser"));
		order.setCreattime(new Date());

		order.setRealprice((Double) ActionContext.getContext().getSession().get("total"));

		order.setEarnest(order.getRealprice());
		order.setOstate(1);
		orderService.add(order);
		List<Order> orders = orderService.findAll(order);
		for (Order or : orders) {
			order.setOid(or.getOid());
		}
		List<Car> cars = (List<Car>) ServletActionContext.getRequest().getSession().getAttribute("list");
		for (Car car : cars) {
			Car c = new Car(car.getId(),car.getCarid());
			carService.delete(c);
			OrderItem item = new OrderItem();
			item.setOid(order.getOid());
			item.setSetnum(car.getSetnum());
			item.setSet(car.getSet());
			orderItemService.add(item);
		}
		return "editPagea";
	}

	/**
	 * 订单信息修改页面
	 * 
	 * @return
	 */
	public String editPage() {
		//判断是购物车提交生成或订单列标题
		if (order.getOid() == 0) {
			order.setUser((User) ActionContext.getContext().getSession().get("existUser"));
			order.setCreattime(new Date());
		}

		List<Order> orders = orderService.findAll(order);
		for (Order order1 : orders) {
			order = order1;
		}
	
		OrderItem or = new OrderItem();
		or.setOid(order.getOid());
		Double total = 0.0;
		List<OrderItem> list = orderItemService.findAll(or);
		for (OrderItem orderItem : list) {
			total += orderItem.getSetnum() * orderItem.getSet().getOnlineprice();
		}
		ActionContext.getContext().getValueStack().set("total", total);
		ActionContext.getContext().getValueStack().set("list", list);

		List<Employee> photographers = new ArrayList<>();
		List<Employee> dressers = new ArrayList<>();
		Employee employee = new Employee();
		List<Employee> employees = empService.findEmp(employee);
		for (Employee employee1 : employees) {
			if (employee1.getEmployeeLevel().getElname().equals("摄影师")) {
				photographers.add(employee1);

			}
			if (employee1.getEmployeeLevel().getElname().equals("化妆师")) {
				dressers.add(employee1);
			}
		}
		ActionContext.getContext().getValueStack().set("photographers", photographers);
		ActionContext.getContext().getValueStack().set("dressers", dressers);

		return "editPage";
	}

	/**
	 * 订单信息编辑
	 * 
	 * @return
	 */
	public String edit() {
		orderService.edit(order);
		this.addActionMessage("购买成功，请于拍摄前一周内到影楼进行服装选择！");
		return "msg";
	}

	/**
	 * 查询符合条件的订单0
	 * 
	 * @return
	 */
	public String findAll() {
		List<Order> listset = orderService.findAll(order);
		order.getPageBean().setListnum(listset.size());
		order.getPageBean().setRows(15);
		order.getPageBean().setTotalPage(
				(order.getPageBean().getListnum() + order.getPageBean().getRows() - 1) / order.getPageBean().getRows());
		order.getPageBean().setStartnum((order.getPageBean().getPage() - 1) * order.getPageBean().getRows());
		order.getPageBean().setEndnum(order.getPageBean().getStartnum() + order.getPageBean().getRows());
		ActionContext.getContext().getValueStack().set("pages", order);

		List<Order> list = orderService.findAll(order);
		
		
		if (list.isEmpty()) {
			this.addActionMessage("没有查询到符合条件的信息！");
		} else {
			ActionContext.getContext().getValueStack().set("list", list);
		}
		return "findAll";

	}

	/**
	 * 用户取消订单
	 * 
	 * @return
	 */
	public String delete() {
		System.out.println(order);
		orderService.delete(order);

		return "msg";

	}
	/** 
	 * 订单详情页
	 */
	public String item() {
		List<Order> li =  orderService.findAll(order);
		for (Order or : li) {
			order = or;
		}
		OrderItem item = new OrderItem();
		item.setOid(order.getOid());
		List<OrderItem> list = orderItemService.findAll(item);
		double total = 0.0;
		for (OrderItem orderItem : list) {
			double sum = 0.0;
			sum = orderItem.getSetnum()*orderItem.getSet().getOnlineprice();
			total += sum;
		}
		ActionContext.getContext().getValueStack().set("total", total);
		ActionContext.getContext().getValueStack().set("list", list);
		return "item";
	}

}
