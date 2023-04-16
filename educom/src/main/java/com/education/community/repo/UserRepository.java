package com.education.community.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.education.community.dto.CommentDto;
import com.education.community.dto.InterestDto;
import com.education.community.dto.StatusDto;
import com.education.community.dto.SubjectDto;
import com.education.community.dto.UserDto;
import com.education.community.dto.UserInterestDto;
import com.education.community.dto.UserProfileDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

	private final JdbcTemplate jdbcTemplate;

	public UserDto getMyUser(String useId) {
		String sql = "SELECT USER_ID, USER_NAME, PASS, LAST_LOGIN_DATE, REGIST_DATE, ACTIVE FROM createdb.user WHERE USER_ID = '"+ useId +"';";
		UserDto userDto = jdbcTemplate.queryForObject(sql, UserDto.class);
		return userDto;
	}

	public UserProfileDto getMyUserProfile(String useId) {
		String sql = "SELECT USER_ID, ICON_IMAGE_FILE_NAME, STATUS_CD, HIST_NUM, FAVORITE_SUBJECT_CD, OTHER, REGIST_DATE, UPDATE_DATE  FROM createdb.userProfile WHERE USER_ID = '"+ useId +"';";
		UserProfileDto userDto = jdbcTemplate.queryForObject(sql, UserProfileDto.class);
		return userDto;
	}
	
	public List<UserInterestDto> getMyInterest(String useId) {
		String sql = "SELECT USER_ID, INTEREST_CD, REGIST_DATE FROM createdb.interest WHERE USER_ID = '"+ useId +"';";
		List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql);
		List<UserInterestDto> resultList = new ArrayList<>();
		for (Map<String, Object> comment : commentList) {
			resultList.add(new UserInterestDto(
					(String) comment.get("USER_ID"),
					(String) comment.get("INTEREST_CD"),
					(LocalDateTime) comment.get("REGIST_DATE")));
		}
		return resultList;
	}

}
