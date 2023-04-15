package com.education.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	@RequestMapping(value="/profile")
	private String index(Model model){
		model.addAttribute("page", "プロフィール画面");
	    return "profile";
	}
}
