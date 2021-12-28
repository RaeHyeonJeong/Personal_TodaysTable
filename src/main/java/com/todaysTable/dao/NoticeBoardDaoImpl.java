package com.todaysTable.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todaysTable.common.Pagination;
import com.todaysTable.vo.NoticeBoardImageVO;
import com.todaysTable.vo.NoticeBoardVO;

@Repository
public class NoticeBoardDaoImpl implements BoardDao<NoticeBoardVO, NoticeBoardImageVO> {

	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void insertNoticeBoard(NoticeBoardVO vo) {
		sqlSession.insert("boardMapper.insertNoticeBoard", vo);
	}

	@Override
	public void updateNoticeBoard(NoticeBoardVO vo) {
		sqlSession.update("boardMapper.updateNoticeBoard", vo);

	}

	@Override
	public void deleteNoticeBoard(int notice_no) {
		sqlSession.delete("boardMapper.deleteNoticeBoard", notice_no);

	}

	@Override
	public NoticeBoardVO deatilNoticeBoard(int notice_no) {
		return sqlSession.selectOne("boardMapper.selectNoticeBoard", notice_no);
	}

	@Override
	public void updateHits(int notice_no) {
		sqlSession.update("boardMapper.updateHits", notice_no);
	}

	@Override
	public void insertNoticeBoardImage(String path) {
		sqlSession.insert("boardMapper.insertNoticeImage", path);

	}

	@Override
	public List<NoticeBoardImageVO> selectNoticeBoardImage(int notice_no) {
		return sqlSession.selectList("boardMapper.selectNoticeImage", notice_no);
	}

	// 전체 게시물 개수
	@Override
	public int totalNoticeBoardList() {
		return sqlSession.selectOne("boardMapper.totalNoticeList");
	}

	// 페이징 처리 게시물 전체 리스트
	@Override
	public List<NoticeBoardVO> pagingListAllBoard(Pagination pagination) {
		return sqlSession.selectList("boardMapper.selectBoardListPaging", pagination);
	}

}
