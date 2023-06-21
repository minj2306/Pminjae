
/*  조건 : 반복문X 입력:prompt 출력 : console 
       문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
       문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
       
       문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       
       문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
       문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
       문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인실패 출력*/
//문제1
	//1. 입력받아 변수에 저장                               
let 정수1 = Number(prompt("정수1 : "));
let 정수2 = Number(prompt("정수2 : "));
	//2. if 이용한 논리제어
if(정수1>정수2){console.log(정수1 + "이 크다")}
else{console.log(정수2 + "이 크다")};

//문제2
let 정수3 = Number(prompt("정수3"));
let 정수4 = Number(prompt("정수4"));
let 정수5 = Number(prompt("정수5"));
let max1 = 정수3;
if(max1<정수4){max1 = 정수4}
if(max1<정수5){max1 = 정수4}
console.log(max1)

//문제3
let 정수6 = Number(prompt("정수6"));
let 정수7 = Number(prompt("정수7"));
let 정수8 = Number(prompt("정수8"));
let 정수9 = Number(prompt("정수9"));
                                   
let max2 = 정수6;                                
if(max2<정수7){max1 = 정수7}
if(max2<정수8){max1 = 정수8}
if(max2<정수9){max1 = 정수9}

console.log(max2)                     

//문제4                                     
let int1 = Number(prompt("정수10")); //3
let int2 = Number(prompt("정수11")); //5
let int3 = Number(prompt("정수12")); //2                                    

// 정렬 = 하나씩 비교해서 자리 교체 
if(int1 > int2){ // >오름차순 <내림차순
	let temp = int1; //1. 임시변수에 3저장 
	int1 = int2; //2. 3있던 변수에 5 저장 
	int2 = temp // 3. 5 있던 변수에 2 저장
}                                    
                                     
if(int1 > int3){
	let temp = int1;
	int1 = int3; 
	int3 = temp  
}                                                             
                                     
if(int2 > int3){
	let temp = int2; 
	int2 = int3; 
	int3 = temp 
}                                                             
console.log(int1 + ' ' +int2 + ' '+int3)                                     
                                     
//문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
let int4 = Number(prompt("정수13")); 
let int5 = Number(prompt("정수14")); 
let int6 = Number(prompt("정수15"));     
let int7 = Number(prompt("정수16"));

if(int4 > int5){
	let temp1 = int4; 
	int4 = int5; 
	int = tem
}      

//문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
let 점수 = Number(prompt("점수를 입력 "))
if(점수>=90){console.log('합격 ')}
else{console.log("탈락 ")}

/*문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험*/
let 점수1 = Number(prompt("점수를 입력 "))
if(점수1>=90){console.log('A등급 ')}
else if(점수1>=80){console.log( 'B등급 ')}
else if(점수1>=70){console.log( 'C등급 ')}
else{console.log('재시험 ')}

/*문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인실패 출력*/
let 아이디 = prompt("아이디 입력 ")
let 비번 = prompt("비밀번호 입력 ")

if(아이디=='admin'){
	if (비번=='1234'){console.log( ' 로그인 성공 ')}
	else{console.log( ' 비밀번호 틀림 ')} }
else{console.log('아이디 틀림 ')}                            
                                     