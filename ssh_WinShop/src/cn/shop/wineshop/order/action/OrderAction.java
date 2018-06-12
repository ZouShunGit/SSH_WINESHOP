package cn.shop.wineshop.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.shop.wineshop.cart.domain.Cart;
import cn.shop.wineshop.cart.domain.CartItem;
import cn.shop.wineshop.order.domain.Order;
import cn.shop.wineshop.order.domain.OrderItem;
import cn.shop.wineshop.order.service.OrderService;
import cn.shop.wineshop.user.domain.User;
import cn.shop.wineshop.util.PageBean;

/**
 * �û��Զ����Ĳ���Action
 * 
 * @author zoushun
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ģ������ʹ�õĶ���
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	// ����page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ע��OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// ���ɶ�����ִ�еķ���:
	public String saveOrder() {

		// ����Service������ݿ����Ĳ���:
		// Order order = new Order();
		// ���ö������ܽ��:�������ܽ��Ӧ���ǹ��ﳵ���ܽ��:
		// ���ﳵ��session��,��session�ܻ�ù��ﳵ��Ϣ.
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if (cart == null) {
			this.addActionMessage("��!����û�й���!");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		// ���ö�����״̬
		order.setState(1); // 1:δ����.
		// ���ö���ʱ��
		order.setOrdertime(new Date());
		// ���ö��������Ŀͻ�:
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (existUser == null) {
			this.addActionMessage("��!����û�е�¼!");
			return "msg";
		}
		order.setUser(existUser);
		// ���ö������:
		for (CartItem cartItem : cart.getCartItems()) {
			// ���������Ϣ�ӹ������õ�.
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		orderService.save(order);
		// ��չ��ﳵ:
		cart.clearCart();
		// ҳ����Ҫ���Զ�����Ϣ:
		// ʹ��ģ�������� ���п��Բ�ʹ��ֵջ������
		// ActionContext.getContext().getValueStack().set("order", order);
		return "saveOrder";
	}

	// ��ѯ�ҵĶ���:
	public String findByUid() {
		// ����û���id.
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		// ����û���id
		Integer uid = existUser.getUid();
		// �����û���id��ѯ����:
		PageBean<Order> pageBean = orderService.findByUid(uid, page);
		// ��PageBean���ݴ���ҳ����.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUid";
	}

	// ���ݶ���id��ѯ����:
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}

	// Ϊ��������:
	public String payOrder() throws IOException {
		// 1.�޸�����:
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setAddr(order.getAddr());
		currOrder.setName(order.getName());
		currOrder.setPhone(order.getPhone());

		/**
		 * �˴��������������˻���������һ����Ϊ��¼ʵ��
		 */

		// �޸Ķ���״̬Ϊ2:�Ѿ�����:
		currOrder.setState(2);
		// �޸Ķ���
		orderService.update(currOrder);
		this.addActionMessage("֧���ɹ�!�������Ϊ: " + order.getOid() + " ������Ϊ: " + currOrder.getTotal() + "Ԫ");
		return "msg";
	}

	// �޸Ķ�����״̬:
	public String updateState() {
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(4);
		orderService.update(currOrder);
		return "updateStateSuccess";
	}
}
