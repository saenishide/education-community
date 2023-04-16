package com.education.community;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	private String signUp(String userId, String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashPass = encoder.encode(pass);
		// 未完

		return "/";
	}
}

