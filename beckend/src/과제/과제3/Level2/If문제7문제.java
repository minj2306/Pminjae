package 과제.과제3.Level2;
import java.util.Scanner;
public class If문제7문제 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/* -------문제1----- */
		
		System.out.println("문제1 정수1 : ");
		int num1 = scanner.nextInt();
		System.out.println("문제1 정수2 : ");
		int num2 = scanner.nextInt();
		
		if(num1 < num2) {
			System.out.println(num2+"이(가)크다");
		}
		else if(num1 > num2) {
			System.out.println(num1+"이(가)크다");
		}
		else {System.out.println("같다");}
		
		/* -------문제2----- */
		
		System.out.println("문제2 정수1 : ");
		int num3 = scanner.nextInt();
		System.out.println("문제2 정수2 : ");
		int num4 = scanner.nextInt();
		System.out.println("문제2 정수3 : ");
		int num5 = scanner.nextInt();
		
		if( num3 > num4 && num3 > num5  )
			{System.out.println( num3+"이(가)크다" );}
		else if ( num4 > num3 && num4 > num5 ){
			System.out.println(num4+"이(가)크다");
		}
		else if (num5 > num3 && num5 > num4) {
			System.out.println(num5+"이(가)크다");
		}
		else if(num3 == num4 && num3 == num5) {
			System.out.println("모두 같다");
		}
		
		/* -------문제3----- */
		
		System.out.println("문제3 정수1 : ");
		int num6 = scanner.nextInt();
		System.out.println("문제3 정수2 : ");
		int num7 = scanner.nextInt();
		System.out.println("문제3 정수3 : ");
		int num8 = scanner.nextInt();
		
		System.out.println("내림차순");
		if( num6>num7 && num7>num8 ) {
			System.out.println(num6+"\n"+num7+"\n"+num8);
		}
		else if (num7>num6 && num6>num8) {
			System.out.println(num7+"\n"+num6+"\n"+num8);
		}
		else if (num7>num8 && num8>num6) {
			System.out.println(num7+"\n"+num8+"\n"+num6);
		}
		else if (num8>num7 && num7>num6) {
			System.out.println(num8+"\n"+num7+"\n"+num6);
		}
		else if (num8>num6 && num6>num7) {
			System.out.println(num8+"\n"+num6+"\n"+num7);
		}
		
		System.out.println("오름차순");
		if( num6<num7 && num7<num8 ) {
			System.out.println(num6+"\n"+num7+"\n"+num8);
		}
		else if (num7<num6 && num6<num8) {
			System.out.println(num7+"\n"+num6+"\n"+num8);
		}
		else if (num7<num8 && num8<num6) {
			System.out.println(num7+"\n"+num8+"\n"+num6);
		}
		else if (num8<num7 && num7<num6) {
			System.out.println(num8+"\n"+num7+"\n"+num6);
		}
		else if (num8<num6 && num6<num7) {
			System.out.println(num8+"\n"+num6+"\n"+num7);
		}
		
		/* -------문제4----- */
		
		System.out.print("문제4 점수 : ");
		int score = scanner.nextInt();
		
		if ( score >= 90 ) {
			System.out.println("합격");
		}
		else {System.out.println("불합격");}
		
		/* -------문제5----- */
		
		System.out.print("문제 5 점수 : ");
		int score2 = scanner.nextInt();
		
		if( score2 >=90 ) {
			System.out.println("A등급");
		}
		else if( score2 >= 80 ) {
			System.out.println("B등급");
		}
		else if( score2 >= 70 ) {
			System.out.println("C등급");
		}
		else {
			System.out.println("재시험");
		}
		/* -------문제6----- */
		System.out.print("국어점수");
		int kor = scanner.nextInt();
		System.out.print("영어점수");
		int eng = scanner.nextInt();
		System.out.print("수학점수");
		int mat = scanner.nextInt();
		
		int avar = kor+eng+mat;
		System.out.println("평균점수 : "+avar);
		
		if( avar>=90 && kor==100 ) {
			System.out.println("국어우수");
		}
		else if( avar>90 && eng==100) {
			System.out.println("영어우수");
		}
		else if( avar>90 && mat==100) {
			System.out.println("수학우수");
		}
		else if( avar>=80 && kor>=90) {
			System.out.println("국어장려");
		}
		else if( avar>=80 && eng>=90) {
			System.out.println("영어장려");
		}
		else if( avar>=80 && mat>=90) {
			System.out.println("수학장려");
		}
		else {System.out.println("재시험");}
		/* -------문제7----- */
		
		System.out.print("id : ");
		String iD = scanner.next();
		System.out.print("pw : ");
		String pw = scanner.next();
		
		if( iD.equals("admin") && pw.equals("1234") ) {
			System.out.println("로그인 성공");
		}
		else {System.out.println("로그인 실패");
	}
	
}

/*
 	 문제1 : 2개의 정수를 입력받아서 더 큰수 출력 [ 경우의수 : 3개(크다,작다,같다=그외) ]
 	 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력 
 	 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
 	 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
 	
 	 문제5 : 
			// 점수를 입력받아 점수가 90점 이상이면 A등급
			//				점수가 80점 이상이면 B등급
			//				점수가 70점 이상이면 C등급
			//				그외 재시험
	
	
 	 문제6	[ 경우의수 3개 , 첫번째 경우의수 : 3개 , 두번째 경우의수 : 3개 ] 총 9개  
			[ 입력 ] : 국어,영어,수학 입력받기
			[ 조건 ]
				평균이 90점 이상이면서 
					국어점수 100점 이면 '국어우수' 출력
					영어점수 100점 이면 '영어우수' 출력
					수학점수 100점 이면 '수학우수' 출력
				평균이 80점 이상이면서 
					국어점수 90점이상 이면 '국어장려' 출력
					영어점수 90점이상 이면 '영어정려' 출력
					수학점수 90점이상 이면 '수학장려' 출력
				그외 재시험 
		 
	문제7 로그인페이지
	 		[ 입력 ] : 아이디와 비밀번호를 입력받기
	 		[ 조건 ] : 회원아이디가 admin 이고 
	           			비밀번호가 1234 일 경우에는 
	          			로그인 성공 아니면 로그인 실패 출력
 */
