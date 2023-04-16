package com.education.community.repo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.education.community.dto.UserDto;
import com.education.community.dto.UserInterestDto;
import com.education.community.dto.UserProfileDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {

	private final JdbcTemplate jdbcTemplate;

	public UserDto getMyUser(String useId) {
		String sql = "SELECT USER_ID, USER_NAME, PASS, LAST_LOGIN_DATE, REGIST_DATE, ACTIVE FROM createdb.user WHERE USER_ID = ?";
		Map<String, Object> userMap = jdbcTemplate.queryForMap(sql, useId);
		UserDto userDto = new UserDto(
                (String) userMap.get("USER_ID")
                ,(String) userMap.get("USER_NAME")
                ,(String) userMap.get("PASS")
                ,(LocalDateTime) userMap.get("LAST_LOGIN_DATE")
				, (LocalDateTime) userMap.get("REGIST_DATE")
                ,(Boolean) userMap.get("ACTIVE")
         );
		return userDto;
	}

	public UserProfileDto getMyUserProfile(String useId) {
		String sql = "SELECT USER_ID, ICON_IMAGE_FILE_NAME, STATUS_CD, HIST_NUM, FAVORITE_SUBJECT_CD, OTHER, REGIST_DATE, UPDATE_DATE  FROM createdb.user_profile WHERE USER_ID = ?";
		Map<String, Object> userMap = jdbcTemplate.queryForMap(sql, useId);
		UserProfileDto userProfileDto = new UserProfileDto(
                (String) userMap.get("USER_ID")
                ,(String) userMap.get("ICON_IMAGE_FILE_NAME")
                ,(String) userMap.get("STATUS_CD")
                ,(Long) userMap.get("HIST_NUM")
                ,(String) userMap.get("FAVORITE_SUBJECT_CD")
                ,(String) userMap.get("OTHER")
                ,(Timestamp) userMap.get("REGIST_DATE")
                ,(Timestamp) userMap.get("UPDATE_DATE")
         );
		return userProfileDto;
	}
	
	public List<UserInterestDto> getMyInterest(String useId) {
		String sql = "SELECT USER_ID, INTEREST_CD, REGIST_DATE FROM createdb.user_interest WHERE USER_ID = '"+ useId +"';";
		List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql);
		List<UserInterestDto> resultList = new ArrayList<>();
		for (Map<String, Object> comment : commentList) {
			resultList.add(new UserInterestDto(
					(String) comment.get("USER_ID"),
					(String) comment.get("INTEREST_CD"),
					(Timestamp) comment.get("REGIST_DATE")));
		}
		return resultList;
	}

}
