package oleksii.filonov.googleanalytics.controllers;

import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductDetailsController {

	@Autowired
	private ProductStorage productStorage;

	@RequestMapping("/{productId}")
	public String showProduct(@PathVariable final String productId, final Model model) {
		model.addAttribute("product", this.productStorage.getProduct(productId));
		return "product";
	}

}
