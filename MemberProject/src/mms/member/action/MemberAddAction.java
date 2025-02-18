package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action { // 회원정보 등록 액션 클래스

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		// 새 회원 정보를 입력받아 Member 객체 생성
		Member newMember = cu.getNewMember(sc);

		MemberAddService memberService = new MemberAddService();
		// 입력받은 회원 정보를 데이터베이스(혹은 리스트)에 추가하는 로직
		boolean isAddSuccess = memberService.addMember(newMember);
		
		// 결과에 따라 메시지 출력
		if(isAddSuccess) {
			System.out.println("["+ "[" +newMember.getName() + "]" +"회원 정보 추가 성공]");
		}else {
			System.out.println("**회원정보 추가 실패**");
		}
	}

}
