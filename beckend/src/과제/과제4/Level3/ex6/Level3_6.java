package 과제.과제4.Level3.ex6;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3_6 {
	
	public static void main(String[] args) {
		System.out.println(" >> Level3_6 answer >> ");
		System.out.println(" >> answer time : " + LocalDateTime.now() +" >> \n" );
		Scanner scanner = new Scanner(System.in);
		
		/* 문제풀이 위치 */
		
		String a = " ";
		String b = " ";
		String c = " ";
		String d = " ";
		String e = " ";
		String f = " ";
		
		while (true) {//wh s
			System.out.println("--------매뉴를 선택하세요-------");
			System.out.println("1.예약하기 2.예약취소 3.예약현황");
			int select = scanner.nextInt();
			
			if( select == 1 ) {//if1 s
				System.out.println("예약할 좌석을 골라주세요\n1 ~ 6");
				System.out.println("[1] [2] [3]\n[4] [5] [6]");
				int 예약 = scanner.nextInt();
				if(예약==1) {
					if(a.equals(" ")){System.out.println("예약성공"); a="예약";}
					else {System.out.println("예약실패");}
				}
				if(예약==2) {
					if(b.equals(" ")){System.out.println("예약성공"); b="예약";}
					else {System.out.println("예약실패");}
				}
				if(예약==3) {
					if(c.equals(" ")){System.out.println("예약성공"); c="예약";}
					else {System.out.println("예약실패");}
				}
				if(예약==4) {
					if(d.equals(" ")){System.out.println("예약성공"); d="예약";}
					else {System.out.println("예약실패");}
				}
				if(예약==5) {
					if(e.equals(" ")){System.out.println("예약성공"); e="예약";}
					else {System.out.println("예약실패");}
				}
				if(예약==6) {
					if(f.equals(" ")){System.out.println("예약성공"); f="예약";}
					else {System.out.println("예약실패");}
				}
			}//if1 e
			
			if(select==2) {//if 2 s
				System.out.println("취소할 좌석을 선택해주세요");
				int 취소 = scanner.nextInt();
				if(취소==1) {
					if(a.equals("예약")) {
						a=" "; System.out.println("취소되었습니다.");
					}
					else {System.out.println("빈좌석입니다.");}
				}
				if(취소==2) {
					if(b.equals("예약")) {
						b=" "; System.out.println("취소되었습니다.");
					}
					else {System.out.println("빈좌석입니다.");}
				}
				if(취소==3) {
					if(c.equals("예약")) {
						c=" "; System.out.println("취소되었습니다.");
					}
					else {System.out.println("빈좌석입니다.");}
				}
				if(취소==4) {
					if(d.equals("예약")) {
						d=" "; System.out.println("취소되었습니다.");
					}
					else {System.out.println("빈좌석입니다.");}
				}
				if(취소==5) {
					if(e.equals("예약")) {
						e=" "; System.out.println("취소되었습니다.");
					}
					else {System.out.println("빈좌석입니다.");}
				}
				if(취소==6) {
					if(f.equals("예약")) {
						f=" "; System.out.println("취소되었습니다.");
					}
					else {System.out.println("빈좌석입니다.");}
				}
			}//if 2 e
				
			if(select==3) {
				System.out.println("예약현황입니다.");
				System.out.println("["+a+"] ["+b+"] ["+c+"]\n ["+d+"] ["+e+"] ["+f+"]");

			}
		}//wh e
		
		
		
		
		
		
		
		/* ----------- */

	}
}
/* 
	주제 : 예약 좌석 시스템
	실행결과는 제공하지 않습니다.
	
	- 변수 조건 
		1. 변수 : 6개의 좌석 은 변수를 이용합니다. [ 배열X ]
		2. 그외 자유롭게 사용. 배열/리스트 사용 금지 [ day1~day4 문법 이용 ]
	- 메뉴 조건
		0. 메뉴 : 1.예약하기 2.예약취소 3.예약현황 
	- 기능 조건 
	 	예약하기 출력예시 )
	 		1. 예약할 좌석을 선택한다.
	 		2. 만약에 비어 있으면 예약성공 아니면 예약 실패 
	 	예약취소 출력예시 )
	 		1. 예약할 취소할 좌석을 선택한다.
	 	예약현황 출력예시 )
	 		* 3개씩 2줄로 출력합니다.
			[ 예약 ]	[ ]	[ ]
			[ ] [예약] [ ]  
			- 예약이 되어 있는 좌석은 [예약] 예약이 없으면 [ ] 공란으로 출력합니다.
			
*/
