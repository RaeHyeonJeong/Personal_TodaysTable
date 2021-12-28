package com.todaysTable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.BoardPageMaker;
import com.todaysTable.common.Pagination;
import com.todaysTable.service.BoardService;
import com.todaysTable.vo.NoticeBoardImageVO;
import com.todaysTable.vo.NoticeBoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService<NoticeBoardVO, NoticeBoardImageVO> noticeService;

	// <페이징 처리> 게시물 리스트 + 해당 게시판 이동
	@RequestMapping(value = "pagingNoticeBoard.do", method = RequestMethod.GET)
	public String noticeBoardPagingListAction(Model model, Pagination pagination) {

		BoardPageMaker boardPageMaker = new BoardPageMaker();
		boardPageMaker.setPagination(pagination);
		boardPageMaker.setTotalCount(noticeService.totalNoticeBoardList());

		model.addAttribute("list", noticeService.pagingNoticeBoardList(pagination));
		model.addAttribute("boardPageMaker", boardPageMaker);
		return "WEB-INF/views/boardNotice";
	}

	// BOARD 게시물 작성 페이지 이동
	@RequestMapping(value = "boardWriteMove.do")
	public String writeBoardMoveAction() {
		return "WEB-INF/views/boardWrite";
	}

	// BOARD 게시물 수정 페이지 이동
	@RequestMapping(value = "boardUpdateMove.do")
	public String updateBoardMoveAction(Model model, int notice_no) {
		model.addAttribute("info", noticeService.detailNoticeBoard(notice_no));
		return "WEB-INF/views/boardUpdate";
	}

	@RequestMapping(value = "insertNoticeBoard.do", method = RequestMethod.POST)
	public String noticeBoardInsertAction(NoticeBoardVO vo) {
		noticeService.insertNoticeBoard(vo);
		return "redirect:/pagingNoticeBoard.do";
	}

	@RequestMapping(value = "noticeBoardDetail.do", method = RequestMethod.GET)
	public String noticeBoardDetailAction(Model model, int notice_no) {
		noticeService.updateHits(notice_no);
		model.addAttribute("info", noticeService.detailNoticeBoard(notice_no));
		model.addAttribute("img", noticeService.selectNoticeImage(notice_no));
		return "WEB-INF/views/boardNoticeContentDetail";
	}

	@RequestMapping(value = "updateNoticeBoard.do", method = RequestMethod.POST)
	public String noticeBoardUpdateAction(NoticeBoardVO vo, int notice_no) {
		noticeService.updateNoticeBoard(vo);
		return "redirect:/noticeBoardDetail.do?notice_no=" + notice_no;
	}

	@RequestMapping(value = "deleteNoticeBoard.do")
	public String noticeBoardDeleteAction(int notice_no) {
		noticeService.deleteNoticeBoard(notice_no);
		return "redirect:/pagingNoticeBoard.do";
	}

	@RequestMapping(value = "uploadImgAjax.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void uploadAjax(MultipartFile[] uploadFile) {
		noticeService.uploadFile(uploadFile);
	}

	@RequestMapping(value = "deleteImgAllAjax.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void deleteAllAjax(MultipartFile[] uploadFile) {
		noticeService.deleteFileAll(uploadFile);
	}

}
