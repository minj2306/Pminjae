package 과제.과제6도서관;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class 주차요금정산기 {
	
	public static void main(String[] args) throws IOException {

		
		
		boolean btn = true;
		
		
		while (btn) {
			
			Scanner scanner = new Scanner(System.in);
			String filePath = "./src/과제/과제6도서관/주차정산.txt";
			FileOutputStream fileOutputStream = new FileOutputStream(filePath , true);
			FileInputStream fileInputStream = new FileInputStream(filePath);
			File file = new File(filePath);
			
			//파일 불러오기
			byte[] parKing = new byte[(int)file.length()];
			fileInputStream.read(parKing);
			String parkingInfo = new String(parKing);
			
			String[] PcarList = parkingInfo.split("\n");//줄바꾼걸로 쪼개기
			
			System.out.println( parkingInfo );//저장된거 확인
			
			System.out.println("-----------------주차요금 정산기------------\n");
			System.out.println("1.입차신청 | 2.요금확인 | 3.출차하기 | 4.관리자메뉴 | 5.종료하기\n");
			System.out.println("-----------------------------------------");
			System.out.print("메뉴를 선택하세요>>>>");
			
			int ch = scanner.nextInt();
			
			if( ch == 1  ) {//if 1 시작
				
				System.out.print("차량 번호를 입력해주세요 ex)가1234>>>>");
				String carSave = scanner.next();
				System.out.println("등록된 차량번호 : "+ carSave );
				
				LocalTime now = LocalTime.now();
				int hour = now.getHour();
				int minute = now.getMinute();
				int second = now.getSecond();
				System.out.println("입차시간 : "+hour+" 시 "+minute+" 분 "+second+" 초" );
				System.out.print("등록하시겠습니까?\n1.예 2.아니오 : "); int btn2 = scanner.nextInt();
				
				if(btn2==1) {
					
					System.out.println(carSave + "차량등록되었습니다.");
					carSave += "-"+hour+"-"+minute+"-"+second+"\n";
					byte[] carlist = carSave.getBytes();//바이트로 변환
					fileOutputStream.write(carlist);//변환한거 저장
					
				}
				else {System.out.println("초기화면으로 돌아갑니다.");}
			}//if1 끝
			
			if( ch == 2  ) {
				System.out.print("확인할 차량번호를 입력해주세요 ex)가1234>>>>");
				String carChack = scanner.next();
				
				LocalTime now = LocalTime.now();
				int hour = now.getHour();
				int minute = now.getMinute();
				int second = now.getSecond();
				
				for(int i = 0; i<PcarList.length ; i++ ) {
					
					String carNum = PcarList[i].split("-")[0];
					int carhour = Integer.parseInt(PcarList[i].split("-")[1]);
					int carminute = Integer.parseInt(PcarList[i].split("-")[2]);
					int carsecond = Integer.parseInt(PcarList[i].split("-")[3]);
					
					if( carChack.equals(carNum) ) {
						
						int paym1 = (carhour*60)+carminute;
						int paym2 = (hour*60)+minute;
						int finalpay = (paym2-paym1)*500;
						System.out.println("이용요금>>>>"+finalpay+"원");
						
					}
					
				}
				
			}
			
			if( ch == 3  ) {
				
			}
			
			if( ch == 4  ) {
				
			}

			if( ch == 5  ) {//if5 s
				System.out.println("정산기 종료합니다."); btn = false;
			}//if 5 end

			
		
		
		}
		
	}
	
}
