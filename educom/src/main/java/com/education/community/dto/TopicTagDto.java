package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopicTagDto {

	private int topicId;
	private String interestCd;
	private LocalDateTime registDate;
}
