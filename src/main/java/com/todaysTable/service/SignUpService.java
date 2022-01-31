package com.todaysTable.service;

import com.todaysTable.vo.MemberVO;

public interface SignUpService {
	// 회원가입
	public void memberJoinProcess(MemberVO vo);

	// 아이디 중복 체크
	public int IdCheck(String id);

	// 닉네임 중복 체크
	public int NickCheck(String nickname);
}
