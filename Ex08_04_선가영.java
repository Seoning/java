import java.util.Scanner;

class Person{
	String id;
	String pw;
	String name;

	Person(String id,String pw,String name){
		this.id=id;
		this.pw = pw;
		this.name = name;
	}
}
public class Ex08_04_선가영 {

	public static void main(String[] args) {
		Person[] p = {new Person("kim","1234","김연아"),
				new Person("son","7777","손흥민"),
				new Person("jang","9876","장미란")
		};

		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			int i=0;
			System.out.print("id입력:");
			String id = sc.next();
			System.out.print("pw입력:");
			String pw = sc.next();
			String y = "y";
			String n = "n";

			for(i=0;i<p.length;i++) {
				if(p[i].id.equals(id) && p[i].pw.equals(pw)) {
					System.out.println(p[i].name+"님 반갑습니다.");
					System.out.println("계속?");
				}
				else if(p[i].id.equals(id)) {
					System.out.println("비번이 맞지 않습니다.");
					System.out.println("계속?");
					
				}
				else if(p[i].pw.equals(pw)) {
					System.out.println("해당 아이디가 없습니다.");
					System.out.println("계속?");
					
				}
			}
			if(id.length()<=2 || id.length()>=8) {
				System.out.println("id는 3글자~8글자 입력해야 합니다.");
				System.out.println("계속?");
			}
				
			if(sc.next().equals(n))
				break;
		}//while
		System.out.println("프로그램을 종료합니다.");

	}//main

}
/*
id입력:son -> equals or compareTo.
pw입력:7777
손흥민님 반갑습니다.
계속?y
id입력:jang
pw입력:9876
장미란님 반갑습니다.
계속?y
id입력:son
pw입력:1212
비번이 맞지 않습니다.
계속?y
id입력:park
pw입력:9999
해당 아이디가 없습니다.
계속?y
------------------------
id입력:so
id는 3글자~8글자 입력해야 합니다.
id입력:sdfsfdsfsdfs
id는 3글자~8글자 입력해야 합니다. -> .length
id입력:kim
pw입력:1234
김연아님 반갑습니다.
계속?n -> while문 사용.
프로그램을 종료합니다.
 */
