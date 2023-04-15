package com.education.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicDetailController {
	@RequestMapping(value="/topic/detail")
	private String index(Model model){
		model.addAttribute("page", "トピック詳細画面");
	    return "topic_detail";
	}
}
