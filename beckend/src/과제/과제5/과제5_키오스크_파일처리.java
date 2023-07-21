package 과제.과제5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크_파일처리 {
	
	public static void main(String[] args) throws IOException {

				
		
		/* ----------- */
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/과제/과제5/재고파일.txt" ; //파일경로 변수에 저장
			FileOutputStream fileOutputStream = new FileOutputStream( filePath , true); // 파일 출력객체
			FileInputStream fileInputStream = new FileInputStream( filePath ); //파일 입력객체
			File file = new File( filePath ); // 파일정보 객체 (용량 , 경로 , 파일명 등등 ) 메소드 제공
			
			//----------파일내 제품정보 -------> 배열로 옮기기----------//
			byte[] inByteArray = new byte[ (int)file.length() ];//파일의 용량만큼의 배열 선언
			fileInputStream.read(inByteArray); // 읽어온 바이트를 바이트배열에 저장
			String fileInfo = new String(inByteArray); //바이트배열 --> 문자열 변환
				System.out.println(fileInfo);
			//----------파일내 제품정보 문자열---> 배열저장 ---------------------------------------------
			//1. 하나 문자열로 모든 제품의 문자열을 각 제품별로 분리
			String[] 재고관리 = fileInfo.split("\n"); System.out.println("재품별분리 : " + Arrays.toString(재고관리) );
			
			
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("-1:제품등록 0:결제");
				//2. 재고관리 배열에 있는 제품정보만 출력가능 하도록 출력
			for( int i = 0 ; i< 재고관리.length; i++) {
				if(!재고관리[i].equals("")) {
					String name = 재고관리[i].split(",")[0];
					int 재고 = Integer.parseInt(재고관리[i].split(",")[1]);//재고
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);//가격
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[3]);//바구니
					
					if(재고 == 0) {
						System.out.println((i+1)+":"+name+"[재고없음]");
					}
					else {
						System.out.println((i+1)+":"+name+"["+가격+"]");
					}
						
				}
			}
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			
			
			if( ch == -1 ) {//만약에 -1번을 입력했으면 제품등록 가능
				System.out.print("제품명 : "); String name = scanner.next();
				System.out.print("초기재고 : "); int 재고 = scanner.nextInt();
				System.out.println("가격 : "); int 가격 = scanner.nextInt();
												int 바구니 =0; // 바구니 0 부터 시작
												
				//2. 해당 변수들을 하나의 데이터구성 [제품구별 \n / 제품내 정보구분 ,]
				String outStr = name+","+재고+","+가격+","+바구니;
				
				//3. 파일에 내보내기 // 1. 파일출력 스트림 객체 2. 문자열 -> 바이트배열 변환 3. 바이트배열 내보내기	예외처리!!
				fileOutputStream.write(outStr.getBytes());
				
				System.out.println("안내) 제품등록 되었습니다.");
			}
			//---------------------선택한 제품 바구니담기----------------
			else if( ch > 0 && ch<=재고관리.length ) {
				System.out.println(재고관리[ch-1].split(",")[0]+"를 선택했습니다.");
				
				//1. 선택한 제품번호의 각 정보 호출
				String name = 재고관리[ch-1].split(",")[0]; // 제품명
				int 재고 = Integer.parseInt(재고관리[ch-1].split(",")[1] ); 
				int 가격 = Integer.parseInt(재고관리[ch-1].split(",")[2] ); 
				int 바구니= Integer.parseInt(재고관리[ch-1].split(",")[3] ); 
				
				//2. 재고가 0보다 크면 재고/바구니 증감/재고가 없으면 안내만
				if(재고 > 0) { 재고--; 바구니++; System.out.println(name+"재품을 담았습니다.");}
				else {System.out.println(name + "제품의 재고가 부족합니다.");}
				
				//3.배열 상태 업데이트
				재고관리[ch-1] = name+","+재고+","+가격+","+바구니;
				
				//4. 파일에 내보내기 // 파일에 제품등의 변화가 있으므로 업데이트 // 현재 재고관리배열 상태를 파일의 저장
				String outStr = "";
				for(int i=0; i<재고관리.length ; i++) {
					outStr += 재고관리[i].split(",")[0]+","+재고관리[i].split(",")[1]+
							","+재고관리[i].split(",")[2]+","+재고관리[i].split(",")[3]+"\n";
				}
				
				//5. 재고관리 배열을 하나의 문자열로 변환된 문자열을 바이트 배열로 변환후 내보내기
				//이어쓰기X
				FileOutputStream fileOutputStream2 = new FileOutputStream(filePath); // 이어쓰기X
				fileOutputStream.write(outStr.getBytes() );
				
			}
			else if( ch == 0) {
			
				System.out.println(Arrays.toString(재고관리) );
				System.out.printf("%10s %10s %10s \n" , "제품명" ,  "수량" , "가격" );
				
				for(int i = 0 ; i<재고관리.length ; i++) {

					int 바구니 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);
					String name = 재고관리[i].split(",")[3];
					if( 바구니 > 0 ) {
					System.out.printf("%10s %10s %10s \n" , 재고관리[i] ,  바구니 , 바구니*가격 );
					}
				}
			}
			
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

