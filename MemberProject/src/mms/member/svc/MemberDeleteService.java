package mms.member.svc;

import mms.member.dao.MemberDAO;

public class MemberDeleteService {
	
	public boolean deleteMember(int deleteMemberID) throws Exception{
		
		boolean isDeleteSuccess = false;
		
		MemberDAO memberDAO = new MemberDAO();
		// DAO를 통해 특정 회원 삭제
		isDeleteSuccess = memberDAO.deleteMember(deleteMemberID);
		
		return isDeleteSuccess;
		
	}
	
	// 모든 회원 삭제
	public boolean deleteAllMember() {
		return MemberDAO.deleteAllMember();
	}

}
