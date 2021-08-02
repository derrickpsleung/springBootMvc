package com.spirngboot.mvc.springBootMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnitTrustWebController {

	@RequestMapping("/unitTrustWeb")
	public String unitTrustWeb(Model model) {
		model.addAttribute("name", "Derrick");
		return "unitTrustWeb";
	}

}
