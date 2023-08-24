<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<!-- 대문 -->
	<h3>대문</h3>
	
	<!-- JSP 파일안에 다른 JSP 파일 import 하기 -->
	<%@ include file="footer.jsp" %>

</body>-
</html>
<!--
		ip : 네트워크(인터넷) 사용하는 컴퓨터의 식별번호 [ip당 1개]
			ip : localhost / 192.168.17.134
			-cmd ->ipconfig
			
		port : 컴퓨터 내 프로그램 식별하는 번호 [pc 1개당 프로그램명 여러개 -> port 여러개]
				mysql : 3306 권장
				톰캣서버 : 8080 권장
				http : 80 권장
					-cmd - > netstat -ano
						-여기서 
		
		JAVA
			.java -> 실행[ctrl +f11] -> .class -> console 실행
						컴파일러[번역]
	  	JSP
	  		.jsp -> 실행[ctrl +f11] -> 톰캣[서버]
	  				서버에 파일 빌드
	  -->
	