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

//	메뉴 바 Source - Generate getset => 자동완성
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
public class Ex09_04_선가영_풀이 {

	public static void main(String[] args) {
		ArrayList <Music> list = new ArrayList <Music> ();
		Scanner sc = new Scanner(System.in);
		
		int i,price;
		String title,singer,answer,find;
		
		do {
			System.out.print("제목:");
			title = sc.next();
			System.out.print("가수:");
			singer = sc.next();
			System.out.print("가격:");
			price = sc.nextInt();

			Music m = new Music(title,singer,price);
			list.add(m);

			System.out.print("계속?");
			answer = sc.next();
			if(answer.equals("n")) {
				break;
			}

		}while(true);


		System.out.println(list);
		boolean flag = false;

		do {
			flag = false; //flag 초기화
			System.out.print("찾는 제목 입력:");
			find = sc.next();
			for(i=0;i<list.size();i++) {
				Music s = list.get(i);
				if(s.getTitle().equals(find)) {
					System.out.println(find+"의 가수명은 "+s.getSinger());
					flag=true;
					break;
				} 
			}
			if(flag==false){
				System.out.println("찾는 제목이 없습니다.");
			}
			System.out.print("계속?");
			answer = sc.next();
			if(!answer.equals("y")) { 
				break;
			}

		}while(true);
		System.out.println("프로그램을 종료합니다.");
		
	}

}
