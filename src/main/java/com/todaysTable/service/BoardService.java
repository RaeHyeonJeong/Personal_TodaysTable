package com.todaysTable.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.BoardCriteria;

public interface BoardService<T1> {

	// 게시판 종류 확인
	public String getBoard();

	// 전체 게시물 개수
	public int totalBoardList();

	// <페이징 처리> 게시물 리스트
	public List<Map<String, Object>> pagingBoardList(BoardCriteria boardCriteria);

	// 게시물 등록
	public void insertBoard(Map<String, Object> paramMap, String id);

	// 게시물 내용 상세 이동
	public Map<String, Object> detailBoard(int no);
	
	// 조회수 증가
	public void updateHits(int no);

	// 게시물 수정
	public void updateBoard(Map<String, Object> paramMap);

	// 게시물 삭제
	public void deleteBoard(int no);

	// 게시물 이미지 조회
	public List<T1> selectBoardImage(int no);

	// 이미지 파일 업로드
	public void uploadFile(MultipartFile[] uploadFile);

	// 이미지 파일 삭제
	public void deleteFileAll(MultipartFile[] uploadFile);
	
}
