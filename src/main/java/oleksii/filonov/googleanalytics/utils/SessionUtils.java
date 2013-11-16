package oleksii.filonov.googleanalytics.utils;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;

public final class SessionUtils {


	private static final String CART = "cart";

	public static void createCart(final HttpSession session) {
		session.setAttribute(CART, new Order());
	}

	public static Order getCart(final HttpSession session) {
		return (Order)session.getAttribute(CART);
	}

}
