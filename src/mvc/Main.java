package mvc;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		dbclass db = new dbclass();
		String id = null;
		String name = null;
		int age = 0;
		
		student st = new student();
		Members mb = new Members();
		
		//db.createTable();
		
		int num;
		while(true) {
			System.out.println("1. 회원목록");
			System.out.println("2. 회원추가");
			System.out.println("3. 회원수정");
			System.out.println("4. 회원삭제");
			System.out.print(">>> ");
			num = input.nextInt();
			switch(num) {
			case 1:
				mb.memberView();
				break;
			case 2:
				System.out.print("추가할 아이디를 입력하시오 : ");
				id = input.next();
				System.out.print("추가할 이름을 입력하시오 : ");
				name = input.next();
				System.out.print("추가할 나이를 입력하시오 : ");
				age = input.nextInt();
				db.memberAdd(id, name, age);
				break;
			case 3:
				System.out.print("수정할 아이디를 입력하시오 : ");
				id = input.next();
				//st.setId(id);
				System.out.print("수정할 이름을 입력하시오 : ");
				name = input.next();
				//st.setName(name);
				System.out.print("수정할 나이를 입력하시오 : ");
				age = input.nextInt();
				//st.setAge(age);
				db.memberUpdate(id, name, age);
				break;
			case 4:
				System.out.print("삭제할 아이디를 입력하시오 : ");
				id = input.next();
				db.memberDelete(id);
				break;
			}
		}

	}

}
