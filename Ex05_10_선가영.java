import java.util.Scanner;

public class Ex05_10_������ { //����

	public static void main(String[] args) {
		/*���� 2�� �Է�
		int a,b;*/

		/*ex)3,4 => 3�� 4�� =81, 0�� = 1  return��. 
		ex)5,3 => 5�� 3�� =125
		�޼ҵ� ���� ��Ͷ� for��
		 */
		
		Scanner sc = new Scanner(System.in);
		int a,b;
		System.out.print("������ �Է��ϼ���>");
		a = sc.nextInt();

		System.out.print("����� ����ұ��>");
		b = sc.nextInt();

		System.out.println("���="+expo(a,b));
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





