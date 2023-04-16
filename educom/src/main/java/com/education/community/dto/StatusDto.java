package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDto {

	private String statusCd;
	private String statusName;
	private LocalDateTime registDate;
}
