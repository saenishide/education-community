package com.education.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignUpController {
	@RequestMapping(value="/signup")
	private String index(Model model){
		model.addAttribute("page", "新規登録画面");
	    return "sign_up";
	}
}

