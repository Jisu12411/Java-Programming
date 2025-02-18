package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberAddService {
	
	public boolean addMember(Member newMember) throws Exception{
		
		boolean isAddSuccess = false;
		
		// DAO 객체를 생성해 새 회원을 추가
		MemberDAO memberDAO = new MemberDAO();
		isAddSuccess = memberDAO.insertNewMember(newMember);
		
		return isAddSuccess;
		
	}
}
