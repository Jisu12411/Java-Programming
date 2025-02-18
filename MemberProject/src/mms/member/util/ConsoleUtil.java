package mms.member.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import mms.member.vo.Member;

public class ConsoleUtil {
	
	static int id = 1; // 회원 등록 시 자동 증가될 ID
	
	// 새 회원 정보를 입력받아 Member 객체로 반환
	public Member getNewMember(Scanner sc) {
		
		System.out.println("===등록할 회원 정보를 입력하세요===");

		// [이 름]
		System.out.print("[이 름] => ");
		String name = sc.nextLine();  // nextLine()으로 한 줄 전체 입력
		
		// [주 소]
		System.out.print("[주 소] => ");
		String addr = sc.nextLine();
		
		// [이메일]
		System.out.print("[이메일] => ");
		String email = sc.nextLine();
		
		// [국 가]
		System.out.print("[국 가] => ");
		String nation = sc.nextLine();
		
		// [나 이]
		int age = 0;
		while (true) {
		    try {
		        System.out.print("[나 이] => ");
		        // nextInt() 사용 시, 입력 후 남는 개행문자를 처리해야 하므로 주의
		        age = sc.nextInt(); 
		        sc.nextLine(); // ★ nextInt() 후 개행 버퍼 제거
		        
		        if (age > 0) { 
		            break; 
		        } else {
		            System.out.println("* 나이는 1 이상 입력해주세요.");
		        }
		    } catch (Exception e) {
		        sc.nextLine(); 
		        System.out.println("* 잘못된 입력입니다. 숫자로 다시 입력해주세요.");
		    }
		}
		
		return new Member(id++, name, addr, email, nation, age);
	}
	
	// 특정 회원 ID 입력(전체 목록은 0)
	public int listNumber(Scanner sc) {
		
		int num = 0;
		boolean valid = false;
		
		while(!valid) {
			System.out.print("[보실 목록에 회원ID 입력(전체 목록 [0]입력)] => ");
			try {
				num = sc.nextInt();
				sc.nextLine(); // nextInt() 후 버퍼 제거
				valid = true;
			} catch (InputMismatchException e) {
	            System.out.println("* ID는 숫자로만 입력해주세요");
	            sc.nextLine(); 
			}
		}
		
		return num;
	}

	// 수정할 회원 ID 입력
	public int editMemberID(Scanner sc) {
		
		int id = 0;  
	    
	    while (true) {
	        try {
	            System.out.println("===회원정보 수정하기===");
	            System.out.print("[수정할 회원ID 입력] => ");
	            id = sc.nextInt();
	            sc.nextLine(); // 개행 버퍼 제거

	            if (id > 0) {
	                break; 
	            } else {
	                System.out.println("**회원 ID는 1 이상의 숫자여야 합니다. 다시 입력해주세요.**");
	            }

	        } catch (java.util.InputMismatchException e) {
	            sc.nextLine(); 
	            System.out.println("**숫자만 입력해주세요. 다시 시도하세요.**");
	        }
	    }
	    
	    return id; 
	}
	
	// 수정할 회원 정보를 입력받아 Member 객체로 반환
	public Member getEditMember(Member editExMember, Scanner sc) {
		
		System.out.println("===수정할 회원 정보를 입력하세요===");

		int id = editExMember.getId();
		String name = editExMember.getName(); // 이름은 변경하지 않음
		
		System.out.print("[이전 주소]" + editExMember.getAddr() +"      [주 소] => ");
		String addr = sc.nextLine();
		
		System.out.print("[이전 이메일]" + editExMember.getEmail() +"     [이메일] => ");
		String email = sc.nextLine();
		
		System.out.print("[이전 국가]" + editExMember.getNation() +"      [국 가] => ");
		String nation = sc.nextLine();
		
		int age = 0;
		while(true) {
			try {
				System.out.print("[이전 나이]" + editExMember.getAge() +"      [나 이] => ");
				age = sc.nextInt();
				sc.nextLine(); // 버퍼 제거
				if(age > 0) {
					break;
				} else {
					System.out.println("* 나이는 1 이상 입력해주세요.");
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("* 잘못된 입력입니다. 숫자로 다시 입력해주세요.");
			}
		}
		
		return new Member(id, name, addr, email, nation, age);
	}
	
	// 삭제할 회원 ID 입력(0이면 전체 삭제)
	public int deleteMemberID(Scanner sc) {
		
		int id = -1;  

        while (true) {
            try {
                System.out.println("===회원정보 삭제하기===");
                System.out.print("[삭제할 회원ID 입력(전체 삭제 [0]입력)] => ");
                id = sc.nextInt();
                sc.nextLine(); // 버퍼 제거

                if (id > -1) {
                    break;  
                } else {
                    System.out.println("**회원 ID는 [0]또는 회원ID를 입력해주세요.**");
                }

            } catch (java.util.InputMismatchException e) {
                sc.nextLine();  
                System.out.println("**숫자만 입력해주세요. 다시 시도하세요.**");
            }
        }
		
		return id;
	}

	// 삭제 여부 재확인(Y/N)
	public boolean confirmDelete(Scanner sc) {
		while(true) {
        	System.out.println("삭제하시겠습니까? [Y]/[N]");
        	String confirm = sc.next().trim().toUpperCase();
        	if(confirm.equals("Y")) {
        		return true; 
        	} else if(confirm.equals("N")){
        		return false; 
        	} else {
        		System.out.println("잘못된입력입니다.[Y]또는[N]을 입력해주세요.");
        	}
        }
	}
}
