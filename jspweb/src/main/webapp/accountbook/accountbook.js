/**
 * 
 */

 function inPut(){
	 console.log('input 열림')
	 
	 let textAcc = document.querySelector('.textAcc'); console.log('textAcc :'+textAcc);
	 let numberAcc = document.querySelector('.numberAcc'); console.log('numberAcc'+numberAcc);
	 let dateAcc = document.querySelector('.dateAcc'); console.log('dateAcc'+dateAcc);
 
 	 let Accinfo = {
		  textAcc : textAcc.value  ,
		  numberAcc : numberAcc.value ,
		  dateAcc : dateAcc.value
	  }; console.log(Accinfo)
	  
	  $.ajax({
		  url : "/jspweb/AccountBook" ,
		  method : "post" ,
		  data : Accinfo ,
		  success : function f(r){
			  if(r==true){
				  alert('S2가계부 등록 성공S2')
				  textAcc.value = '';
				  numberAcc.value = '';
				  dateAcc.value = '';
				  Aread();
			  }
		  } ,
		  error : function f(r){}
	  })
 }//inPut end
 Aread();
 function Aread(){
	
	$.ajax({
		  url : "/jspweb/AccountBook" ,
		  method : "get" ,
		  data : "" ,
		  success : function f(r){
			
			let output = document.querySelector('.accuntTable');
			let html = ``;
			
			for(let i = 0; i<r.length; i++){
				html+=`
					<tr>
						<td>${r[i].ano}</td><td>${r[i].date}</td><td>${r[i].atext}</td><td>${r[i].anumber}</td>
						<td class="choiceBtn"><button onclick="Amodify( ${r[i].ano} )">수정</button><button onclick="Adelete( ${r[i].ano} )" >삭제</button> </td>
					</tr>
					`
			}//for end
			output.innerHTML = html;
			
				
		  } ,
		  error : function f(r){}
	  })
	
 }
 
 function Amodify( ano ){
	 
	 let select = prompt('수정할 항목 \n 1.날짜 2.항목 3.금액');
	 if( select == 1){
		 let date = prompt('수정할 날짜 입력 \n YYYY-MM-DD');
		
		 $.ajax({
			 url : "/jspweb/AccountBook" ,
			 method : "put" ,
			 data : { ano : ano , date : date , select : select } ,
			 success : function f(r){
				 if(r==true){
					 alert('수정성공'); Aread();
				 }
				 else{ alert('수정실패') }
			 },
			 error : function f(r){}
		 })
	 }
	 else if( select == 2){
		 let atext = prompt('수정할 항목 입력');
		
		 $.ajax({
			 url : "/jspweb/AccountBook" ,
			 method : "put" ,
			 data : { ano : ano , atext : atext , select : select } ,
			 success : function f(r){
				 if(r==true){
					 alert('수정성공'); Aread();
				 }
				 else{ alert('수정실패') }
			 },
			 error : function f(r){}
		 })
	 }
	 else if( select == 3){
		 let anumber = prompt('수정할 금액 입력');
		 
		 $.ajax({
			 url : "/jspweb/AccountBook" ,
			 method : "put" ,
			 data : { ano : ano , anumber : anumber , select : select } ,
			 success : function f(r){
				 if(r==true){
					 alert('수정성공'); Aread();
				 }
				 else{ alert('수정실패') }
			 },
			 error : function f(r){}
		 })
	 }
 }
 
 function Adelete( ano ){
	 
	 $.ajax({
		 url : "/jspweb/AccountBook" ,
		 method : "delete" ,
		 data : { ano : ano } ,
		 success : function f (r){
			 if(r==1){
				 alert('삭제성공');  Aread();
			 }
			 else{alert('삭제실패');}
		 } ,
		 error : function f (r){}
	 })
	 
 }
 
 