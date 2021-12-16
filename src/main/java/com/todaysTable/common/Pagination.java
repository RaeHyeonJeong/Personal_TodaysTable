package com.todaysTable.common;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pagination {
	private int page; // 페이지 번호
	private int perPageNum; // 페이지당 보여지는 개수
	
	// default 생성자 
	public Pagination() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	// page Setter
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	// PerPageNum Setter
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
	}
	
	// 시작 페이지 계산
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
}
