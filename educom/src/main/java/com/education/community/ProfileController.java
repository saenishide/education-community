package com.education.community;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.education.community.dto.UserDto;
import com.education.community.dto.UserInterestDto;
import com.education.community.dto.UserProfileDto;
import com.education.community.repo.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfileController {
	
	private final UserRepository userRepository;
	
	@RequestMapping(value="/profile")
	private String index(Model model){
		UserDto userData = userRepository.getMyUser("u000000001");
		UserProfileDto userProfileData = userRepository.getMyUserProfile("u000000001");
		List<UserInterestDto> interestList = userRepository.getMyInterest("u000000001");
		model.addAttribute("userData", userData);
		model.addAttribute("userProfileData", userProfileData);
		model.addAttribute("interestList", interestList);
	    return "profile";
	}
}
