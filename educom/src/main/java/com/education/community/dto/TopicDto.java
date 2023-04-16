package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopicDto {

	private int topicId;
	private String contributorUserId;
	private String title;
	private String textData;
	private LocalDateTime registDate;
	private boolean acitive;
}
