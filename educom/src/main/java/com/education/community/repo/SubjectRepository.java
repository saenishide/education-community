package com.education.community.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.education.community.dto.SubjectDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SubjectRepository {

	private final JdbcTemplate jdbcTemplate;

	public List<SubjectDto> getAllSubject() {
		String sql = "SELECT SUBJECT_CD, SUBJECT_NAME, REGIST_DATE FROM createdb.subject ORDER BY SUBJECT_CD;";
		List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql);
		List<SubjectDto> resultList = new ArrayList<>();
		for (Map<String, Object> comment : commentList) {
			resultList.add(new SubjectDto(
					(String) comment.get("SUBJECT_CD"),
					(String) comment.get("SUBJECT_NAME"),
					(LocalDateTime) comment.get("REGIST_DATE")));
		}
		return resultList;
	}

}
