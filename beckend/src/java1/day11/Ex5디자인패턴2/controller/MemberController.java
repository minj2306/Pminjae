package java1.day11.Ex5디자인패턴2.controller;

import java.util.Random;

import java1.day11.Ex5디자인패턴2.model.dao.MemberDao;
import java1.day11.Ex5디자인패턴2.model.dto.MemberDto;
import 과제.과제10.Member;

public class MemberController {//기능처리 (로직) 담당하는 클래스
	//1. 싱글톤 생성 [ private static ]
	private static MemberController memberController = new MemberController();
	//2. 외부로부터 싱글톤 호출할 수 있도록 get~
	public static MemberController getInstance() { return memberController; }
	//3. 외부에서 객체 생성 차단 위한 생성자 잠금
	private MemberController() { }
	
	public boolean sineupLogic ( String inputID , String inputPw , String inputName , String inputPh , int inputAge) {
		MemberDto memberDto = new MemberDto(inputID , inputPw , inputName , inputPh , inputAge );
		for(int i =0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] == null ) {
				MemberDao.memberList[i] = memberDto;
				return true;
			}//if end
		}//for end
		return false;
	}
	public boolean loginLogic (String inputID , String inputPw) {
		
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] != null &&
					MemberDao.memberList[i].getId().equals(inputID) && 
					MemberDao.memberList[i].getPassword().equals(inputPw)) {
					return true;
			}//if end
		}//for end
		return false;
	}
	public String findIdLogic ( String inputName , String inputPh ) { 
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] != null &&
					MemberDao.memberList[i].getName().equals(inputName) && 
					MemberDao.memberList[i].getPhone().equals(inputPh)) {
				return MemberDao.memberList[i].getId() ;
			}//if end
		}//for end
		return "";
	}
	public String findPwLogic (String inputID , String inputPh ) {
		Random random = new Random();
		String newpw = "";
		for(int i = 0; i<MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i] != null &&
					MemberDao.memberList[i].getId().equals(inputID) && 
					MemberDao.memberList[i].getPhone().equals(inputPh)) {
					for(int j = 1; j<=4; j++) {
						 newpw += (char)((int)(random.nextInt(26)+97));
					}
					MemberDao.memberList[i].setPassword(newpw);
					return newpw;
			}//if end
		}//for end
		return "";
	}
	
	
}
