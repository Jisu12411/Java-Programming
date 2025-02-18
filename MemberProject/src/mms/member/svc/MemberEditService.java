package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberEditService {
	
	MemberDAO memberDAO = new MemberDAO();
	
	// 수정된 회원 정보를 DAO를 통해 반영
	public boolean editMember(Member editMember) throws Exception{
		
		boolean isEditSuccess = false;
		
		isEditSuccess = memberDAO.editMember(editMember);
		
		return isEditSuccess;
		
	}
	
	// 수정 전, 입력받은 ID에 해당하는 기존 회원 정보를 조회
	public Member editExMember(int editMemberID) throws Exception {
		
		Member editExMember = memberDAO.getEditMember(editMemberID); 
		
		// 조회 결과가 없으면 예외 발생
		if (editExMember == null) {
            throw new Exception("해당 ID의 회원이 존재하지 않습니다.");
        }
		
		return editExMember;
		
	}

}
