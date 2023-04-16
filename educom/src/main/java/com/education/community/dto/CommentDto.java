package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {

	private int commentId;
	private int topicId;
	private String userId;
	private String textData;
	private boolean Active;
	private LocalDateTime registDate;
	
	
}
