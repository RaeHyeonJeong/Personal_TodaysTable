package com.todaysTable.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnABoardVO {
	private int qna_no;
	private int memb_no;
	private String title;
	private String content;
	private String password;
	private String reg_date;
	private String admin_id;
	private int hits;
	private int ref;
	private int step;
	private int lev;
	private int pnum;
	private int reply;
}