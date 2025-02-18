package mms.member.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {
	
	// 회원 정보를 저장할 리스트 (멀티스레드 환경 고려를 위해 CopyOnWriteArrayList 사용)
	static List<Member> memberList = new CopyOnWriteArrayList<Member>();
	
	// 새 회원을 리스트에 추가
	public boolean insertNewMember(Member newMember) {
		
		boolean isInsertSuccess = memberList.add(newMember);
		
		return isInsertSuccess;
	}
	
	// 현재 등록된 회원 목록을 반환
	public static List<Member> getMemberList() {
		return memberList;
	}
	
	// 특정 ID 회원 삭제
	public static boolean deleteMember(int deleteMemberID) {
		
		boolean isDeleteSuccess = false;
		
		isDeleteSuccess = memberList.removeIf(member -> member.getId() == deleteMemberID);
		return isDeleteSuccess;	
	}
	
	// 모든 회원 삭제
	public static boolean deleteAllMember() {
		if (memberList.isEmpty()) {
			return false;
		}
		memberList.clear();
		return true;
	}
	
	// 특정 ID 회원 조회 (수정할 회원 정보를 얻기 위함)
	public static Member getEditMember(int editMemberID) {
		
		Member editMember = null;
		
		for(Member m : memberList)
			if( m.getId() == editMemberID) {
				editMember = m;
			}
		
		return editMember;
	}
	
	// 특정 회원 정보를 수정
	public static boolean editMember(Member editMember) {
		
		boolean isEditSuccess = false;
		
		for(Member m : memberList) {
			if(editMember.getId() == m.getId()) {
				m.setAll(editMember); // 수정할 정보만 덮어씀
				isEditSuccess = true;
				break;
			}
		}	
	    return isEditSuccess;	
	}
}
