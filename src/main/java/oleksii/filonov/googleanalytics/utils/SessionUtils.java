package oleksii.filonov.googleanalytics.utils;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionUtils {

	@Autowired
	private OrderGenerator orderGenerator;


	private static final String CART = "cart";

	public void createCart(final HttpSession session) {
		final Order order = new Order();
		order.setOrderId(this.orderGenerator.generateOrderNumber());
		session.setAttribute(CART, order);
	}

	public Order getCart(final HttpSession session) {
		return (Order)session.getAttribute(CART);
	}

}
