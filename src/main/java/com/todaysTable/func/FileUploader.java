package com.todaysTable.func;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploader {

	// 파일명 중복 처리 메서드
	private String setUploadFileName(String originFileName, String path, String folderName) {
		UUID uuid = UUID.randomUUID();
		String resultName = path + folderName + uuid.toString() + "_" + originFileName;

		return resultName;
	}

	// 파일 업로드 처리
	public void multiFileUploader(MultipartFile file, String folderName) {

		String path = "C:\\Users\\a\\git\\Personal_TodaysTable\\src\\main\\webapp\\resources\\";
		folderName = folderName + "\\";

		String originFileName = file.getOriginalFilename();
		long fileSize = file.getSize();

		System.out.println("originFileName : " + originFileName);
		System.out.println("fileSize : " + fileSize);
		// 파일명 중복 처리
		String safeFile = setUploadFileName(originFileName, path, folderName);

		try {
			// 서버에 파일 저장
			file.transferTo(new File(safeFile));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
