package com.todaysTable.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todaysTable.common.BoardCriteria;
import com.todaysTable.vo.NoticeBoardImageVO;
import com.todaysTable.vo.NoticeBoardVO;

@Repository
public class NoticeBoardDaoImpl implements BoardDao<NoticeBoardImageVO> {

	@Autowired
	SqlSessionTemplate sqlSession;

	// 전체 게시물 개수
	@Override
	public int totalBoardList() {
		return sqlSession.selectOne("boardMapper.totalNoticeBoardList");
	}

	// 페이징 처리 게시물 전체 리스트
	@Override
	public List<Map<String, Object>> pagingListAllBoard(BoardCriteria boardCriteria) {
		return sqlSession.selectList("boardMapper.selectNoticeBoardListPaging", boardCriteria);

	}

	// 게시물 등록
	@Override
	public void insertBoard(Map<String, Object> paramMap) {
		sqlSession.insert("boardMapper.insertNoticeBoard", paramMap);
	}

	// 게시물 수정
	@Override
	public void updateBoard(Map<String, Object> paramMap) {
		sqlSession.update("boardMapper.updateNoticeBoard", paramMap);

	}

	// 게시물 삭제
	@Override
	public void deleteBoard(int notice_no) {
		sqlSession.delete("boardMapper.deleteNoticeBoard", notice_no);

	}

	// 게시물 상세 내용 조회
	@Override
	public Map<String, Object> deatilBoard(int notice_no) {
		return sqlSession.selectOne("boardMapper.selectNoticeBoard", notice_no);
	}

	// 조회수 증가
	@Override
	public void updateHits(int notice_no) {
		sqlSession.update("boardMapper.updateHitsNoticeBoard", notice_no);
	}

	// 이미지 삽입
	@Override
	public void insertBoardImage(String path) {
		sqlSession.insert("boardMapper.insertNoticeImage", path);

	}

	// 이미지 조회
	@Override
	public List<NoticeBoardImageVO> selectBoardImage(int notice_no) {
		return sqlSession.selectList("boardMapper.selectNoticeImage", notice_no);
	}

	// 사용자 memb_no 조회
	public int selectMemberNumber(String id) {
		return sqlSession.selectOne("boardMapper.selectMemberNo", id);
	}

}
