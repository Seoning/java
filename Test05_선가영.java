import java.util.ArrayList;
import java.util.Scanner;

class Studentsgy{
	private String name;
	private int kor;
	private int eng;
	
//매개변수 없는 생성자도 만들어 놓으면 좋음 , 객체를 어떻게 사용할지 모르니까.
	
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

//	public void setName(String name) { //여기서는 set사용 X 없어도 됨.
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
public class Test05_선가영 {

	public static void main(String[] args) {
	ArrayList <Studentsgy>list = new ArrayList <Studentsgy> ();
	Scanner sc = new Scanner(System.in);
	
	String retry, name, find;
	int kor,eng,i;
	boolean flag = false;
	
	do {
		System.out.print("이름: ");
		name = sc.next();
		System.out.print("국어: ");
		kor= sc.nextInt();
		System.out.print("영어: ");
		eng = sc.nextInt();
		
		Studentsgy input = new Studentsgy(name, kor,eng);
		list.add(input);
		
		System.out.print("계속?(y/n): ");
		retry = sc.next();
		if(retry.equals("n")) {
			break;
		}
	}while(true);

	System.out.println(list);
	
	System.out.println();
	
	for(i=0;i<list.size();i++) {
		Studentsgy s = list.get(i);
		System.out.println(s.getName()+"/"+s.getKor()+"/"+s.getEng()); //toString 오버라이딩 안한 버전
//		System.out.println(s);  //toString 오버라이딩 한 버전.
	}
	
	System.out.println();

	do {
		System.out.print("찾는 이름: ");
		find = sc.next();
		for(i=0;i<list.size();i++) {
			flag = false;
			Studentsgy s = list.get(i);
			if(find.equals(s.getName())) {
				System.out.print("국어: "+s.getKor()+" ");
				System.out.println();				//굳이..
				System.out.print("영어: "+s.getEng()); //여기에 ln붙이면 되는디.
				System.out.println();				//굳이..
				flag=true;
				break; //for문 break;
			}//if
		}//for
		if(flag == false) {
			System.out.println("찾는 이름 없음");
		}
		System.out.print("계속? ");
		retry = sc.next();
		if(retry.equals("n")) {
			break; //do-while문 break;
		}
	}while(true);
	System.out.println("프로그램을 종료합니다.");

	}//main

}//class
