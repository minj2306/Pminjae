package 복습.part7.controller;

import 복습.part7.model.dao.MemberDao;
import 복습.part7.model.dto.MemberDto;
import 복습.part7.view.MainPage;

public class MemberController {

	private static MemberController memberController = new MemberController();
	
	public static MemberController getinstance() {
		return memberController;
	}
	private MemberController() { }

	public boolean sineup( String id , String pw , String name , String phone , int age ) {
		
		MemberDto memberDto = new MemberDto(id, pw, name, phone, age);
		
		for(int i = 0; i< MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i]==null) {
				MemberDao.memberList[i]=memberDto;
				return true;
			}
		}
		return false;
	}
	public boolean login( String id , String pw ) {
		
		for(int i = 0; i< MemberDao.memberList.length; i++) {
			if(MemberDao.memberList[i]!=null &&
					MemberDao.memberList[i].getId().equals(id) &&
					MemberDao.memberList[i].getPw().equals(pw)) {
				return true;
			}
		}
		return false;
		
	}
}
