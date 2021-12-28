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
	
	private  Pagination pagination;
	
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount; // 총 게시물 개수 세팅
		setTotalEndPage(totalCount); // 전체 마지막 페이지 세팅
		calcData(); // 페이지 데이터 계산
	}
	
	// 전체 게시물에 대한 마지막 페이지 세팅
	public void setTotalEndPage(int totalCount) {
		this.totalEndPage = (int)(Math.ceil(totalCount / (double)pagination.getPerPageNum()));
	}
	
	// 페이지 데이터 계산
	private void calcData() {
		endPage = (int)(Math.ceil(pagination.getPage() / (double) displayPageNum) * displayPageNum); // 현재 마지막 페이징 번호
		startPage = (endPage - displayPageNum) + 1; // 현재 시작 페이징 번호
		
		if(endPage > totalEndPage) { // 마지막 페이징 번호 제한
			endPage = totalEndPage;
		}
		
		prev = startPage > 1 ? true : false; // 이전 페이징 검사
		next = endPage != totalEndPage ? true : false; // 다음 페이징 검사
	}
}
