package service;

import java.io.File;

public class FileService {

	// 1. 파일 삭제
	public static boolean fileDelete( String filepath ) {
		
		// 1. 파일 경로의 파일 객체 선언 [ 다양한 메소드 제공 하니까 ]
		File file = new File(filepath);
		
		if( file.exists()) {
			file.delete();
			return true;
		}
		
		return false;
	}
	
	
}// class end

/*
 
 	File 클래스
 		메소드
 			1. .length()	: 파일의 용량[바이트] 호출
 			2. .exists()	: 경로상의 파일 존재 여부 있으면 true/false
 			3. .delete()	: 경로상의 파일 삭제
  
*/
 