package com.todaysTable.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

@Component
public class BoardServiceFactory {

	// boardService를 담는 MAP
	private final Map<String, BoardService<? , ?>> boardServices = new HashMap<>();
	
	// 생성자 주입 (	BoardService 상속 bean 주입 )
	public BoardServiceFactory(List<BoardService<? , ?>> boardServices) {
		// BoardService를 상속받는 bean이 없을 경우 IllegalArgumentException 발생 
		if(CollectionUtils.isEmpty(boardServices)) {
			throw new IllegalArgumentException("해당 게시판을 찾을 수 없음.");
		}
		
		for(BoardService<? , ?> boardService : boardServices) {
			this.boardServices.put(boardService.getBoard(), boardService);
		}
	}
	
	// boardName에 맞는 bean 리턴
	public BoardService<? , ?> getService(String boardName) {
		return boardServices.get(boardName);
	}
}
