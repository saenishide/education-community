package com.education.community.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.education.community.dto.InterestDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InterestRepository {

	private final JdbcTemplate jdbcTemplate;

	public List<InterestDto> getAllInterest() {
		String sql = "SELECT INTEREST_CD, INTEREST_NAME, REGIST_DATE FROM createdb.interest ORDER BY INTEREST_CD;";
		List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql);
		List<InterestDto> resultList = new ArrayList<>();
		for (Map<String, Object> comment : commentList) {
			resultList.add(new InterestDto(
					(String) comment.get("INTEREST_CD"),
					(String) comment.get("INTEREST_NAME"),
					(LocalDateTime) comment.get("REGIST_DATE")));
		}
		return resultList;
	}

}
