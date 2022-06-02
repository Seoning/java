import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08_06_Math_������ {

	public static void main(String[] args) {
		//		double d = Math.random(); //0����, 1���� ���� �Ǽ� ����(random) �߻�
		//		System.out.println(d);
		//		
		//		int d = (int)(Math.random() * 45)+1; //1~11
		//		System.out.println(d);
		int i,j,count=0;
		int arr [] = new int[6];

		//���� ���� �Է�
		for(i=0;i<arr.length;i++) {
			Scanner sc = new Scanner(System.in);
//			<���� ���԰� �Ѱ�>
			try {
				System.out.print("���� "+(i+1)+":");
				arr[i] = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("��ȿ�������� ��");
				i--;
				continue;
			}if(arr[i]>45 || arr[i]<1) {
				System.out.println("1~45���� ���� ����");
				i--;
			}
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					System.out.print("���� �ߺ�, �ٽ� �Է� :");
					arr[i] = sc.nextInt();
					j=-1;
				}
			}
		}
		//���� �Է��� ���� ���
		System.out.println("���� �Է� : ");
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();

		System.out.println("--------------------------");

		//�ζ� ��ȣ �̱�
		int lotto[] = new int[6];
		for(i = 0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45)+1;
			for(j=0;j<i;j++) { //lotto[i] �� ���ڰ� ��ġ�� �ȵǴϱ� . i�� 0���濡 ���� �� �� for�� ���� ����.
				if(lotto[i]==lotto[j]) { //��ġ��
					lotto[i] = (int)(Math.random() * 11)+1; //�ٽ� ���ƶ�
					j=-1; //���������� ���鼭 j�� �ٽ� 0�̵�. �ٽ� 0���� ���ؼ� �ѹ� ���Ƽ� �ߺ� ��Ƴ´� �չ� ��ȣ��� �� �ߺ����� �ʵ��� ��. �ߺ��Ȱ� ���ٸ� for�� ��������.
				}//if
			}//����for

		}//�ٱ�for

		//�ζ� ��ȣ ���
		System.out.println("�ζǹ�ȣ: ");

		for(i = 0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}System.out.println();		
		
		//���� ���� Ȯ��
		for(i=0;i<lotto.length;i++) {
			for(j=0;j<arr.length;j++) {
				if(arr[i]==lotto[j]) {
					count++;
				}
			}
		}
		//���� ���� ���
		System.out.println("���� ���� :"+count);
		switch(count) {
		case 6 :System.out.println("1�� ��÷");
		break;
		case 5 :System.out.println("2�� ��÷");
		break;
		case 4 :System.out.println("3�� ��÷");
		break;
		default :System.out.println("��!!");
		}
	}

}
//���� �Է��� ���� 6���͵� �ߺ�ó�� 
/*
����1: 12
����2: 12
�ߺ��ʼ���2: 3
����3: 3
�ߺ��ʼ���3: 11
����4: 71
1~45������ �� �Է��ϼ���.
����4: q
��ȿ���� ���� ��
����4: 12
�ߺ��ʼ���4: 7
����5: 5
����6: 33

���� �߻���Ų �ζ� ��ȣ
21 41 39 37 2 27 

���� ������ �ζ� ��ȣ
12 3 11 7 5 33 

���� ���� : 0
��!!
 */