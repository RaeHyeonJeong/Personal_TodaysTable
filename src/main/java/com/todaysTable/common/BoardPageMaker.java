package com.todaysTable.common;

import lombok.Getter;

@Getter
public class BoardPageMaker {
	private int totalCount; // 전체 게시물 갯수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	private int totalEndPage; // 전체게시물 마지막 페이지 번호
	private boolean prev; // 이전 페이지목록
	private boolean next; // 다음 페이지목록
	
	private int displayPageNum = 10; // 표시할 페이징 개수
	
	private  BoardCriteria boardCriteria;
	
	public void setPagination(BoardCriteria boardCriteria) {
		this.boardCriteria = boardCriteria;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount; // 총 게시물 개수 세팅
		setTotalEndPage(totalCount); // 전체 마지막 페이지 세팅
		calcData(); // 페이지 데이터 계산
	}
	
	// 전체 게시물에 대한 마지막 페이지 세팅
	public void setTotalEndPage(int totalCount) {
		// 총 개시물 개수 / boardCriteria< 현재 화면에 표시할 개시물 개수 >
		this.totalEndPage = (int)(Math.ceil(totalCount / (double)boardCriteria.getPerPageNum()));
	}
	
	// 페이지 데이터 계산
	private void calcData() {
		// 현재 화면에서의 마지막 페이징 번호 
		// = ( boardCriteria< 현재 페이지 번호 > / 표시할 페이징 개수 ) * 표시할 페이징 개수
		endPage = (int)(Math.ceil(boardCriteria.getPage() / (double) displayPageNum) * displayPageNum); 
		
		// 현재 화면에서의 시작 페이징 번호 
		// = (현재 화면에서의 마지막 페이징 번호 - 표시할 페이징 개수 ) + 1 
		startPage = (endPage - displayPageNum) + 1; 
		
		// 마지막 페이징 번호 제한
		if(endPage > totalEndPage) { 
			endPage = totalEndPage;
		}
		
		prev = startPage > 1 ? true : false; // 이전 페이징 검사
		next = endPage != totalEndPage ? true : false; // 다음 페이징 검사
	}
}
