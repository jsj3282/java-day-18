package mvc;

import java.util.ArrayList;

public class Members {
	dbclass db = new dbclass();
	
	ArrayList<student> arr = new ArrayList<student>();
	public void memberView(){
		arr = db.memberView();
		System.out.println("id\tname\t\tage");
		System.out.println("----------------------------");
		for(int i = 0; i<arr.size(); i++) {
			System.out.print(arr.get(i).getId()+ "\t");
			System.out.print(arr.get(i).getName() + "\t\t");
			System.out.println(arr.get(i).getAge() + "\t");
		}
		System.out.println(arr.size());
		
	}
	
	
		
		
}
