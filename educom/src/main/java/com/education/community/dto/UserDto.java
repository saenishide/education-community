package com.education.community.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

	private String userId;
	private String userName;
	private String pass;
	private LocalDateTime lastLoginDate;
	private LocalDateTime registDate;
	private boolean active;
}
