package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubjectDto {

	private String subjectCd;
	private String subjectName;
	private LocalDateTime registDate;
}
