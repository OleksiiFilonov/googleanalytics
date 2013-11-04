package oleksii.filonov.googleanalytics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductDetailsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doShowProduct() {
		return "product";
	}

}
