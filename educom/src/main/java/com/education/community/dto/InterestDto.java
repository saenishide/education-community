package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InterestDto {

	private String interestCd;
	private String interestName;
	private LocalDateTime registDate;
}
