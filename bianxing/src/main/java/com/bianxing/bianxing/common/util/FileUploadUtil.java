package com.bianxing.bianxing.common.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	
	private static final Logger LOGGER = Logger.getLogger(FileUploadUtil.class);

	public static String saveFile(MultipartFile file, String storagePath) throws FileNotFoundException, IOException {
		if (file == null){
			throw new FileNotFoundException("file not found");
		}
		// 获取文件名称
		String originalFilename = file.getOriginalFilename();
		LOGGER.info("fileName : " + originalFilename);

		// 获取文件后缀名
		String suff = originalFilename.substring(originalFilename.lastIndexOf("."));
		String fileName = System.currentTimeMillis() + "" + ((int) (Math.random() * 900) + 100) + suff;
		String path = storagePath + fileName;

		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
		LOGGER.info("file save to :" + path);
		
		return fileName;
	}
	
	/**
	 * 保存APK文件
	 * @param file
	 * @param storagePath
	 * @param version
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String saveApk(MultipartFile file, String storagePath, String version) throws FileNotFoundException, IOException {
		if (file == null){
			throw new FileNotFoundException("file not found");
		}
		
		String fileName = "Tips-"+version+".apk";

		String path = storagePath + fileName;

		FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(path));
		LOGGER.info("file save to :" + path);
		
		return fileName;
	}

}
