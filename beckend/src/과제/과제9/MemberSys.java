package 과제.과제9;

import java.util.Scanner;

//목적 : 실행
public class MemberSys {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//0. 여러개 Member 객체 100개를 저장 예정인 배열 선언
		Member[] memberList = new Member[100];
		//배열 선언 : 타입명[] 배열명 = new 타입명[길이];
			//타입 : 기본타입(int,float 등), 참조(String , 직접만든클래스=Member 등) 타입
		while (true) {
			//1.무한출력
			System.out.println("---------회원시스템---------");
			System.out.println("1.회원가입 2.로그인     >선택");
			//2.무한입력
			int ch = scanner.nextInt();
			//3. 입력/선택 경우의 수
			if( ch==1 ) {
				System.out.println("-------------회원가입-------------");
				//1. 각 입력받아 저장
				System.out.println("아이디 : "); String inputId = scanner.next();
				System.out.println("비밀번호 : "); String inputPw = scanner.next();
				System.out.println("이름 : "); String inputName = scanner.next();
				System.out.println("전화번호 : "); String inputPhone = scanner.next();
				System.out.println("나이 : "); int inputAge = scanner.nextInt();
				//2. 5가지를 하나로 묶음 = 문자열vs객체
				//* 객체선언 : 클래스명 객체변수명 = new 생성자명();
				//1. 기본생성자[과제8] vs 정의한생성자[과제9]
				//1안
				Member member = new Member(inputId, inputPw, inputName, inputPhone, inputAge);
				
				
				//3. 여러개 객체를 저장하기 위해 배열에 저장
					//*비어있는 인덱스를 찾아서(처음부터 끝까지 확인) 해당 인덱스에 객체 저장
				for(int i = 0 ; i<memberList.length; i++) {
					if(memberList[i]==null) {
						memberList[i] = member;
						break;
					}//if s
				}//for e
			}
			else if ( ch==2 ) {
				System.out.println("-------------로그인-------------");
				//입력받기
				System.out.println("아이디 : "); String inputId = scanner.next();
				System.out.println("비밀번호 : "); String inputPw = scanner.next();
				
				int login = -1;//로그인 여부를 저장하는 변수 
								//-1: 못찾았다 0 이상이면 찾고 찾은 인덱스 번호 저장 = 로그인 생성 기록
				
				//2. 입력받은 데이터를 배열 내 찾기
				for( int i = 0 ; i< memberList.length; i++) {
					if(memberList[i] != null && 
							memberList[i].id.equals(inputId) && 
								memberList[i].password.equals(inputPw) ) {
						//로그인 성공
						login = i; // 로그인 성공후 변수에 성공한 인덱스 저장 = 추후에 로그인 상태 활용
						break;
					}//if end
					
				}//for end
				
				//3. 로그인 성공여부 변수에 따른 흐름제어
				//로그인 실패[모든 배열 검사후에 성공 못하면 실패]
				if( login >= 0) {
					System.out.println("안내) 로그인성공");
				}//추후에 로그인시 새로운 매뉴 로그인 호출
				
				else {
					System.out.println("안내) 로그인 실패");
				}
				
			}//if end
			
		}//wh e
		
	}//main e
	
}//class e

/*
	주제 : 회원제 시스템
		0. 저장
			아이디 , 비밀번호 , 이름 , 전화번호 , 나이
			*5가지(서로다른타입) 필드/변수/데이터 를 하나의 묶는 방법
			-->문자열 이용 : "아이디,비밀번호,이름,전화번호,나이" : ,쉼표 이용한 필드 구분
			-->클래스(필드) 이용 : 
				1. 클래스 설계 = 새로운 클래스.java 파일 생성
				2. 클래스 멤버 구성 : 필드 , 생성자 , 메소드
			*하나로 묶인(기준동일=타입동일) 여러개 저장????
			-->문자열 배열 : String[] 문자열배열 = new String[100];
			-->클래스 배열 : Member[] 객체배열 = new Member[100]; 
		1.초기 메뉴
			1. 회원가입 2. 로그인
		
		2. 조건기능
			1. 회원가입
				1. : 아이디 , 비밀번호 , 이름 , 전화번호 , 나이 각 입력받아 저장
				2. : Member 객체화
				3. : 객체를 배열 저장
				
			2. 로그인
				1. 아이디 , 비밀번호 입력받아 저장
				2. 입력받은 값과 배열내 동일한 값 찾기
					- 만약에 동일한 값 있으면 로그인 성공
					- 아니면 실패

	회원가입 , 로그인

 */


