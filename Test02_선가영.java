import java.util.Scanner;

public class Test02_������ {

	public static void main(String[] args) {
		//		��5�� 1���� ���� �迭 �Է�. �� ���.

		int arr[] = new int [5];
		Scanner sc = new Scanner(System.in);

		int i, sum=0;
		
		for(i=0;i<arr.length;i++) {
			System.out.print("����"+(i+1)+"�Է�>");
			arr[i] = sc.nextInt();
			sum += arr[i];
		}System.out.println("��="+sum);
		

		
	}

}
