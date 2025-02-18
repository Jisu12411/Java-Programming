package mms.member.svc;

import java.util.List;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberListService {

	private MemberDAO memberDAO;
	
	public MemberListService() {
		// DAO 객체 생성
		this.memberDAO = new MemberDAO();
	}
	
	// 전체 회원 목록을 반환
	public List<Member> getMemberList() {
        return memberDAO.getMemberList();
	}
	
}
