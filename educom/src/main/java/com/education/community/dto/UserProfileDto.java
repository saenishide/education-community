package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileDto {
	
	private String userId;
	private String iconImageFileName;
	private String statusCd;
	private int histNum;
	private String favoriteSubjectCd;
	private String other;
	private LocalDateTime registDate;
	private LocalDateTime updateDate;

}
