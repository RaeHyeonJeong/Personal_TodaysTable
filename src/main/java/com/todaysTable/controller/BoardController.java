package com.todaysTable.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.BoardPageMaker;
import com.todaysTable.common.Pagination;
import com.todaysTable.service.BoardService;
import com.todaysTable.service.BoardServiceFactory;
import com.todaysTable.service.NoticeBoardServiceImpl;
import com.todaysTable.vo.NoticeBoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardServiceFactory factory;

	// <페이징 처리> 게시물 리스트 + 해당 게시판 이동
	@RequestMapping(value = "pagingBoard.do", method = RequestMethod.GET)
	public String noticeBoardPagingListAction(@RequestParam("board") String board, Model model, Pagination pagination) {

		BoardService service = factory.getService(board);
		
		BoardPageMaker boardPageMaker = new BoardPageMaker();
		boardPageMaker.setPagination(pagination);
		boardPageMaker.setTotalCount(service.totalBoardList());
		
		model.addAttribute("board", service.getBoard());
		model.addAttribute("list", service.pagingBoardList(pagination));
		model.addAttribute("boardPageMaker", boardPageMaker);
		
		if(board.equals("notice")) {
			return "WEB-INF/views/boardNotice";
		} else if(board.equals("QnA")) {
			return "WEB-INF/views/boardQnA";
		} else
			return "null";
	}

	// BOARD 게시물 작성 페이지 이동
	@RequestMapping(value = "boardWriteMove.do")
	public String writeBoardMoveAction(@RequestParam("board") String board, Model model) {
		model.addAttribute("board", board);
		return "WEB-INF/views/boardWrite";
	}

	// BOARD 게시물 수정 페이지 이동
	@RequestMapping(value = "boardUpdateMove.do")
	public String updateBoardMoveAction(Model model, int notice_no) {
		model.addAttribute("info", noticeService.detailBoard(notice_no));
		return "WEB-INF/views/boardUpdate";
	}

	// BOARD 게시물 등록
	@RequestMapping(value = "insertBoard.do", method = RequestMethod.POST)
	public String noticeBoardInsertAction(NoticeBoardVO vo) {
		
		noticeService.insertBoard(vo);
		return "redirect:/pagingBoard.do";
	}

	// BOARD 게시물 수정
	@RequestMapping(value = "updateBoard.do", method = RequestMethod.POST)
	public String noticeBoardUpdateAction(HttpServletRequest req, NoticeBoardVO vo, int notice_no) {
		noticeService.updateBoard(vo);
		String prePage = req.getParameter("prePage");
		return "redirect:/boardDetail.do?notice_no=" + notice_no + "&prePage=" + prePage;
	}

	// BOARD 게시물 삭제
	@RequestMapping(value = "deleteBoard.do")
	public String noticeBoardDeleteAction(int notice_no) {
		noticeService.deleteBoard(notice_no);
		return "redirect:/pagingBoard.do";
	}

	// BOARD 게시물 상세 정보 페이지 이동
	@RequestMapping(value = "boardDetail.do", method = RequestMethod.GET)
	public String noticeBoardDetailAction(Model model, int notice_no) {
		noticeService.updateHits(notice_no);
		model.addAttribute("info", noticeService.detailBoard(notice_no));
		model.addAttribute("img", noticeService.selectBoardImage(notice_no));
		return "WEB-INF/views/boardNoticeContentDetail";
	}

	// BOARD 게시물 이미지 등록
	@RequestMapping(value = "uploadImgAjax.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void uploadAjax(MultipartFile[] uploadFile) {
		noticeService.uploadFile(uploadFile);
	}

	// BOARD 게시물 이미지 삭제
	@RequestMapping(value = "deleteImgAllAjax.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void deleteAllAjax(MultipartFile[] uploadFile) {
		noticeService.deleteFileAll(uploadFile);
	}

}
