package com.todaysTable.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.BoardPageMaker;
import com.todaysTable.common.BoardCriteria;
import com.todaysTable.service.BoardService;
import com.todaysTable.service.BoardServiceFactory;

@Controller
public class BoardController {

	@Autowired
	private BoardServiceFactory factory;

	// <페이징 처리> 게시물 리스트 + 해당 게시판 이동
	@RequestMapping(value = "pagingBoard.do", method = RequestMethod.GET)
	public String boardPagingListAction(@RequestParam("board") String board, Model model, BoardCriteria boardCriteria) {

		BoardService<?> service = factory.getService(board);
		
		BoardPageMaker boardPageMaker = new BoardPageMaker();
		boardPageMaker.setPagination(boardCriteria);
		boardPageMaker.setTotalCount(service.totalBoardList()); // 게시물의 총 개수 세팅

		model.addAttribute("board", board);
		model.addAttribute("list", service.pagingBoardList(boardCriteria));
		model.addAttribute("boardPageMaker", boardPageMaker);

		if (board.equals("notice")) {
			return "WEB-INF/views/boardNotice"; // 공지사항으로 이동
		} else if (board.equals("QnA")) {
			return "WEB-INF/views/boardQnA"; // QnA로 이동
		} else
			return "null";
	}

	// BOARD 게시물 작성 페이지 이동
	@RequestMapping(value = "boardWriteMove.do", method = RequestMethod.GET)
	public String MoveWriteBoardAction(@RequestParam("board") String board, Model model) {
		model.addAttribute("board", board);
		return "WEB-INF/views/boardWrite";
	}

	// BOARD 게시물 등록
	@RequestMapping(value = "insertBoard.do", method = RequestMethod.POST)
	public String boardInsertAction(HttpServletRequest request, @RequestParam("board") String board, @RequestParam Map<String, Object> paramMap) {
		BoardService<?> service = factory.getService(board);
		HttpSession session = request.getSession(false);
		
		service.insertBoard(paramMap, (String)session.getAttribute("id"));
		return "redirect:/pagingBoard.do?board=" + board;
	}

	// BOARD 게시물 상세 정보 페이지 이동
	@RequestMapping(value = "boardDetail.do", method = RequestMethod.GET)
	public String boardDetailAction(@RequestParam("board") String board, @RequestParam("board_no") int board_no, Model model) {
		BoardService<?> service = factory.getService(board);
		service.updateHits(board_no);
		
		model.addAttribute("board", board);
		model.addAttribute("board_no", board_no);
		model.addAttribute("info", service.detailBoard(board_no));
		model.addAttribute("img", service.selectBoardImage(board_no));
		
		return "WEB-INF/views/boardContentDetail";
	}

	// BOARD 게시물 수정 페이지 이동

	@RequestMapping(value = "boardUpdateMove.do", method = RequestMethod.GET)
	public String MoveUpdateBoardAction(@RequestParam("board") String board, @RequestParam("board_no") int board_no, Model model) {
		BoardService<?> service = factory.getService(board);
		
		model.addAttribute("board", board);
		model.addAttribute("board_no", board_no);
		model.addAttribute("info", service.detailBoard(board_no));
		return "WEB-INF/views/boardUpdate";
	}

	// BOARD 게시물 수정

	@RequestMapping(value = "updateBoard.do", method = RequestMethod.POST)
	public String boardUpdateAction(@RequestParam("board") String board, @RequestParam("board_no") int board_no, @RequestParam Map<String, Object> paramMap) {
		BoardService<?> service = factory.getService(board);
		service.updateBoard(paramMap);
		return "redirect:/boardDetail.do?board="+board+ "&board_no=" + board_no;
	}

	// BOARD 게시물 삭제

	@RequestMapping(value = "deleteBoard.do", method = RequestMethod.GET)
	public String noticeBoardDeleteAction(@RequestParam("board") String board, @RequestParam("board_no") int board_no) {
		BoardService<?> service = factory.getService(board);
		service.deleteBoard(board_no);
		return "redirect:/pagingBoard.do?board="+board;
	}
	
	// BOARD 게시물 이미지 등록

	@RequestMapping(value = "uploadImgAjax.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void uploadAjax(@RequestParam("board") String board, MultipartFile[] uploadFile) {
		BoardService<?> service = factory.getService(board);
		service.uploadFile(uploadFile);
	}

	// BOARD 게시물 이미지 등록 초기화

	@RequestMapping(value = "deleteImgAllAjax.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void deleteAllAjax(@RequestParam("board") String board, MultipartFile[] uploadFile) {
		BoardService<?> service = factory.getService(board);
		service.deleteFileAll(uploadFile);
	}
}
