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
			System.out.println("1. ȸ�����");
			System.out.println("2. ȸ���߰�");
			System.out.println("3. ȸ������");
			System.out.println("4. ȸ������");
			System.out.print(">>> ");
			num = input.nextInt();
			switch(num) {
			case 1:
				mb.memberView();
				break;
			case 2:
				System.out.print("�߰��� ���̵� �Է��Ͻÿ� : ");
				id = input.next();
				System.out.print("�߰��� �̸��� �Է��Ͻÿ� : ");
				name = input.next();
				System.out.print("�߰��� ���̸� �Է��Ͻÿ� : ");
				age = input.nextInt();
				db.memberAdd(id, name, age);
				break;
			case 3:
				System.out.print("������ ���̵� �Է��Ͻÿ� : ");
				id = input.next();
				//st.setId(id);
				System.out.print("������ �̸��� �Է��Ͻÿ� : ");
				name = input.next();
				//st.setName(name);
				System.out.print("������ ���̸� �Է��Ͻÿ� : ");
				age = input.nextInt();
				//st.setAge(age);
				db.memberUpdate(id, name, age);
				break;
			case 4:
				System.out.print("������ ���̵� �Է��Ͻÿ� : ");
				id = input.next();
				db.memberDelete(id);
				break;
			}
		}

	}

}
