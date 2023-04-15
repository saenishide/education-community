package com.education.community;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopicListController {
	@RequestMapping(value="/topic")
	private String index(Model model){
		model.addAttribute("page", "トピック一覧画面");
	    return "topic_list";
	}
}