package 복습.part1;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyleFactory;

public class Part1 {

		public static void main(String[] args) {
			
			
			 int 콜라재고 = 10 ; int 환타재고 = 3; int 사이다재고 = 2;
			 int 콜라바구니 = 0 ; int 환타바구니 = 0 ; int 사이다바구니 = 0;
			 int 콜라가격 = 300 ; int 환타가격 = 200 ; int 사이다가격 = 100 ;
			 int 주문번호 = 1;
			Scanner scanner = new Scanner(System.in);
			
			while (true) {
				
				System.out.println("-------메뉴-------");
				System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
				System.out.println(">>>>>>>선택"); int ch = scanner.nextInt();
				if(ch ==1) {
					
					if(콜라재고>0) {
						콜라바구니++; 콜라재고--;
						System.out.println("안내) 콜라 담았습니다.");
					}
					else {
						System.out.println("안내) 콜라 재고 부족합니다. [관리자에게 문의]");
					}
				}
				else if( ch ==2) {
					
					if(환타재고>0) {
						환타바구니++; 환타재고--;
						System.out.println("안내) 환타 담았습니다.");
					}
					else {
						System.out.println("안내) 환타 재고 부족합니다. [관리자에게 문의]");
					}
					
				}
				else if( ch ==3) {
					
					if(사이다재고>0) {
						사이다바구니++; 사이다재고--;
						System.out.println("안내) 사이다 담았습니다.");
					}
					else {
						System.out.println("안내) 사이다 재고 부족합니다. [관리자에게 문의]");
					}
					
				}
				else if( ch ==4) {
					
					System.out.println("------장바구니 현황-----");
					System.out.printf("%3s %2s %5s\n","제품명" , "수량" , "가격");
					if(콜라바구니>0) {
						System.out.printf("%3s %2d %5d\n","콜라" , 콜라바구니 , 콜라바구니*콜라가격);
					}
					if(환타바구니>0) {
						System.out.printf("%3s %2d %5d\n","환타" , 환타바구니 , 환타바구니*환타가격);

					}
					if(사이다바구니>0) {
						System.out.printf("%3s %2d %5d\n","사이다" , 사이다바구니 , 사이다바구니*사이다가격);
					}
					if(콜라바구니==0 && 환타바구니==0 && 사이다바구니==0) {
						System.out.println("제품이 없습니다.");
					}
					int 총금액 = 콜라바구니*콜라가격 + 환타바구니*환타가격 + 사이다바구니*사이다가격;
					System.out.println("총금액 : "+총금액);
					System.out.println("1.결제 2.취소");
					int ch2 = scanner.nextInt();
					if(ch2==1) {
						
						System.out.println(">>>>>투입금액");
						int pay = scanner.nextInt();
						if(pay>=총금액) {
							System.out.println("잔액 : "+(pay-총금액));
							System.out.println("주문번호 : "+ 주문번호++);
							콜라바구니 = 0; 
							환타바구니 = 0;
							사이다바구니 = 0;
							
						}
						else {
							System.out.println("금액이 부족합니다. 초기화면으로 이동합니다.");
							콜라재고 += 콜라바구니;
							환타재고 += 환타바구니;
							사이다재고 += 사이다바구니;
							콜라바구니 = 0; 
							환타바구니 = 0;
							사이다바구니 = 0;
						}
						
					}
					else if(ch2==2) {
						
						System.out.println("취소하였습니다. 초기화면으로 이동합니다.");
						콜라재고 += 콜라바구니;
						환타재고 += 환타바구니;
						사이다재고 += 사이다바구니;
						콜라바구니 = 0; 
						환타바구니 = 0;
						사이다바구니 = 0;
						
					}
					
				}
				
			}
			
		}//main e
	
}//class e
