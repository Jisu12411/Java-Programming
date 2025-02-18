package mms.member.ui;

import java.util.Scanner;

import mms.member.action.Action;
import mms.member.action.MemberAddAction;
import mms.member.action.MemberDeleteAction;
import mms.member.action.MemberEditAction;
import mms.member.action.MemberListAction;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("====회원관리 프로그램====");
			System.out.println("[1]회원등록");
			System.out.println("[2]회원목록 보기");
			System.out.println("[3]회원정보 수정");
			System.out.println("[4]회원정보 삭제");
			System.out.println("[5]프로그램 종료");
			System.out.println("======================\n");
			
			int menu = 0;
			
			while (true) {
                try {
                    System.out.print("[메뉴번호 입력] => ");
                    menu = sc.nextInt();
                    
                    sc.nextLine();  // ← 이 한 줄을 추가하면, 바로 뒤의 nextLine() 입력이 꼬이지 않음

                    if (menu >= 1 && menu <= 5) {
                        break;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    sc.nextLine(); // 잘못된 입력(문자 등)으로 생긴 버퍼를 비움
                    System.out.println("\n* 메뉴를 잘못 선택하셨습니다.");
                    System.out.println("* (1 ~ 5)메뉴를 다시 입력해주세요.");
                }
            }
			
			Action action = null;
			
			switch(menu) {
				case 1:
					action = new MemberAddAction();
					break;
				case 2:
					action = new MemberListAction();
					break;
				case 3:
					action = new MemberEditAction();
					break;
				case 4:
					action = new MemberDeleteAction();
					break;
				case 5:
					System.out.println("**프로그램 종료**");
					isStop = true;
					break;
				default:
					// 잘못 입력하면 즉시 종료 (위 예외 처리로 인해 실제 도달 X)
					break; 
			}
			
			if(!isStop) {
				try {
					action.execute(sc);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} while(!isStop); 
	}

}
