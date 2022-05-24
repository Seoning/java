import java.util.Scanner;

public class Ex05_10_선가영 { //과제

	public static void main(String[] args) {
		/*정수 2개 입력
		int a,b;*/

		/*ex)3,4 => 3의 4승 =81, 0승 = 1  return값. 
		ex)5,3 => 5의 3승 =125
		메소드 만들어서 재귀랑 for문
		 */
		
		Scanner sc = new Scanner(System.in);
		int a,b;
		System.out.print("정수를 입력하세요>");
		a = sc.nextInt();

		System.out.print("몇승을 출력할까요>");
		b = sc.nextInt();

		System.out.println("재귀="+expo(a,b));
		System.out.println("for="+expo2(a,b));

	}//main

	static int expo(int a, int b) {
		if(b == 0) {
			return 1;
		}else {
			return a * expo(a,b-1);
		}
	}
	static int expo2(int a, int b) {
		int result = 1;
		for(int i=1; i<=b; i++) {
			result = result* a;
		}
		return result;	
	}


}





