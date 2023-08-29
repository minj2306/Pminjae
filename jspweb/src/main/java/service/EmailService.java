package service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {//이메일 전송에 관련된 클래스

	//1. 필드
	private String fromEmail = ""; // 보내는 사람의 이메일주소
	private String fromEmailPwd = ""; // 보내는 사람의 이메일주소 비밀번호
	
	//2. 생성자
	public EmailService() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//3. 메소드
		//1. 이메일 보내기 함수
	public boolean authsend( String toEmail , String contentHTML) {
		
		//1. 호스팅 설정 [ 네이버 기준 ]
		Properties properties = new Properties(); //Properties : 키와 값으로 구성된 map 컬렉션중 하나. [ 설정 관련된 데이터 객체화 ]
		properties.put("mail.smtp.host" , "smtp.naver.com");
		properties.put("mail.smtp.port", 587 );
		properties.put("mail.smtp.auth", true);
		properties.put( "mail.smtp.ssl.protocols", "TLSv1.2");
		
		//2. 인증처리 [ 네이버에 보내는 사람의 정보가 맞는지 ]
		
			//Authenticator 인증할 객체
		Authenticator authenticator = new Authenticator() {
			//패스워드 검증함수 [ 구현 ]
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( fromEmail , fromEmailPwd );
			}
		};
			//Authenticator : import javax.mail.Authenticator;
				//.getPasswordAuthentication( return new PasswordAuthentication( "보내는 사람 이메일" , "" ) ) : 패스워드 검증 [인증메소드 구현]
		
			//session : 인증후 결과 정보를 담고있는 객체
		Session session = Session.getDefaultInstance(properties , authenticator);
			// Session : import javax.mail.Session
			// .getDefaultInstance( 호스트설정Properties , 인증할계정정보가 담긴 인증객체 )
	
		//3. 메일전송
		try {
			// Mime 프로토콜 : smtp 가 보낼수 있는 표준 형식 / 포멧 
			// MimeMessage 객체 설정
			MimeMessage message = new MimeMessage(session);
				//2. .setFrom( new InternetAddress( 보내는 사람의 이메일주소 ) )
			message.setFrom( new InternetAddress(fromEmail) );
				//3. .addRecipient( Message.RecipientType.TO , 받는 사람의 이메일주소 )
			message.addRecipient( Message.RecipientType.TO , new InternetAddress( toEmail ) );
				//4. .setSubject(메일제목);
			message.setSubject("Ezen JSP 회원가입 인증코드 발송");
			  	//5. .setText("메일내용");
			message.setText("안녕하세요. 이메일 인증코드 : " + contentHTML);
				//*메일전송 
				//Transport.send( mime 객체 );
			Transport.send(message);
			return true;//메일전송 성공
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false; // 메일전송 실패
	}
}

/*
 	메일전송 함수 만들기
 	
 		1. 호스트 설정
 		Properties properties = new Properties(); 
		properties.put("mail.smtp.host" , "호스트의 주소");
		properties.put("mail.smtp.port", 호스트 포트 번호 );
		properties.put("mail.smtp.auth", true);
		properties.put( "mail.smtp.ssl.protocols", "TLSv1.2");
 
 		2. 보내는 사람 계정 인증객체
 		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( "보내는 사람 이메일" , "보낸사람의 이메일 비밀번호" );
 		
 		3. 인증처리와 인증겨로가 객체
 		Session session = Session.getDefaultInstance(properties , authenticator);
		
		4. 보내는 내용 설정
 			MimeMessage message = new MimeMessage( 인증된 세션 객체 );
			
			message.setFrom( new InternetAddress("보내는 사람의 이메일 주소") );
			
			message.addRecipient( Message.RecipientType.TO , new InternetAddress( 받는사람의 이메일주소 ) );
			
			message.setSubject("메일제목");
			
			message.setText("메일내용");
 */
 
