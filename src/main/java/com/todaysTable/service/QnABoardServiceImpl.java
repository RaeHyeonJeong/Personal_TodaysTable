package com.todaysTable.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.todaysTable.common.BoardCriteria;
import com.todaysTable.dao.BoardDao;
import com.todaysTable.func.AjaxFileUploader;
import com.todaysTable.vo.QnABoardImageVO;

@Service
public class QnABoardServiceImpl implements BoardService<QnABoardImageVO> {

	@Autowired
	BoardDao<QnABoardImageVO> dao;

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
	public List<Map<String, Object>> pagingBoardList(BoardCriteria boardCriteria) {	
		List<Map<String, Object>> resultMap = dao.pagingListAllBoard(boardCriteria);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
		
		// SQL Date  변환
		for(Map<String, Object> row : resultMap) {
			date = (Date) row.get("REG_DATE");
			row.put("REG_DATE",  format.format(date));
		}
		
		return resultMap;
	}

	// 게시물 등록
	@Override
	public void insertBoard(Map<String, Object> paramMap, String id) {
		int memb_no = dao.selectMemberNumber(id); // 사용자 MEMBER_NO
		
		// 게시물 내용 줄바꿈 변환
		String value = ((String)paramMap.get("content")).replace("\r\n", "<br>");
		paramMap.put("content", value);
		paramMap.put("memb_no", memb_no);
		dao.insertBoard(paramMap);
		
		// 파일 업로드 ajax 처리
		ArrayList<String> list = ajaxFileUploader.getListInstance();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			dao.insertBoardImage(list.get(i));
		}
		ajaxFileUploader.getListInstance().clear();
	}

	// 게시물 내용 상세 이동
	@Override
	public Map<String, Object> detailBoard(int qna_no) {
		Map<String, Object> paramMap = dao.deatilBoard(qna_no);
		// 게시물 내용 줄바꿈 변환
		String value = ((String)paramMap.get("CONTENT")).replace("\r\n", "<br>");
		paramMap.put("CONTENT", value);
		
		return paramMap;
	}

	// 조회수 증가
	@Override
	public void updateHits(int qna_no) {
		dao.updateHits(qna_no);
	}

	// 게시물 수정
	@Override
	public void updateBoard(Map<String, Object> paramMap) {
		// 게시물 내용 줄바꿈 변환
		String value = ((String)paramMap.get("content")).replace("\r\n", "<br>");
		paramMap.put("content", value);
		paramMap.put("qna_no", paramMap.get("board_no"));
		
		dao.updateBoard(paramMap);
	}

	// 게시물 삭제
	@Override
	public void deleteBoard(int qna_no) {
		dao.deleteBoard(qna_no);
	}

	// 게시물 이미지 조회
	@Override
	public List<QnABoardImageVO> selectBoardImage(int qna_no) {
		List<QnABoardImageVO> list = dao.selectBoardImage(qna_no);

		// 이미지 로드 경로 설정
		for (int i = 0; i < list.size(); i++) {
			String path = list.get(i).getImage_path();

			int beginIndex = path.lastIndexOf("resources");
			int endIndex = path.length();
			path = path.substring(beginIndex, endIndex);
			path = path.replace("\\\\", "/");

			list.get(i).setImage_path(path);
		}
		return list;
	}

	// 이미지 파일 업로드
	@Override
	public void uploadFile(MultipartFile[] uploadFile) {
		String forderName = "QnAImg";

		for (MultipartFile multipartFile : uploadFile) {
			try {
				System.out.println("name : " + multipartFile.getOriginalFilename());

				ajaxFileUploader.uploadFile(multipartFile, forderName, ajaxFileUploader.getListInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 이미지 파일 업로드 초기화
	@Override
	public void deleteFileAll(MultipartFile[] uploadFile) {
		ajaxFileUploader.deleteFlieAll(ajaxFileUploader.getListInstance());
	}

	// ***** BoardReplyService *****
	
	
	
}
