package com.todaysTable.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.todaysTable.vo.NoticeBoardImageVO;
import com.todaysTable.vo.NoticeBoardVO;

public interface BoardService<T1, T2> {
	public List<T1> noticeBoardList();
	public void insertNoticeBoard(T1 vo);
	public void updateNoticeBoard(T1 vo);
	public void deleteNoticeBoard(int no);
	public T1 detailNoticeBoard(int no);
	public void updateHits(int no);
	public List<T2> selectNoticeImage(int no);
	public void uploadFile(MultipartFile[] uploadFile);
	public void deleteFileAll(MultipartFile[] uploadFile);
}
