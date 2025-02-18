package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberDeleteService;
import mms.member.util.ConsoleUtil;

public class MemberDeleteAction implements Action { // 회원정보 삭제 액션 클래스

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		// 삭제할 회원 ID(또는 전체 삭제 시 0) 입력받기
		int deleteMemberID = cu.deleteMemberID(sc);
		
		// 삭제 진행 전 최종 확인(Y/N) → ConsoleUtil로 분리
		boolean isConfirmed = cu.confirmDelete(sc);
		if(!isConfirmed) {
			System.out.println("취소하셨습니다.");
			return;
		}
		
		MemberDeleteService memberService = new MemberDeleteService();
		boolean isDeleteSuccess = false;
		
		// ID가 0이면 전체 삭제, 0이 아니면 해당 ID만 삭제
		if (deleteMemberID == 0) {
            isDeleteSuccess = memberService.deleteAllMember();
            if (isDeleteSuccess) {
                System.out.println("모든 회원 정보 삭제 완료");
            } else {
                System.out.println("삭제할 회원 정보가 없습니다.");
            }
        } else {
            isDeleteSuccess = memberService.deleteMember(deleteMemberID);
            if (isDeleteSuccess) {
                System.out.println("[" + deleteMemberID + "]회원 정보 삭제 완료");
            } else {
            	System.out.println("해당 회원 ID를 찾을 수 없습니다.");
            }
        } 
	}

}
