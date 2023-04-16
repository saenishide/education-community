package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInterestDto {

	private String userId;
	private String interestCd;
	private LocalDateTime registDate;
}
