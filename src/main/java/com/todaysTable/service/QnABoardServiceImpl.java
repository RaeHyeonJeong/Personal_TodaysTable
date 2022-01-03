package com.todaysTable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.Pagination;
import com.todaysTable.dao.BoardDao;
import com.todaysTable.func.AjaxFileUploader;
import com.todaysTable.vo.QnABoardImageVO;
import com.todaysTable.vo.QnABoardVO;

@Service
public class QnABoardServiceImpl implements BoardService<QnABoardVO, QnABoardImageVO> {

	@Autowired
	BoardDao<QnABoardVO, QnABoardImageVO> dao;

	@Autowired
	AjaxFileUploader ajaxFileUploader;

	// 게시판 종류 확인
	@Override
	public String getBoard() {
		return "QnA";
	}

	// 전체 게시물 개수
	@Override
	public int totalBoardList() {
		return dao.totalBoardList();
	}

	// <페이징처리> 게시물 리스트
	@Override
	public List<QnABoardVO> pagingBoardList(Pagination pagination) {
		return dao.pagingListAllBoard(pagination);
	}

	// 게시물 등록
	@Override
	public void insertBoard(QnABoardVO vo) {

		vo.setContent(vo.getContent().replace("\r\n", "<br>"));
		dao.insertBoard(vo);

		ArrayList<String> list = ajaxFileUploader.getListInstance();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			dao.insertBoardImage(list.get(i));
		}
		ajaxFileUploader.getListInstance().clear();
	}

	// 게시물 수정
	@Override
	public void updateBoard(QnABoardVO vo) {
		vo.setContent(vo.getContent().replace("\r\n", "<br>"));
		dao.updateBoard(vo);
	}

	// 게시물 삭제
	@Override
	public void deleteBoard(int notice_no) {
		dao.deleteBoard(notice_no);
	}

	// 게시물 내용 상세 이동
	@Override
	public QnABoardVO detailBoard(int notice_no) {
		QnABoardVO vo = dao.deatilBoard(notice_no);
		vo.setContent(vo.getContent().replace("<br>", "\r\n"));
		return vo;
	}

	// 조회수 증가
	@Override
	public void updateHits(int notice_no) {
		dao.updateHits(notice_no);
	}

	// 게시물 해당 이미지 조회
	@Override
	public List<QnABoardImageVO> selectBoardImage(int notice_no) {
		List<QnABoardImageVO> list = dao.selectBoardImage(notice_no);

		for (int i = 0; i < list.size(); i++) {
			String path = list.get(i).getImage_path();

			int beginIndex = path.lastIndexOf("resources");
			int endIndex = path.length();
			path = path.substring(beginIndex, endIndex);
			path = path.replace("\\\\", "/");

			list.get(i).setImage_path(path);
		}

		System.out.println("list 사이즈 " + list.size());

		return list;
	}

	// 이미지 파일 업로드
	@Override
	public void uploadFile(MultipartFile[] uploadFile) {
		String forderName = "noticeImg";

		for (MultipartFile multipartFile : uploadFile) {
			try {
				System.out.println("name : " + multipartFile.getOriginalFilename());

				ajaxFileUploader.uploadFile(multipartFile, forderName, ajaxFileUploader.getListInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 이미지 파일 삭제
	@Override
	public void deleteFileAll(MultipartFile[] uploadFile) {
		ajaxFileUploader.deleteFlieAll(ajaxFileUploader.getListInstance());
	}
	
	

}
