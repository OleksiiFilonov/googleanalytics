package oleksii.filonov.googleanalytics.controllers;

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
	public String showThankYou() {
		return "thankyou";
	}


}
