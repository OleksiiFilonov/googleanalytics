package oleksii.filonov.googleanalytics.controllers;

import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showConfirmation(final Model model, final HttpSession session) {
		model.addAttribute("cart", SessionUtils.getCart(session));
		return "confirmation";
	}

	@RequestMapping("/thankyou")
	public String showThankYou(final Model model, final HttpSession session) {
		final Order order = SessionUtils.getCart(session);
		model.addAttribute("lastOrder", order);
		SessionUtils.createCart(session);
		return "thankyou";
	}


}
