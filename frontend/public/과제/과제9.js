/**
 * 
 */
/* 문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]
   문제12 : [ 가위바위보 게임 ] 
   - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다. 
   - 승리자 판단과 무승부 경우의수를 출력하시오.
   [입력]
      플레이어1가 0 혹은 1 혹은 2 입력받아 변수에 저장합니다.
      플레이어2가 0 혹은 1 혹은 2 입력받아 변수에 저장합니다.
   [경우의수 판단]
      플레이어1 이겼을때 경우의수 ' 플레이어1 승리 ' 출력
      플레이어2 이겼을때 경우의수 ' 플레이어2 승리 ' 출력
      비겼을경우 '무승부' 출력*/


// 문제 11
let a = Number(prompt("1번"))
let b = Number(prompt("2번"))
let c = Number(prompt("3번"))

let min = a
min = min<b ? min : b
min = min<c ? min : c 

let max =a
max = max>b ? max :b
max = max>c ? max :c 


console.log("작은수"+min)
console.log("중간수"+mid)
console.log("큰수"+max)      
