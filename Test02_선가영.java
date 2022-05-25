import java.util.Scanner;

public class Test02_선가영 {

	public static void main(String[] args) {
		//		방5개 1차원 정수 배열 입력. 합 출력.

		int arr[] = new int [5];
		Scanner sc = new Scanner(System.in);

		int i, sum=0;
		
		for(i=0;i<arr.length;i++) {
			System.out.print("정수"+(i+1)+"입력>");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}System.out.println("합="+sum);
		

		
	}

}
