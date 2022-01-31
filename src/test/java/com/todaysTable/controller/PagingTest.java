package com.todaysTable.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.todaysTable.dao.QnABoardDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
                "file:src/main/webapp/WEB-INF/spring/**/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/**/servlet-context.xml"})
@WebAppConfiguration
public class PagingTest {
	
	@Autowired
	QnABoardDaoImpl testDao = new QnABoardDaoImpl();
	
	@Test
	public void testListPaging() throws Exception {
		 
		/*Pagination pagination = new Pagination();
		pagination.setPage(3);
		pagination.setPerPageNum(20);
		
		List<Map<String, Object>> boards = testDao.pagingListAllBoard(pagination);
				
		for(Map<String, Object> board : boards) {
				System.out.println(board.get("TITLE"));
			
		}
		
		System.out.println("테스트 종료");*/
		
		
		
		// 더미 데이터 생성 
		for( int i = 33;  i <= 5000000; i++ ) {
			
			Map<String, Object> map = new HashMap<>();
			map.put("title", i +  "번째 질문");
			map.put("content", i + "번째 질문입니다.");
			map.put("password", 1111);
			map.put("memb_no", 13);
			
			testDao.insertBoard(map);
		}
	}
}
