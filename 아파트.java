import java.util.Scanner;

class Family{
	String name1,name2,name3;
	int age1,age2,age3;
	
	Family(String name1, int age1, String name2, int age2,String name3, int age3 ){
		
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.age1 = age1;
		this.age2 = age2;
		this.age3 = age3;
	}
	
	void show() {
		System.out.print("아빠= "+name1);
		System.out.println(","+age1);
		System.out.print("엄마= "+name2);
		System.out.println(","+age2);
		System.out.print("딸= "+name3);
		System.out.println(","+age3);
	}
	
}

class Home extends Family{
	String city;
	String apt;
	int num;
	int people;
	
	Home(String name1, int age1, String name2, int age2, String name3, int age3, String city, String apt, int num, int people){
		super(name1, age1, name2, age2, name3, age3);
		this.city = city;
		this.apt = apt;
		this.num = num;
		this.people = people;
	}	
	void show(){
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요>");
		name3=sc.next();
		super.show();
		System.out.println("city: "+city);
		System.out.println("apt: "+apt);
		System.out.println("num: "+num);
		System.out.println("people: "+people);
	}

}
public class 아파트 {

	public static void main(String[] args) {
	Family f = new Family("김갑수",65,"주현미",60,"김주은",30);
	Home h = new Home("김갑수",65,"주현미",60,"김주은",30,"seoul","자이",1001,3);
	
	

//	System.out.println(me);
	h.show();
	}
}
