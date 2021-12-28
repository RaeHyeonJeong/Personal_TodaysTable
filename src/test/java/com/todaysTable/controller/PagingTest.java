package com.todaysTable.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todaysTable.dao.BoardDao;
import com.todaysTable.vo.NoticeBoardImageVO;
import com.todaysTable.vo.NoticeBoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
                "file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
@WebAppConfiguration
public class PagingTest {
	
	@Autowired
	BoardDao<NoticeBoardVO, NoticeBoardImageVO> testDao;
	
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
		/*for( int i = 44;  i <= 1000000; i++ ) {
			NoticeBoardVO board= new NoticeBoardVO();
			board.setTitle( 1000001+ "번째 더미데이터");
			board.setContent(1000001+ "번째 더미데이터입니다.");
			board.setPassword("1111");
			
			testDao.insertNoticeBoard(board);
		}*/
		
	}
}
