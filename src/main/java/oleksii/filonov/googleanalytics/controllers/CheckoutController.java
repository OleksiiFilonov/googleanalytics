package oleksii.filonov.googleanalytics.controllers;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@RequestMapping(value = "/delivery")
	public String showDelivery() {
		return "delivery";
	}

	@RequestMapping("/payment")
	public String showPayment() {
		return "payment";
	}

	@RequestMapping("/confirmation")
	public String showConfirmation() {
		return "confirmation";
	}

	@RequestMapping("/thankyou")
	public String showThankYou(final HttpSession session) {
		final Order order = SessionUtils.getCart(session);
		order.clean();
		return "thankyou";
	}


}
