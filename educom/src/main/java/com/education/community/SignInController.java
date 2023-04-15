package com.education.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
	@RequestMapping(value="/login")
	private String index(Model model){
		model.addAttribute("page", "ログイン画面");
	    return "sign_in";
	}
}
