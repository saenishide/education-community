package com.education.community.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileDto {
	
	private String userId;
	private String iconImageFileName;
	private String statusCd;
	private Long histNum;
	private String favoriteSubjectCd;
	private String other;
	private Timestamp registDate;
	private Timestamp updateDate;

}
