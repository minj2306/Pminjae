package 과제.강사님과제;

import java.util.Scanner;

public class 과제1 { // class s 
   public static void main(String[] args) { // main s 
      // * 입력객체
      Scanner scanner = new Scanner(System.in);
      // * 가격 변수
      int 콜라가격 = 300;    int 사이다가격 = 400;    int 환타가격 = 500;
      // * 재고 변수 
      int 콜라재고 = 10;      int 사이다재고 = 8;   int 환타재고 = 15;
      // * 장바구니 변수 
      int 콜라바구니 = 0;   int 사이다바구니 = 0;   int 환타바구니 = 0;
      
      String 콜라용 ="";
      String 사이다용 ="";
      String 환타용 ="";
       
      int 총금액 = 0;
      
      // * 프로그램 실행 반복
      while( true ) { // while s // 무한루프(반복) // 종료조건없음 break 없음
    	 
         System.out.println("-----------------------\n1.콜라 2.사이다 3.환타 4.결제\n--------선택해주세요--------");
    	 System.out.print("선택 : ");
    	 int select = scanner.nextInt();
    	 
    	 if( select==1 ) {//if 1 s
    		 
    		 if (콜라바구니==콜라재고) {System.out.println("-----------------------\n!!!콜라 재고부족!!!\n----------------------");}
    		 
    		 else {//if 1-else s
    		 
    			 콜라바구니++;
    			 int 콜라금액 = 콜라가격*콜라바구니;
    			 콜라용 = "콜라" +"\t"+ 콜라바구니 +"\t"+ 콜라금액+"\n";
    			 총금액 += 콜라가격;
    		 
    		 }//if 1-else e
    		 
    	 }//if 1 e
    	 	
    	 if( select==2) { // if 2 s
    		 if (사이다바구니==사이다재고) {System.out.println("-----------------------\n!!!사이다 재고부족!!!\n----------------------");}
    		 
    		 else { // if2-else s
    			 
    			 사이다바구니++;
    		 
    			 int 사이다금액 = 사이다가격*사이다바구니;
    			 사이다용 = "사이다" +"\t"+ 사이다바구니 +"\t"+ 사이다금액 +"\n";
    			 총금액 += 사이다가격;
    		 	
    		 }//if2-else e
    	
    	 } // if 2 e
    	
    	 if(select==3) { //if 3 s
    		
    		 if (환타바구니==환타재고) {System.out.println("-----------------------\n!!!환타 재고부족!!!\n----------------------");}
    		 
    		 else {//if3-else s
    		 
    			 환타바구니++;
    		 
    			 int 환타금액 = 환타가격*환타바구니;
    			 환타용 = "환타" +"\t"+ 환타바구니 +"\t"+ 환타금액 +"\n";
    			 총금액 += 환타가격;
    		}//if3-else e
    		 
    	 }//if 3 e
    	 
    	 if(select==4) { //if 4 s
    		
    		 System.out.println("--------선택해주세요--------");
    		 System.out.println("1.결제\t2.취소");
    		 int or = scanner.nextInt();
    		 
    		 if( or == 1 ) {//if4 - if s
    		 
    			System.out.println("제품명\t수량\t가격");
     	        System.out.println(콜라용+"\n"+사이다용+"\n"+환타용);
     	       	System.out.println("총가격 : "+총금액);
    			 
    			System.out.print("결제금액을 입력해주세요 : ");
    			int pay = scanner.nextInt();
    			
    			if(pay==총금액) {// if 4- if - if s
    		 		
    		 		콜라재고 = 콜라재고-콜라바구니;
    		 		사이다재고 = 사이다재고 - 사이다바구니;
    		 		환타재고 = 환타재고 - 환타바구니;
	    			
    		 		System.out.println("콜라재고 : "+콜라재고+"개");
	    			System.out.println("사이다재고 : "+사이다재고+"개");
	    			System.out.println("환타재고 : "+환타재고+"개");
	    			 
	    			콜라바구니=0;
	    			사이다바구니=0;
	    			환타바구니=0;
    			 
	    			콜라용 = "";
	    			사이다용 = "";
	    			환타용 = "";
	    			총금액 = 0;
    			 
	    			System.out.println("!!!결제 성공!!!");
    	
    		 	}//if 4- if - if e
    			else if (pay<총금액) {//if 4 - if - else if1 s
    				System.out.println("!!!금액이 부족합니다!!!");
    				콜라바구니=0;
    				사이다바구니=0;
    				환타바구니=0;
    			 
    				콜라용 = "";
    				사이다용 = "";
    				환타용 = "";
    				총금액 = 0;
    			}//if 4 - if - else if1 e
    			
    			else if (pay>총금액) {//if 4 - if - else if2 s
    			 
    				콜라재고 = 콜라재고-콜라바구니;
    				사이다재고 = 사이다재고 - 사이다바구니;
    				환타재고 = 환타재고 - 환타바구니;
    				System.out.println("콜라재고 : "+콜라재고+"개");
    				System.out.println("사이다재고 : "+사이다재고+"개");
    				System.out.println("환타재고 : "+환타재고+"개");
    			 
    				System.out.println("!!!결제 성공!!!");
    				System.out.println(">>>>>>>>>>거스름돈 : "+(pay-총금액));
    			 
    				콜라바구니=0;
    				사이다바구니=0;
    				환타바구니=0;
    			 
    				콜라용 = "";
    				사이다용 = "";
    				환타용 = "";
    				총금액 = 0;
    			}//if 4 - if - else if2 e
    			
    		  }//if4 - if e
    		 else if( or == 2 ) {//if4 - else if s
    			 
    			 System.out.println("!!!결제를 취소합니다!!!");
    			 
    			 콜라바구니=0;
 				 사이다바구니=0;
 				 환타바구니=0;
 			 
 				 콜라용 = "";
 				 사이다용 = "";
 				 환타용 = "";
 				 총금액 = 0;
 				 
    		 }//if4 - else if e
    	 
    	 }//if 4 e
    	 
    	 else {System.out.println("올바른 번호를 입력해주세요");}
    	 
    	 System.out.println("제품명\t수량\t가격");
       	 System.out.println(콜라용+"\n"+사이다용+"\n"+환타용);
       	 System.out.println("총가격 : "+총금액);
      } // while e 
     
  
   } // main e 
} // class e 

/*
 과제2 [ console  키오스크 ]
   요구사항
   1. 제품 가격
      1.콜라[300원]  2.사이다[400원]  3.환타[500원]
   
   2. 제품 초기 재고
      콜라 10개   , 사이다 8개 , 환타 15개      * 판매시 재고 차감되고 다시 채우기 제외 

   3. 키오스크 메뉴 [ 무한루프 : 종료 없음(24시간) ] 
      1. 콜라 2.사이다 3.환타 4.결제
      [ 1~3 선택시 ]
         - 재고가 있을경우 장바구니 담기 / 없으면 '재고부족' 출력 
      [ 4 선택시 ] 
         - 현재 장바구니 현황 표시 목록 
         ----------------------------------
         제품명   수량   가격
         사이다   1   400
         환타      2   1000
         총가격 : 1400
            
         - 결제메뉴 표시
            1. 결제 2.취소 
            [결제]
               - 금액 입력받아 총가격에 뺀 잔액 출력 -> 결제 성공시 장바구니 초기화 
               - 만약에 금액이 부족하면 결제 취소 -> 장바구니 초기화 / 재고 다시 되돌리기
            [취소]
               - [ 장바구니 초기화 / 재고 다시 되돌리기 ]
*/