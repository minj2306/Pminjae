package 과제.과제5;

import java.util.Arrays;
import java.util.Scanner;

public class 과제5_키오스크 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 샘플 : 
		//이름 : 콜라 , 환타 , 사이다
		//가격 : 300 , 200 , 100
		//바구니 : 0 , 0 , 0
		String 재고관리 = "";
		/* 재고관리 변수 샘플  */

		// 1. 9개 변수가 가지고 있던 상태 값 데이터 한 변수에 저장
		재고관리 = "";
		
		// 2. JSON , XML , CSV 등 : 데이터 형식 규정
			//JSON : { 재고 : 10 , 바구니 : 0 , 가격 : 300 }
			//CSV : 10 , 0 , 300
		//----------------1.임의의 구분에 따른 여러 데이터를 하나의 문자열로 저장
		//1.필드/상태/속성 간의 구분 ',' 채택!
			//재고관리 = "10,0,300,10,0,200,10,0,100";
		
		//2. 필드 단위별 묶음 \n 채택 !
		재고관리 = "10,0,300\n10,0,200\n10,0,100\n";
		
		//----------------2. 임의의 구분에 따른 하나의 데이터를 여러 데이터로 변환 ------------------------------------------------
		//3. 임의의 구분(문자)를 기준으로 분리 : .split(분리기준문자) : 분리후배열(인덱스) 반환
			//10,0,300\n10,0,200\n10,0,100\n --> 조각수 4조각
				// 1조각 : 10,0,300		2조각 : 10,0,200		3조각 : 10,0,300		4조각 : 
		
		
		/* ----------- */
		
		while(true) {
			System.out.println("\n\n-------------------- 메뉴 ------------------- ");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.print(">>>>>> 선택 : "); int ch = scanner.nextInt();
			
			/* 문제풀이 위치 */
			
			System.out.println(Arrays.toString( 재고관리.split("\n") ) );//[10,0,300 10,0,200 10,0,100]
			System.out.println( "1조각 : " + 재고관리.split("\n")[0] );
			System.out.println( "2조각 : " + 재고관리.split("\n")[1] );
			System.out.println( "3조각 : " + 재고관리.split("\n")[2] );
			
			String 콜라정보 = 재고관리.split("\n")[0];
			String 환타정보 = 재고관리.split("\n")[1];
			String 사이다정보 = 재고관리.split("\n")[2];
			
			int 콜라재고 = Integer.parseInt( 콜라정보.split(",")[0] );
			int 콜라바구니 = Integer.parseInt( 콜라정보.split(",")[1] );
			int 콜라가격 = Integer.parseInt( 콜라정보.split(",")[2] );
			
			int 환타재고 = Integer.parseInt( 환타정보.split(",")[0] );
			int 환타바구니 = Integer.parseInt( 환타정보.split(",")[1] );
			int 환타가격 = Integer.parseInt( 환타정보.split(",")[2] );
			
			int 사이다재고 = Integer.parseInt( 사이다정보.split(",")[0] );
			int 사이다바구니 = Integer.parseInt( 사이다정보.split(",")[1] );
			int 사이다가격 = Integer.parseInt( 사이다정보.split(",")[2] );
			
			
			//step 1 : 메뉴 선택에 따른 서로 다른 실행/코드
			if ( ch == 1 ) {//1. 콜라선택
				
				//step 2 : 기능 구현
				// 1. 콜라 재고가 있으면 바구니에 담는다. 없으면 재고 없음 출력
				if( 콜라재고 > 0 ) {//재고 있을 때
				
					콜라바구니++; // 콜라바구니 변수에 콜라 1개 추가/증가
					콜라재고--; // 콜라재고 변수에 콜라 1개 차감/감소
					System.out.println("( 안내 )콜라 담았습니다.");
				}
				else {//재고 없을때 
					System.out.println("( 안내 ) 콜라 재고가 없습니다. [관리자에게 문의]");	
				}
				
			}//1 end
			
			else if ( ch == 2 ) {//2.환타 선택

				if( 환타재고 > 0 ) {//재고 있을 때
					
					환타바구니++; 
					환타재고--; 
					System.out.println("( 안내 )환타 담았습니다.");
				}
				else {//재고 없을때 
					System.out.println("( 안내 ) 환타 재고가 없습니다. [관리자에게 문의]");	
				}

			}//2 end
			
			else if ( ch == 3 ) {//3.사이다 선택

				if( 사이다재고 > 0 ) {//재고 있을 때
					
					사이다바구니++;
					사이다재고--; 
					System.out.println("( 안내 ) 사이다 담았습니다.");
				}
				else {//재고 없을때 
					System.out.println("( 안내 ) 사이다 재고가 없습니다. [관리자에게 문의]");	
				}

			}//3 end
			
			else if ( ch == 4 ){//4. 결제 선택
			
				//1. 변수/장바구니 내 데이터/개수 출력 *장바구니에 담은 제품만 출력[경우의 수]
				System.out.println("-----------------------");
				System.out.println("현재 장바구니 현황 표시 목록");
				System.out.printf("%3s %2s %5s\n", "제품명" , "수량" , "가격" );
				
				if( 콜라바구니 > 0) System.out.printf("%3s %2d %5d\n", "콜라" , 콜라바구니 , 콜라바구니*콜라가격 );
				if( 환타바구니 > 0)System.out.printf("%3s %2d %5d\n", "콜라" , 환타바구니 , 환타바구니*환타가격 );
				if( 사이다바구니 > 0)System.out.printf("%3s %2d %5d\n", "콜라" , 사이다바구니 , 사이다바구니*사이다가격 );
				
				if( 콜라바구니 == 0 && 사이다바구니 == 0 && 환타바구니 == 0) System.out.println("제품이 없습니다.");
				
				int 총가격 = 콜라바구니*콜라가격 + 환타바구니*환타가격 + 사이다바구니*사이다가격 ;
				System.out.println("총가격 : " + 총가격);
				System.out.println("-----------------------");
				
				System.out.println("1.결제 2.취소 : "); int ch2 = scanner.nextInt();
				if(ch2 == 1) {//결제 선택했을때
					
					//금액 입력
					System.out.println("안내 금액 투여 : "); int pay = scanner.nextInt();
					//2. 만약에 총 가격보다 금액이 더 크거나 같으면 성공 / 아니면 실패
					if(pay >= 총가격) {
						System.out.println("잔액  : " + (pay-총가격) );
						//구매성공//장바구니초기화 = 다음을 위해
						콜라바구니 = 0; 환타바구니 = 0; 사이다바구니 = 0;
						System.out.println("주문완료");
					}
					
					else {
						콜라재고 += 콜라바구니; 콜라바구니 = 0;
						환타재고 += 환타바구니; 환타바구니 = 0;
						사이다재고 += 사이다바구니; 사이다바구니 = 0;
						System.out.println("안내) 금액이 부족합니다. 초기 메뉴로 돌아갑니다.");
					}
					
				}//결제 끝
				else if(ch2 == 2) {//취소 선택했을떄
					
					//구매 취소했기 떄문에 원상복귀
					콜라재고 += 콜라바구니; 콜라바구니 = 0;
					환타재고 += 환타바구니; 환타바구니 = 0;
					사이다재고 += 사이다바구니; 사이다바구니 = 0;
					System.out.println("안내) 장바구니 초기화 했습니다. 초기 메뉴로 돌아갑니다.");
					// out 자리에 err 넣으면 글씨 빨간색 됨
					
				}//취소 끝
			}//4 end
			
			재고관리= 콜라재고+","+콜라바구니+","+콜라가격+"\n"
						+환타재고+","+환타바구니+","+환타가격+"\n"
							+사이다재고+","+사이다바구니+","+사이다가격+"\n";
			
			/* ----------- */
			
		} // while end 
	} // main end 
	
} // class end 

/*

	 주제 : 키오스크(변수버전)
	 	- 실행예시 사진은 없습니다.
		조건 
		1. 제품 가격/재고/바구니 상태를 하나의 문자열 변수에서 관리 
			// 샘플 : 
					이름 : 콜라 , 환타 , 사이다
					가격 : 300 , 200 , 100
					바구니 : 0 , 0 , 0
			
		2. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
			1. 콜라 2.사이다 3.환타 4.결제
			[ 1~3 선택시 ]
				- 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력
				 
			[ 4 선택시 ] 
				- 현재 장바구니 현황 표시 목록 
				----------------------------------
				제품명	수량	가격
				사이다	1	400
				환타		2	1000
				총가격 : 1400
				- 결제메뉴 표시
					1. 결제 2.취소 
					[결제]
						- 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
						- 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
					[취소]
						- [ 장바구니 초기화 / 재고 다시 되돌리기 ]
 
 */







