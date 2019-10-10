package com.provise.birthday.message.util;

import java.io.File;

public class FileUtil {

	public static String getPathOfImage() {
		File file = new File("birthdaypic.jpg");
		String path=file.getAbsolutePath();
		System.out.println("path of File :: "+path);
		return path;
	}
	public static void main(String[] args) {
		getPathOfImage();
	}
	
}

