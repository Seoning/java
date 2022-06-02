import java.util.ArrayList;
import java.util.Scanner;

class Music{
	private String title;
	private String singer;
	private int price;

	public String toString() {
		return title+"/"+singer+"/"+price;
	}

	public Music(String title,String singer,int price){
		this.title = title;
		this.singer = singer;
		this.price = price;
	}

//	�޴� �� Source - Generate getset => �ڵ��ϼ�
		public void setTitle(String title) {
			this.title = title;
		}
		public void setSinger(String singer) {
			this.singer = singer;
		}
		public void setPrice(int price) {
			this.price = price;
		}
	
	public String getTitle() {
		return title;
	}
	public String getSinger() {
		return singer;
	}
		public int getPrice() {
			return price;
		}
}
public class Ex09_04_������ {

	public static void main(String[] args) {
		
		ArrayList <Music> list = new ArrayList <Music> ();
		Scanner sc = new Scanner(System.in);
		//while�� ����
//				Music m1 = new Music("����","�ǹ�",1000); //�Է� ���� �������� ��ü �����
//				Music m2 = new Music("����","�ǹ�",1000); //�Է� ���� �������� ��ü �����

		int i,price;
		String title,singer,answer,find;

//		while�� ����
//				list.add(m1);
//				list.add(m2);

		do {
			System.out.print("����:");
			title = sc.next();
			System.out.print("����:");
			singer = sc.next();
			System.out.print("����:");
			price = sc.nextInt();

			Music m = new Music(title,singer,price);
			list.add(m);

			System.out.print("���?");
			answer = sc.next();
			if(answer.equals("n")) {
				break;
			}

		}while(true);


		System.out.println(list);
		boolean flag = false;

		do {
			flag = false; //flag �ʱ�ȭ
			System.out.print("ã�� ���� �Է�:");
			find = sc.next();
			for(i=0;i<list.size();i++) {
				Music s = list.get(i);
				if(s.getTitle().equals(find)) {
					System.out.println(find+"�� �������� "+s.getSinger());
					flag=true;
					break;
				} 
			}
			if(flag==false){
				System.out.println("ã�� ������ �����ϴ�.");
			}
			System.out.print("���?");
			answer = sc.next();
			if(!answer.equals("y")) { 
				break;
			}
//			if(answer.equals("n")) { 
//				break;
//			}

		}while(true);
		System.out.println("���α׷��� �����մϴ�.");

	}//main
}//class

//�����Ѱ�
//		while(true) {
//			for(i=0;i<list.size();i++) {	
//				Music m = list.get(i);
//				System.out.print("����:");
//				title = sc.next();
//				m.setTitle(title);
//
//				System.out.print("����:");
//				singer = sc.next();
//				m.setSinger(singer);
//				System.out.print("����:");
//				price = sc.nextInt();
//				m.setPrice(price);
//
//				System.out.print("���?");
//				answer = sc.next();
//			}
//			if(answer.equals("n")) {
//				break;
//			}
//		}//while��
//
//
//				while(true) {
//				System.out.print("ã�� ���� �Է�:");
//				find = sc.next();
//		
//				boolean flag = false;
//				
//				for(i=0;i<list.size();i++) {
//					Music s = list.get(i);
//					if(s.getTitle().equals(find)) {
//						System.out.println(find+"�� �������� "+s.getSinger());
//						System.out.print("���?");
//						answer = sc.next();
//						flag=true;
//					}
//				}//for
//				
//				if(flag==false){
//					System.out.println("ã�� ������ �����ϴ�.");
//					System.out.print("���?");
//					answer = sc.next();
//				}
//				if(answer.equals("n")) { 
//					break;
//				}
//				continue;
//				}
//				
//				System.out.println("���α׷��� �����մϴ�.");
//}
//}




/*
����:����
����:�ǹ�
����:1000
���?y
����:���ø��
����:������
����:2000
���?n
[����/�ǹ�/1000, ���ø��/������/2000]
ã�� ���� �Է�:���ø��
���ø���� �������� ������
���?y
ã�� ���� �Է�:�ܹ߸Ӹ�
ã�� ������ �����ϴ�.
���?n
���α׷��� �����մϴ�.
 */