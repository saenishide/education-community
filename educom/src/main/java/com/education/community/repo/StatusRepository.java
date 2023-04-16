package com.education.community.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.education.community.dto.StatusDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StatusRepository {

	private final JdbcTemplate jdbcTemplate;

	public List<StatusDto> getAllStatus() {
		String sql = "SELECT STATUS_CD, STATUS_NAME, REGIST_DATE FROM createdb.status ORDER BY STATUS_CD;";
		List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql);
		List<StatusDto> resultList = new ArrayList<>();
		for (Map<String, Object> comment : commentList) {
			resultList.add(new StatusDto(
					(String) comment.get("STATUS_CD"),
					(String) comment.get("STATUS_NAME"),
					(LocalDateTime) comment.get("REGIST_DATE")));
		}
		return resultList;
	}

}
