package oleksii.filonov.googleanalytics.controllers;

import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

	@Autowired
	private ProductStorage productStorage;

	@RequestMapping("/search")
	public String doPseudoSearch(final Model model) {
		displayAllProducts(model);
		return "search";
	}

	private void displayAllProducts(final Model model) {
		model.addAttribute("products", this.productStorage.getProducts());
	}

	@RequestMapping("/category")
	public String showCategoryWithProducts(final Model model) {
		displayAllProducts(model);
		return "category";
	}

}
