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
public class Ex08_04_������ {

	public static void main(String[] args) {
		Person[] p = {new Person("kim","1234","�迬��"),
				new Person("son","7777","�����"),
				new Person("jang","9876","��̶�")
		};

		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			int i=0;
			System.out.print("id�Է�:");
			String id = sc.next();
			System.out.print("pw�Է�:");
			String pw = sc.next();
			String y = "y";
			String n = "n";

			for(i=0;i<p.length;i++) {
				if(p[i].id.equals(id) && p[i].pw.equals(pw)) {
					System.out.println(p[i].name+"�� �ݰ����ϴ�.");
					System.out.println("���?");
				}
				else if(p[i].id.equals(id)) {
					System.out.println("����� ���� �ʽ��ϴ�.");
					System.out.println("���?");
					
				}
				else if(p[i].pw.equals(pw)) {
					System.out.println("�ش� ���̵� �����ϴ�.");
					System.out.println("���?");
					
				}
			}
			if(id.length()<=2 || id.length()>=8) {
				System.out.println("id�� 3����~8���� �Է��ؾ� �մϴ�.");
				System.out.println("���?");
			}
				
			if(sc.next().equals(n))
				break;
		}//while
		System.out.println("���α׷��� �����մϴ�.");

	}//main

}
/*
id�Է�:son -> equals or compareTo.
pw�Է�:7777
����δ� �ݰ����ϴ�.
���?y
id�Է�:jang
pw�Է�:9876
��̶��� �ݰ����ϴ�.
���?y
id�Է�:son
pw�Է�:1212
����� ���� �ʽ��ϴ�.
���?y
id�Է�:park
pw�Է�:9999
�ش� ���̵� �����ϴ�.
���?y
------------------------
id�Է�:so
id�� 3����~8���� �Է��ؾ� �մϴ�.
id�Է�:sdfsfdsfsdfs
id�� 3����~8���� �Է��ؾ� �մϴ�. -> .length
id�Է�:kim
pw�Է�:1234
�迬�ƴ� �ݰ����ϴ�.
���?n -> while�� ���.
���α׷��� �����մϴ�.
 */
