import java.util.Scanner;

public class ���� {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		
		int coke, cider, fanta;
		
		System.out.print("�����̸�=>");
		String name = sc.next();
		
		System.out.print("�ݶ����=>");
		coke = sc.nextInt();
		System.out.print("���̴ټ���=>");
		cider = sc.nextInt();
		System.out.print("ȯŸ����=>");
		fanta = sc.nextInt();
		
		System.out.println("------------------------------------------------");
		System.out.println("�̸�\t�ݶ����\t���̴ټ���\tȯŸ����");
		System.out.println("------------------------------------------------");
		System.out.println(name+"\t"+coke+"\t"+cider+"\t"+fanta);
		System.out.println("------------------------------------------------");
		
		int total = coke+cider+fanta;
		System.out.println("total="+total+"��");
		
		double avg = (double)total/3;
		System.out.println("���="+avg+"��");
	
		
	}
}
