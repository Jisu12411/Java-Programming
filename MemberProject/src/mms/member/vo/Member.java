package mms.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Member {
	
	private int id;         // 회원 고유 ID
	private String name;    // 회원 이름
	private String addr;    // 회원 주소
	private String email;   // 회원 이메일
	private String nation;  // 회원 국가
	private int age;        // 회원 나이

	// 전달받은 Member 객체의 필드만 변경(이름 제외)
	public void setAll(Member newMember) {
        this.addr = newMember.getAddr();
        this.email = newMember.getEmail();
        this.nation = newMember.getNation();
        this.age = newMember.getAge();
    }
	
}
