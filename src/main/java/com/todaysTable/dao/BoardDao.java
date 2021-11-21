package com.todaysTable.dao;

import java.util.List;

import com.todaysTable.vo.NoticeBoardImageVO;
import com.todaysTable.vo.NoticeBoardVO;

public interface BoardDao<T1, T2> {
	public List<T1> selectAllBoard();
	// 게시물 전체 목록
	public void insertNoticeBoard(T1 vo);
	// 게시물 등록 
	public void updateNoticeBoard(T1 vo);
	// 게시물 수정 
	public void deleteNoticeBoard(int no);
	// 게시물 삭제
	public T1 deatilNoticeBoard(int no);
	// 조회수 증가
	public void updateHits(int no);
	//이미지 삽입
	public void insertNoticeBoardImage(String path);
	//이미지 조회
	public List<T2> selectNoticeBoardImage(int no);
	 
}
