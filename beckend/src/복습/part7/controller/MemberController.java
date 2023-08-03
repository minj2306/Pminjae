package 복습.part7.controller;


public class MemberController {
	
	public static MemberController memberController = new MemberController();
	public static MemberController getInstance() {
		return memberController;
	}
	private MemberController() {}
	
	
}
