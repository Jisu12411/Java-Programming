package mms.member.action;

import java.util.List;
import java.util.Scanner;

import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberListAction implements Action { // 회원목록 조회 액션 클래스

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		
		MemberListService memberService = new MemberListService();
		// 전체 회원 목록을 가져옴
		List<Member> members = memberService.getMemberList();
		
		// 회원 목록이 비어 있는 경우 처리
        if (members.isEmpty()) {
            System.out.println("[등록된 회원 정보가 없습니다]");
            return;
        }
		
		boolean isValidId = false;
		int listNumber = 0;

        // 특정 ID의 회원 정보 조회 혹은 0 입력 시 전체 목록 출력
        while (!isValidId) {
            listNumber = cu.listNumber(sc); // 회원 ID 입력

            if (listNumber == 0) {
                // 0이면 전체 목록 출력
                for (Member member : members) {
                    System.out.println(member);
                }
                return; // 전체 목록 출력 후 종료
            }

            // 입력한 ID가 존재하는지 확인
            for (Member member : members) {
                if (member.getId() == listNumber) {
                    System.out.println(member);
                    isValidId = true; // 유효한 ID
                    break;
                }
            }

            // 존재하지 않는 ID인 경우 재입력 유도
            if (!isValidId) {
                System.out.println("\n[없는 회원 아이디 입니다. 다시 입력해주세요.]");
            }
        }
		
	}

}
