package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberEditService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberEditAction implements Action { // 회원정보 수정 액션 클래스

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		MemberEditService memberService = new MemberEditService();
		
		// 수정할 회원 ID 입력받기
		int editMemberID = cu.editMemberID(sc);
		
		Member editExMember = null;
		
        // 수정할 회원이 존재하는지 확인(반복해서 ID 재입력 가능)
        while (editExMember == null) {
            try {
                // 해당 ID의 회원 정보를 가져옴
                editExMember = memberService.editExMember(editMemberID);
            } catch (Exception e) {
                // 예외 메시지 출력 후 다시 ID 입력받기
                System.out.println(e.getMessage());
                editMemberID = cu.editMemberID(sc);
            }
        }
        
        // 실제 수정할 회원 정보(주소, 이메일, 국가, 나이 등) 입력받기
        Member editMember = cu.getEditMember(editExMember, sc);

        // 수정 처리
        boolean isEditSuccess = memberService.editMember(editMember);
		
		if(isEditSuccess) {
			System.out.println("[" + editMemberID + " 회원 정보 수정 성공]");
		}else {
			System.out.println("**회원정보 수정 실패**");
		}
		
	}

}
