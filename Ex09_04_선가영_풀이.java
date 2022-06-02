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
public class Ex09_04_������_Ǯ�� {

	public static void main(String[] args) {
		ArrayList <Music> list = new ArrayList <Music> ();
		Scanner sc = new Scanner(System.in);
		
		int i,price;
		String title,singer,answer,find;
		
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

		}while(true);
		System.out.println("���α׷��� �����մϴ�.");
		
	}

}
