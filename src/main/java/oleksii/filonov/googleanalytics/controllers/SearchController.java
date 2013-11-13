package oleksii.filonov.googleanalytics.controllers;

import oleksii.filonov.googleanalytics.domainmodel.ProductStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private ProductStorage productStorage;

	@RequestMapping
	public String doPseudoSearch(final Model model) {
		model.addAttribute("products", this.productStorage.getProducts());
		return "search";
	}

}
