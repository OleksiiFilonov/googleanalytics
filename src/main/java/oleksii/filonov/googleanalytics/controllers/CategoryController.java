package oleksii.filonov.googleanalytics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/category")
public class CategoryController {

	@RequestMapping
	public String showCategoryWithProducts() {
		return "category";
	}

}