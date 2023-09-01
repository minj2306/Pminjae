/**
 * 
 */
console.log('write.js 왔다')


function lwrite(){
	
	//1. form 가져오기
	let writeForm = document.querySelectorAll('.writeForm')[0];
	console.log(writeForm);
	//2. form 객체화하기
	let writeData = new FormData( writeForm );
	console.log (writeData);
}