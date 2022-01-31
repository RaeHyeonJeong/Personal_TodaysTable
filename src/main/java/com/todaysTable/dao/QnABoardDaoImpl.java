package com.todaysTable.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todaysTable.common.BoardCriteria;
import com.todaysTable.vo.QnABoardImageVO;

@Repository
public class QnABoardDaoImpl implements BoardDao<QnABoardImageVO>, BoardReplyDao{

	@Autowired
	SqlSessionTemplate sqlSession;

	// ***** BOARD DAO INTERFACE *****
	
	// 전체 게시물 개수
	@Override
	public int totalBoardList() {
		return sqlSession.selectOne("boardMapper.totalQnABoardList");
	}

	// 페이징 처리 게시물 전체 리스트
	@Override
	public List<Map<String, Object>> pagingListAllBoard(BoardCriteria boardCriteria) {
		return sqlSession.selectList("boardMapper.selectQnABoardListPaging", boardCriteria);
		
	}

	// 게시물 등록
	@Override
	public void insertBoard(Map<String, Object> paramMap) {
		sqlSession.insert("boardMapper.insertQnABoard", paramMap);
	}

	// 게시물 수정
	@Override
	public void updateBoard(Map<String, Object> paramMap) {
		sqlSession.update("boardMapper.updateQnABoard", paramMap);

	}

	// 게시물 삭제
	@Override
	public void deleteBoard(int qna_no) {
		sqlSession.delete("boardMapper.deleteQnABoard", qna_no);
	}

	// 게시물 상세 내용 조회
	@Override
	public Map<String, Object> deatilBoard(int qna_no) {
		return sqlSession.selectOne("boardMapper.selectQnABoard", qna_no);
	}

	// 조회수 증가
	@Override
	public void updateHits(int qna_no) {
		sqlSession.update("boardMapper.updateHitsQnABoard", qna_no);
	}

	// 이미지 삽입
	@Override
	public void insertBoardImage(String path) {
		sqlSession.insert("boardMapper.insertQnAImage", path);
	}

	// 이미지 조회
	@Override
	public List<QnABoardImageVO> selectBoardImage(int qna_no) {
		return sqlSession.selectList("boardMapper.selectQnAImage", qna_no);
	}
	
	// 사용자 memb_no 조회
	public int selectMemberNumber(String id) {
		return sqlSession.selectOne("boardMapper.selectMemberNo", id);
	}

	// ***** REPLY DAO INTERFACE *****
	
	// 
	@Override
	public List<Map<String, Object>> selectReply() {
		
		return null;
	}
	
	
	@Override
	public void createReplyMain() {
		
		
	}

	@Override
	public void createReplySub() {
		
		
	}

	@Override
	public void deleteReply() {
		
		
	}

	@Override
	public void updateReply() {
		
		
	}

	
	
}
