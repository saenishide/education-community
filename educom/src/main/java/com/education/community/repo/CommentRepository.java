package com.education.community.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.education.community.dto.CommentDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

	private final JdbcTemplate jdbcTemplate;

	public List<CommentDto> getCommentByTopic(int topicId) {
		String sql = "SELECT COMMENT_ID, TOPIC_ID, USER_ID, TEXT_DATA, ACTIVE, REGIST_DATE FROM createdb.comment WHERE ACTIVE = TRUE AND TOPIC_ID = '"+ topicId + "';";
		List<Map<String, Object>> commentList = jdbcTemplate.queryForList(sql);
		List<CommentDto> resultList = new ArrayList<>();
		for (Map<String, Object> comment : commentList) {
			resultList.add(new CommentDto(
					(int) comment.get("COMMENT_ID"),
					(int) comment.get("TOPIC_ID"),
					(String) comment.get("USER_ID"),
					(String) comment.get("TEXT_DATA"),
					(boolean) comment.get("ACTIVE"),
					(LocalDateTime) comment.get("REGIST_DATE")));
		}
		return resultList;
	}

}
