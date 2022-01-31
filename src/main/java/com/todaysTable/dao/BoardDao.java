package com.todaysTable.dao;

import java.util.List;
import java.util.Map;

import com.todaysTable.common.BoardCriteria;

public interface BoardDao<T1> {

	// 전체 게시물 개수
	public int totalBoardList();

	// 페이징 처리 게시물 전체 목록
	public List<Map<String, Object>> pagingListAllBoard(BoardCriteria boardCriteria);

	// 게시물 등록
	public void insertBoard(Map<String, Object> paramMap);

	// 게시물 수정
	public void updateBoard(Map<String, Object> paramMap);

	// 게시물 삭제
	public void deleteBoard(int no);

	// 게시물 상세 내용 조회
	public Map<String, Object> deatilBoard(int no);

	// 조회수 증가
	public void updateHits(int no);

	// 이미지 삽입
	public void insertBoardImage(String path);

	// 이미지 조회
	public List<T1> selectBoardImage(int no);
	
	// 사용자 memb_no 조회
	public int selectMemberNumber(String id);
	
	
}
