package 과제.과제2;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class 연산20문제 {
	
	public static void main(String[] args) {
		
		//------ 문제1 여기에 풀이-------//
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		

		
		//------ 문제2 여기에 풀이-------//
		System.out.println("--------------방문록----------------");
		String num1 = "순번"; String writer1 = "작성자"; 
		String conTent1 = "내용"; String date1 = "날짜";
		System.out.println("|"+num1+"|"+writer1+"|\t"+conTent1+"\t|"+date1+"|");
		byte num2 = 1; String writer2 = "강호동";
		String conTent2 = "안녕하세요"; String date2 = "09-28";
		System.out.println("|  "+num2+"|"+writer2+"|\t"+conTent2+"\t|"+date2+"|\n-------------------------------");
		
		//------ 문제3 여기에 풀이-------//
		/*
		Scanner scanner = new Scanner( System.in );
		short 기본급 = scanner.nextShort(); 
		short 수당 = scanner.nextShort();
		System.out.println("기본급 : "+ 기본급);
		System.out.println("수당 : "+ 수당);
		System.out.println("실수령액 : "+((기본급+수당)-((기본급+수당)/10)));
		*/
		//------ 문제4 여기에 풀이-------//
		/*
		Scanner money = new Scanner( System.in);
		int tM1 = money.nextInt();
		System.out.println("금액 : "+tM1);
		int tM2 = tM1/100000;
		int tM3 = (tM1-(tM2*100000))/10000;
		int tM4 = (tM1-(tM2*100000)-(tM3*10000))/1000;
		int tM5 = (tM1-(tM2*100000)-(tM3*10000)-(tM4*1000))/100;
		System.out.println("십만원 : " + tM2 + "장" );
		System.out.println("만원 : " + tM3 + "장" );
		System.out.println("천원 : " + tM4 + "장" );
		System.out.println("백원 : " + tM5 + "개" );
		*/
		
		//------ 문제5 여기에 풀이-------//
		/*
		Scanner seVen = new Scanner( System.in );
		int seVen1 = seVen.nextInt();
		String seVen2 = (seVen1 % 7 == 0) ? "O" : "X" ;
		System.out.println(seVen2);
		*/
		//------ 문제6 여기에 풀이-------//
		/*
		Scanner numBer = new Scanner( System.in );
		int numBer1 = numBer.nextInt();
		String numBer2 = (numBer1 % 2 == 1) ? "O" : "X" ;
		System.out.println(numBer2);
		*/
		
		//------ 문제7 여기에 풀이-------//
		/*
		Scanner seVen3 = new Scanner( System.in );
		int seVen4 = seVen3.nextInt();
		String seVen5 = (seVen4 % 7 == 0 && seVen4 % 2 ==0 ) ?
													"O" : "X" ;
		System.out.println(seVen5);
		*/
		//------ 문제8 여기에 풀이-------//
		/*
		Scanner seVen6 = new Scanner( System.in );
		int seVen7 = seVen6.nextInt();
		String seVen8 = (seVen7 % 7 == 0 || seVen7 % 2 ==1 ) ?
													"O" : "X" ;
		System.out.println(seVen8);
		*/
		
		//------ 문제9 여기에 풀이-------//
		/*
		Scanner nuM1 = new Scanner(System.in);
		Scanner nuM2 = new Scanner(System.in);
		int nuM1_1 = nuM1.nextInt();
		int nuM2_1 = nuM2.nextInt();
		int eNd = (nuM1_1 > nuM2_1) ? nuM1_1 : nuM2_1 ;  
		System.out.println(eNd+"이 크다.");
		*/
		//------ 문제10 여기에 풀이-------//
		/*
		Scanner cirCle = new Scanner(System.in);
		int cirCle1 = cirCle.nextInt();
		double cirCle1_1 = (cirCle1*cirCle1)*3.14 ;
		System.out.println(cirCle1_1);
		*/
		//------ 문제11 여기에 풀이-------//
		/*
		Scanner nuM3 = new Scanner(System.in);
		Scanner nuM4 = new Scanner(System.in);
		float nuM3_1 = nuM3.nextFloat();
		float nuM4_1 = nuM4.nextFloat();
		float end1 = (nuM3_1 / nuM4_1) *100;
		System.out.println(end1);
		*/
		//------ 문제12 여기에 풀이-------//
		/*
		Scanner nuM5 = new Scanner(System.in);
		Scanner nuM6 = new Scanner(System.in);
		Scanner nuM7 = new Scanner(System.in);
		
		int nuM5_1 = nuM5.nextInt();
		int nuM6_1 = nuM6.nextInt();
		int nuM7_1 = nuM7.nextInt();
		int enD2 = ( (nuM5_1 + nuM6_1) * nuM7_1 ) / 2 ;
		
		System.out.println("윗변 : "+nuM5_1);
		System.out.println("밑변 : "+nuM6_1);
		System.out.println("높이 : "+nuM7_1);
		System.out.println("사다리꼴 넓이 : "+enD2);
		*/
		//------ 문제13 여기에 풀이-------//
		/*
		Scanner taLl = new Scanner(System.in);
		short taLl_1 = taLl.nextShort();
		double weIght = (taLl_1-100)*0.9;
		System.out.println("키 : "+taLl_1);
		System.out.println("표준체중 : "+weIght);
		*/
		//------ 문제14 여기에 풀이-------//
		/*
		Scanner taLl_2 = new Scanner(System.in);
		Scanner weIght_2 = new Scanner(System.in); 
		int taLl2_1 = taLl_2.nextInt();
		int weIght2_1 = weIght_2.nextInt();

		int bMi = weIght2_1/((taLl2_1/100)*(taLl2_1/100));
		System.out.println("키 : "+taLl2_1);
		System.out.println("몸무게 : "+ weIght2_1);
		System.out.println("bmi : "+bMi);
		*/
		//------ 문제15 여기에 풀이-------//
		/*
		Scanner inCh = new Scanner( System.in );
		int inCh1 = inCh.nextInt();
		double cM = inCh1*2.54;
		System.out.println(inCh1+" inch");
		System.out.println(("="+cM)+"cm");
		*/
		//------ 문제16 여기에 풀이-------//
		/*
		Scanner middle = new Scanner(System.in);
		float middle1 = middle.nextFloat();
		Scanner fiNal = new Scanner(System.in);
		float fiNal1 = fiNal.nextFloat();
		Scanner evaluAtion = new Scanner(System.in);
		float evaluAtion1 = evaluAtion.nextFloat();
		
		System.out.println("중간고사 : "+middle1);
		System.out.println("기말고사 : "+fiNal1);
		System.out.println("수행평가 : "+evaluAtion1);
		
		float middle1_1 = middle1*0.3f;
		float fiNal1_1 = fiNal1*0.3f;
		float evaluAtion1_1 = evaluAtion1*0.4f;
		float toTal = middle1_1+fiNal1_1+evaluAtion1_1;
		
		System.out.printf("점수 : %.2f \n" , toTal );
		*/
		//------ 문제17 여기에 풀이-------// 
		
		
		//------ 문제18 여기에 풀이-------//
		/*
		Scanner aGe1 = new Scanner(System.in);
		byte aGe1_1 = aGe1.nextByte();
		String aGe1_2 = aGe1_1 >= 10 && aGe1_1 < 20 ? "학생" : 
							aGe1_1 >= 20 && aGe1_1 < 40 ? "성인" : 
								aGe1_1 >= 40 ? "중년" : "어린이" ;
		System.out.println(aGe1_2);
		*/
		//------ 문제19 여기에 풀이-------//
		/*
		Scanner koRean = new Scanner(System.in);
		Scanner engLish = new Scanner(System.in);
		Scanner maTh = new Scanner(System.in);
		
		float koRean1 = koRean.nextFloat();
		float engLish1 = engLish.nextFloat();
		float maTh1 = maTh.nextFloat();
		
		System.out.printf("국어 : %.0f \n" , koRean1);
		System.out.printf("영어 : %.0f \n" , engLish1);
		System.out.printf("수학 : %.0f \n" , maTh1);
		
		float aveRage = (koRean1+engLish1+maTh1)/3;
		System.out.printf("평균 : %.2f \n" , aveRage);
		*/
		//------ 문제20 여기에 풀이-------//
		
		Scanner iD = new Scanner(System.in);
		Scanner pW = new Scanner(System.in);
		
		String iD1 = iD.next();
		String pW1 = pW.next();
		
		String logIn = (iD1.equals("admin") && pW1.equals("1234")) ?
										"로그인성공" : "로그인실패" ;
		System.out.println("결과 : "+logIn);
		
		//------ 문제21 여기에 풀이-------//
		/*
		Scanner 정수1 = new Scanner(System.in);
		Scanner 정수2 = new Scanner(System.in);
		Scanner 정수3 = new Scanner(System.in);
		
		int 정수1_1 = 정수1.nextInt();
		int 정수2_1 = 정수2.nextInt();
		int 정수3_1 = 정수3.nextInt();
		
		int max = 정수1_1 ; 
		max = 정수2_1>max ? 정수2_1 : max ;
		max = 정수3_1>max ? 정수3_1 : max ;
		
		System.out.println("max : "+max);
		*/
		
		
	}

}


