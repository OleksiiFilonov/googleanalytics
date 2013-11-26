package oleksii.filonov.googleanalytics.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import oleksii.filonov.googleanalytics.domainmodel.Order;
import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;
import oleksii.filonov.googleanalytics.utils.SessionUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ProductStorage productStorage;
	@Resource
	private SessionUtils sessionUtils;	

	private static final String CART_PAGE = "cart";

	@RequestMapping
	public String showCart(final Model model, final HttpSession session) {
		model.addAttribute("cart", sessionUtils.getCart(session));
		return CART_PAGE;
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestParam final String productId, final HttpSession session) {
		final Order order = sessionUtils.getCart(session);
		order.addProduct(this.productStorage.getProduct(productId));
		return "redirect:/" + CART_PAGE + ".do";
	}

}
