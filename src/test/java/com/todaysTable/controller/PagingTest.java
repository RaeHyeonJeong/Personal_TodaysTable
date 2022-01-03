package com.todaysTable.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todaysTable.dao.BoardDao;
import com.todaysTable.vo.QnABoardImageVO;
import com.todaysTable.vo.QnABoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
                "file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
@WebAppConfiguration
public class PagingTest {
	
	@Autowired
	BoardDao<QnABoardVO, QnABoardImageVO> testDao;
	
	@Test
	public void testListPaging() throws Exception {
		 
		/*Pagination pagination = new Pagination();
		pagination.setPage(3);
		pagination.setPerPageNum(20);
		
		List<NoticeBoardVO> boards = testDao.pagingListAllBoard(pagination);
				
		for(NoticeBoardVO board : boards) {
			System.out.println(board.toString());
		}
		
		System.out.println("테스트 종료");*/
		
		// 더미 데이터 생성 
		for( int i = 2;  i <= 30; i++ ) {
			QnABoardVO board= new QnABoardVO();
			board.setTitle( i+ "번째 질문");
			board.setContent(i+ "번째 질문입니다.");
			board.setPassword("1111");
			
			testDao.insertBoard(board);
		}
		
	}
}
