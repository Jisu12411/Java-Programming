package mms.member.action;

import java.util.Scanner;

public interface Action {
	
	// 각 액션 클래스에서 반드시 구현해야 하는 메서드
	void execute(Scanner sc) throws Exception;
}
