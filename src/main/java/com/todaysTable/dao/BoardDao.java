package com.todaysTable.dao;

import java.util.List;

import com.todaysTable.common.Pagination;

public interface BoardDao<T1, T2> {
	
	// 게시물 등록 
	public void insertNoticeBoard(T1 vo);
	// 게시물 수정 
	public void updateNoticeBoard(T1 vo);
	// 게시물 삭제
	public void deleteNoticeBoard(int no);
	// 게시물 상세 내용 조회
	public T1 deatilNoticeBoard(int no);
	// 조회수 증가
	public void updateHits(int no);
	//이미지 삽입
	public void insertNoticeBoardImage(String path);
	//이미지 조회
	public List<T2> selectNoticeBoardImage(int no);
	 
	// 전체 게시물 개수
	public int totalNoticeBoardList();
	
	// 페이징 처리 게시물 전체 목록
	public List<T1> pagingListAllBoard(Pagination pagination);
	
}
