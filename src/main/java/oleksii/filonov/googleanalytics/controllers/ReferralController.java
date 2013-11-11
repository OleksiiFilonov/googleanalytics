package oleksii.filonov.googleanalytics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/referral")
public class ReferralController {

	@RequestMapping
	public String showReferralPage() {
		return "referral";
	}

}
