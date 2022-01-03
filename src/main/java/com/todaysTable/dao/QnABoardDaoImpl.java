package com.todaysTable.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.todaysTable.common.Pagination;
import com.todaysTable.vo.QnABoardImageVO;
import com.todaysTable.vo.QnABoardVO;

@Repository
public class QnABoardDaoImpl implements BoardDao<QnABoardVO, QnABoardImageVO> {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int totalBoardList() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QnABoardVO> pagingListAllBoard(Pagination pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(QnABoardVO vo) {
		sqlSession.insert("boardMapper.insertQnABoard", vo);
	}

	@Override
	public void updateBoard(QnABoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QnABoardVO deatilBoard(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHits(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertBoardImage(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QnABoardImageVO> selectBoardImage(int no) {
		// TODO Auto-generated method stub
		return null;
	}

}
