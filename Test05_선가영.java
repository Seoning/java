import java.util.ArrayList;
import java.util.Scanner;

class Studentsgy{
	private String name;
	private int kor;
	private int eng;
	
//�Ű����� ���� �����ڵ� ����� ������ ���� , ��ü�� ��� ������� �𸣴ϱ�.
	
	public Studentsgy(String name,int kor,int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	public String toString() {
		return name+"/"+kor+"/"+eng;
	}

	public String getName() {
		return name;
	}

//	public void setName(String name) { //���⼭�� set��� X ��� ��.
//		this.name = name;
//	}

	public int getKor() {
		return kor;
	}

//	public void setKor(int kor) {
//		this.kor = kor;
//	}

	public int getEng() {
		return eng;
	}

//	public void setEng(int eng) {
//		this.eng = eng;
//	}

}//class
public class Test05_������ {

	public static void main(String[] args) {
	ArrayList <Studentsgy>list = new ArrayList <Studentsgy> ();
	Scanner sc = new Scanner(System.in);
	
	String retry, name, find;
	int kor,eng,i;
	boolean flag = false;
	
	do {
		System.out.print("�̸�: ");
		name = sc.next();
		System.out.print("����: ");
		kor= sc.nextInt();
		System.out.print("����: ");
		eng = sc.nextInt();
		
		Studentsgy input = new Studentsgy(name, kor,eng);
		list.add(input);
		
		System.out.print("���?(y/n): ");
		retry = sc.next();
		if(retry.equals("n")) {
			break;
		}
	}while(true);

	System.out.println(list);
	
	System.out.println();
	
	for(i=0;i<list.size();i++) {
		Studentsgy s = list.get(i);
		System.out.println(s.getName()+"/"+s.getKor()+"/"+s.getEng()); //toString �������̵� ���� ����
//		System.out.println(s);  //toString �������̵� �� ����.
	}
	
	System.out.println();

	do {
		System.out.print("ã�� �̸�: ");
		find = sc.next();
		for(i=0;i<list.size();i++) {
			flag = false;
			Studentsgy s = list.get(i);
			if(find.equals(s.getName())) {
				System.out.print("����: "+s.getKor()+" ");
				System.out.println();				//����..
				System.out.print("����: "+s.getEng()); //���⿡ ln���̸� �Ǵµ�.
				System.out.println();				//����..
				flag=true;
				break; //for�� break;
			}//if
		}//for
		if(flag == false) {
			System.out.println("ã�� �̸� ����");
		}
		System.out.print("���? ");
		retry = sc.next();
		if(retry.equals("n")) {
			break; //do-while�� break;
		}
	}while(true);
	System.out.println("���α׷��� �����մϴ�.");

	}//main

}//class
