package com.todaysTable.service;

import java.util.List;
import java.util.Map;

public interface BoardReplyService {
	
	// 댓글 리스트 조회
	public List<Map<String, Object>> selectReply();

	public void createReplyMain();

	public void createReplySub();

	// 댓글 삭제
	public void deleteReply();

	// 댓글 수정
	public void updateReply();
}
