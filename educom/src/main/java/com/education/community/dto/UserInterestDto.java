package com.education.community.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInterestDto {

	private String userId;
	private String interestCd;
	private Timestamp registDate;
}
