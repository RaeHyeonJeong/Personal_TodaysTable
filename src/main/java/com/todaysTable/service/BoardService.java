package com.todaysTable.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.Pagination;

public interface BoardService<T1, T2> {
	// 게시판 종류 확인
	public String getBoard();
	
	// 전체 게시물 개수
	public int totalBoardList();

	// <페이징 처리> 게시물 리스트
	public List<T1> pagingBoardList(Pagination pagination);

	// 게시물 등록
	public void insertBoard(T1 vo);

	// 게시물 수정
	public void updateBoard(T1 vo);

	// 게시물 삭제
	public void deleteBoard(int no);

	// 게시물 내용 상세 이동
	public T1 detailBoard(int no);

	// 조회수 증가
	public void updateHits(int no);

	// 게시물 해당 이미지 조회
	public List<T2> selectBoardImage(int no);

	// 이미지 파일 업로드
	public void uploadFile(MultipartFile[] uploadFile);

	// 이미지 파일 삭제
	public void deleteFileAll(MultipartFile[] uploadFile);

}
