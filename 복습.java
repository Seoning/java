import java.util.Scanner;

public class 복습 {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		
		int coke, cider, fanta;
		
		System.out.print("가게이름=>");
		String name = sc.next();
		
		System.out.print("콜라수량=>");
		coke = sc.nextInt();
		System.out.print("사이다수량=>");
		cider = sc.nextInt();
		System.out.print("환타수량=>");
		fanta = sc.nextInt();
		
		System.out.println("------------------------------------------------");
		System.out.println("이름\t콜라수량\t사이다수량\t환타수량");
		System.out.println("------------------------------------------------");
		System.out.println(name+"\t"+coke+"\t"+cider+"\t"+fanta);
		System.out.println("------------------------------------------------");
		
		int total = coke+cider+fanta;
		System.out.println("total="+total+"병");
		
		double avg = (double)total/3;
		System.out.println("평균="+avg+"병");
	
		
	}
}
