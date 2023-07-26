package 복습.part3;

import java.util.Scanner;

public class part3 {

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
	    String[] 재고관리 = { "10,0,300,콜라" , "3,0,200,환타" , "2,0,100,사이다"};

	    while (true) {
	    	
	    	System.out.println("---------메뉴---------");
	    	System.out.println("1.콜라[300] 2.환타[200] 3.사이다[100] 4.결제");
			System.out.println(">>>>>>선택"); int ch = scanner.nextInt();
			
			if( ch==1 || ch==2 || ch==3) {
				
				String 제품정보 = 재고관리[ch-1];
				int 재고 = Integer.parseInt(제품정보.split(",")[0]);
				int 바구니 = Integer.parseInt(제품정보.split(",")[1]);
				int 가격 = Integer.parseInt(제품정보.split(",")[2]);
				String name = 제품정보.split(",")[3];
				if(재고>0) {
					바구니 ++; 재고--;
					System.out.println(name + " 제품 담았습니다.");
				}
				else {
					System.out.println(name + " 재고 부족합니다.[관리자에게 문의]");
				}
				재고관리[ch-1] = 재고+","+바구니+","+가격+","+name;
			}
			else if( ch==4) {
				System.out.println("------------장바구니 현황------------");
				System.out.printf("%10s %10s %10s\n","제품명","수량","가격");
				for(int i =0; i<재고관리.length; i++) {
					
					int 바구니 = Integer.parseInt(재고관리[i].split(",")[1]);
					int 가격 = Integer.parseInt(재고관리[i].split(",")[2]);
					String name = 재고관리[i].split(",")[3];
					if(바구니 >0) {
						System.out.printf("%10s %10s %10s\n",name,바구니,가격);
					}
				}
			}
	    	
		}
		
	}//main e
		
}//class e
 