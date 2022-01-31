package com.todaysTable.common;

import lombok.ToString;

@ToString
public class BoardCriteria {
	private int page; // 페이지 번호
	private int perPageNum; // 페이지에 표시할 게시물 개수
	
	// default 생성자 
	public BoardCriteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	// 페이지 번호 Setter
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	// 페이지 번호 Getter 
		public int getPage() {
			return page;
		}
	
	// 페이지에 표시할 게시물 개수 Setter
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	// 페이지에 표시할 게시물 개수 Getter
	public int getPerPageNum() {
		return perPageNum;
	}
	
	// 페이지별 마지막 게시물 계산
	public int getEndBoardNum() {
		return this.page * this.perPageNum ;
	}
	
	// 페이지별 시작 게시물 계산
	public int getStartBoardNum() {
		if(page == 1) {
			return this.page;
		} else {
			return (page-1) * perPageNum + 1;
		}
	}
	
}
