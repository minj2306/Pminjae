package 복습.part5;

import java.util.Scanner;

public class part5_MemberSys {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		part5_Member[] memberList = new part5_Member[100];
		
		while (true) {
			
			System.out.println("-----------회원 시스템-----------");
			System.out.println("1:회원가입 2:로그인\t >선택");
			int ch = scanner.nextInt();
			
			if(ch==1) {
				System.out.println("-----------회원가입-----------");
				System.out.println("아이디 : "); String Id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
				System.out.println("나이 : "); int age = scanner.nextInt();
				
				part5_Member member = new part5_Member(Id, pw, name, phone, age);
				for(int i=0; i<memberList.length; i++) {
					if(memberList[i]==null) {
						memberList[i]=member;
						break;
					}
				}
						
				
			}
			else if(ch==2) {
				System.out.println("-----------회원가입-----------");
				System.out.println("아이디 : "); String Id = scanner.next();
				System.out.println("비밀번호 : "); String pw = scanner.next();
			
				int login =-1;
				
				for(int i =0; i<memberList.length; i++) {
					if(memberList[i]!=null&&
							memberList[i].Id.equals(Id)&&
							memberList[i].password.equals(pw)) {
						login = i;
						break;
					}
				}
				if(login>=0) {
					System.out.println("로그인 성공");
				}
				else {
					System.out.println("로그인 실패");
				}
			}
			
			
		}//wh end
		
	}
}
