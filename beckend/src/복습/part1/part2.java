package 복습.part1;

import java.util.Scanner;

public class part2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String 재고관리 = "";
		재고관리 = "10,0,300\n10,0,200\n10,0,100\n";
		
		while (true) {
			
			System.out.println("---------메뉴--------");
			System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.println(">>>>>>>선택");
			int ch = scanner.nextInt();
			
			String 콜라정보 = 재고관리.split("\n")[0];
			String 환타정보 = 재고관리.split("\n")[1];
			String 사이다정보 = 재고관리.split("\n")[2];
			
			int 콜라재고 = Integer.parseInt(콜라정보.split(",")[0] );
			int 콜라바구니 = Integer.parseInt(콜라정보.split(",")[1] );
			int 콜라가격 = Integer.parseInt(콜라정보.split(",")[2] );
			
			int 환타재고 = Integer.parseInt(환타정보.split(",")[0] );
			int 환타바구니 = Integer.parseInt(환타정보.split(",")[1] );
			int 환타가격 = Integer.parseInt(환타정보.split(",")[2] );

			int 사이다재고 = Integer.parseInt(사이다정보.split(",")[0] );
			int 사이다바구니 = Integer.parseInt(사이다정보.split(",")[1] );
			int 사이다가격 = Integer.parseInt(사이다정보.split(",")[2] );

			if( ch==1) {
				if(콜라재고>0) {
					콜라바구니++; 콜라재고--;
					System.out.println("안내) 콜라 담았습니다.");
				}
				else {
					System.out.println("안내) 콜라 재고 담았습니다.");
				}
			}
			
			else if( ch==2) {
				
				if(환타재고>0) {
					환타바구니++; 환타재고--;
					System.out.println("안내) 환타 담았습니다.");
				}
				else {
					System.out.println("안내) 환타 재고 담았습니다.");
				}
				
			}
			else if( ch==3) {
				
				if(사이다재고>0) {
					사이다바구니++; 사이다재고--;
					System.out.println("안내) 사이다 담았습니다.");
				}
				else {
					System.out.println("안내) 사이다 재고 담았습니다.");
				}
				
			}
			else if( ch==4) {
				System.out.println("-------장바구니 현황------");
				System.out.printf("%3s %2s %5s\n","제픔명","수량","가격");
				if(콜라바구니>0) {
					System.out.printf("%3s %2s %5s\n","콜라",콜라바구니,콜라바구니*콜라가격);
				}
				if(환타바구니>0) {
					System.out.printf("%3s %2s %5s\n","환타",환타바구니,환타바구니*환타가격);
				}
				if(사이다바구니>0) {
					System.out.printf("%3s %2s %5s\n","사이다",사이다바구니,사이다바구니*사이다가격);
				}
				if(콜라바구니==0 && 환타바구니==0 && 사이다바구니==0) {
					System.out.println("제품이 없습니다.");
				}
				int 총금액 = 콜라바구니*콜라가격+환타바구니*환타가격 +사이다바구니*사이다가격;
				System.out.println("총금액 : "+ 총금액);
				System.out.println("1.결제 2.취소");
				int ch2 = scanner.nextInt();
				if(ch2==1) {
					System.out.println(">>>>>금액투여");
					int pay = scanner.nextInt();
					if(pay>=총금액) {
						System.out.println("잔액 : "+(pay-총금액));
						System.out.println("주문완료");
						콜라바구니 = 0;
						환타바구니 = 0;
						사이다바구니 = 0;
						
					}
					else {
						System.out.println("금액이 부족합니다.");
						콜라재고 += 콜라바구니;
						사이다재고 += 사이다바구니;
						환타재고 += 환타바구니;
						콜라바구니 = 0;
						환타바구니 = 0;
						사이다바구니 = 0;
					}
					
				}
				else if( ch2==2) {
					System.out.println("취소하였습니다.");
					콜라재고 += 콜라바구니;
					사이다재고 += 사이다바구니;
					환타재고 += 환타바구니;
					콜라바구니 = 0;
					환타바구니 = 0;
					사이다바구니 = 0;
				}
			}

			재고관리 =콜라재고 + "," + 콜라바구니+","+콜라가격+"\n"
					+환타재고 + "," + 환타바구니+","+환타가격+"\n"
						+사이다재고 + "," + 사이다바구니+","+사이다가격+"\n";
			
		}
		
	}
	
}
