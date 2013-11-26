package oleksii.filonov.googleanalytics.utils;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import oleksii.filonov.googleanalytics.domainmodel.Order;

@Component
public class SessionUtils {


	private static final String CART = "cart";

	public void createCart(final HttpSession session) {
		session.setAttribute(CART, new Order());
	}

	public Order getCart(final HttpSession session) {
		return (Order)session.getAttribute(CART);
	}

}
