package 과제.과제6도서관;

import java.util.Arrays;
import java.util.Scanner;

public class 도서관 {

   public static void main(String[] args) {
      
     int 도서개수 = 1;
     String[] 도서 =  new String[도서개수];
     String[] 대여목록 = new String[도서개수];
      Scanner scanner = new Scanner(System.in);
  
      int btn = 0;
      
      while (true) {
         System.out.println("----------------------");
         System.out.println("원하는 기능을 선택해주세요");
         System.out.println("1.도서등록 | 2.도서목록 | 3.도서대여 | 4.도서반납 | 5.도서수정 | 6.도서삭제 | 7.종료 ");
         System.out.println("선택>");

         int ch = scanner.nextInt();

         
         if(ch == 1 ) {
            System.out.println("등록할 도서 개수를 정해주세요");
               도서개수 = scanner.nextInt();
               도서 = new String[도서개수];
               대여목록 = new String[도서개수];
               for(int i = 0; i<도서.length; i++) {//f s
                  
                  System.out.print(i+"번 도서 등록>");
                  도서[i] = scanner.next();
                  
               }//f end
                  
       
                  
            
         }//1.도서등록
         if (ch == 2) {
            System.out.println(Arrays.toString(도서));
               
         }
         // 2.도서목록
         
          if(ch == 3 ) {
             System.out.println("----------대여가능 도서목록-------");
                  System.out.println(Arrays.toString(도서));
                  System.out.println("------------------------------");
                  System.out.print("대여할 도서를 입력해주세요>");
                  String 대여 = scanner.next();
               
                  for(int i = 0; i<도서.length; i++) {
                     
                     if(도서[i].equals(대여)) {
                        
                        대여목록[i] = 대여;
                        System.out.println(대여+"도서 대여 되었습니다.");
                        도서[i] = 대여 + "(대여중)";
                        btn = 1;
                     }
               
                  }
                  if(btn == 0) {
                     System.out.println(대여+"도서가 없습니다.");
                  }
                  btn = 0 ;
          }//3.도서대여
          if (ch == 4) {
             System.out.println("반납할 도서를 입력하세요 : ");
             String 반납 = scanner.next();
             
            for (int i = 0; i < 대여목록.length; i++) {
               if(null != 대여목록[i]) {
                  if (대여목록[i].equals(반납)) {
                     대여목록[i] = null;
                     도서[i] = 반납;
                     btn = 1;
                     System.out.println(반납 + "도서 반납 되었습니다.");
                  }      
                     
               }

            }
            
            if(btn == 0) {
               System.out.println("일치하지 않습니다.");
            }
            btn = 0;
         }
         
         // 4.도서반납
         
         if(ch == 5 ) {
         System.out.print("수정하고싶은 도서를 입력해주세요");
            String 수정 = scanner.next();
            
            for(int i =0; i<도서.length; i++) {
               if(도서[i].equals(수정)) {
                  String 바꾸기 = scanner.next();
                  도서[i] = 바꾸기;
                  btn=1;
               }
            }//f end
            if(btn == 0) {
               System.out.println(수정+"도서가 없습니다.");
            }
            btn = 0 ;}//5.도서수정
         
         
         if (ch == 6) {
            System.out.println("삭제할 도서를 입력하세요 : ");
            String 삭제 = scanner.next();
            
            
            for (int i = 0; i < 도서.length; i++) {
               if(도서[i].equals(삭제)) {
                  
                  도서[i] = null;
                  

                  btn = 1;
                  
                  }
            } 
            if(btn == 0) {
               System.out.println("일치하지 않습니다.");
            }
            	btn = 0;
         } // 6.도서삭제

         if (ch == 7) {
            System.out.println("종료합니다");
            break;
         } // 7.종료

      }
      
   }
   
}