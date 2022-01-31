package com.todaysTable.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todaysTable.vo.MemberVO;

@Repository
public class SignupMemberDaoImpl implements SignupMemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void memberJoin(MemberVO vo) throws Exception {
		sqlSession.insert("memberMapper.memberJoin", vo);
	}

	@Override
	public int IdCheck(String id) {
		return sqlSession.selectOne("memberMapper.idCheck", id);
	}

	@Override
	public int NickCheck(String nickname) {
		return sqlSession.selectOne("memberMapper.nickCheck", nickname);
	}

}