/*

문제1 : 강아지 console 출력
	|\_/|
	|q p|   /}
	( 0 )"""\
	|"^"`    |
	||_/=\\__|

문제2 : 입력받은 3개 데이터를 이용한 표 만들기 
	[입력변수]
		1. 작성자[문자열] , 내용[문자열] , 날짜[문자열] 입력받아 각 변수에 저장 
	[출력 예]
		   --------------방문록--------------------
		   | 순번  | 작성자  | 	내용 	| 날짜       |
		   |  1   | 강호동  |안녕하세요  |  09-28    |
		  ----------------------------------------
	
문제3 : 급여 계산
	[입력조건]
		기본급[정수] , 수당[정수]
	[ 조건 ] 
		 실수령액 = 기본급 + 수당 - 세금[기본급10%] 
	[출력조건] 
		실수령액 출력[ 소수점 없이  ]

문제4 : 지폐 세기 
	 [입력조건 ] 
		금액 
	 [조건 ] 
		 십만원 부터 백원 까지의 개수 세기 
	[ 출력조건 ]
		예) 356789 입력시 
		 십만원 3장 
		 만원 5장
		 천원 6장 
		 백원 7개

문제5 : 하나의 정수를 입력받아 7의 배수인지 출력[ 'O' 혹은 'X' 로 출력]

문제6 : 하나의 정수를 입력받아 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력]

문제7 : 하나의 정수를 입력받아 7의 배수 이면서 짝수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제8 : 하나의 정수를 입력받아 7의 배수 이거나 홀수 인지 출력 [ 'O' 혹은 'X' 로 출력 ]

문제9 : 두개의 정수를 입력받아 더 큰수 출력 

문제10 : 반지름을 입력받아 원 넓이 출력하기 
	계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

문제11 : 두 실수를 입력받아 앞실수의 값이 뒤의 값의 몇% 인지 출력하기 
	예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

문제12 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 
	계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2

문제13: 키를 정수를 입력받아 표준체중 출력하기 
	계산식) 표준체중 계산식 = > (키 - 100) * 0.9

문제14: 키와 몸무게를 입력받아 BMI 출력하기 
	계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))

문제15: inch 를 입력받아 cm 로 변환하기 
	계산식) 1 inch -> 2.54cm

문제16:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오 
	계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %

문제17 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
	int x = 10;
	int y = x-- + 5 + --x;
	printf(" x의 값 : %d , y의값 :  %d ", x, y)

문제18 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기

문제19 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력

문제20 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 로그인성공 아니면 로그인실패 출력

문제21 : 세 정수를 입력받아 가장 큰수 출력 

  
 */
