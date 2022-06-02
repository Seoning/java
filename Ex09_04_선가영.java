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
public class Ex09_04_선가영 {

	public static void main(String[] args) {
		
		ArrayList <Music> list = new ArrayList <Music> ();
		Scanner sc = new Scanner(System.in);
		//while문 쓸때
//				Music m1 = new Music("낙하","악뮤",1000); //입력 받은 내용으로 객체 만들기
//				Music m2 = new Music("낙하","악뮤",1000); //입력 받은 내용으로 객체 만들기

		int i,price;
		String title,singer,answer,find;

//		while문 쓸때
//				list.add(m1);
//				list.add(m2);

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
//			if(answer.equals("n")) { 
//				break;
//			}

		}while(true);
		System.out.println("프로그램을 종료합니다.");

	}//main
}//class

//내가한거
//		while(true) {
//			for(i=0;i<list.size();i++) {	
//				Music m = list.get(i);
//				System.out.print("제목:");
//				title = sc.next();
//				m.setTitle(title);
//
//				System.out.print("가수:");
//				singer = sc.next();
//				m.setSinger(singer);
//				System.out.print("가격:");
//				price = sc.nextInt();
//				m.setPrice(price);
//
//				System.out.print("계속?");
//				answer = sc.next();
//			}
//			if(answer.equals("n")) {
//				break;
//			}
//		}//while문
//
//
//				while(true) {
//				System.out.print("찾는 제목 입력:");
//				find = sc.next();
//		
//				boolean flag = false;
//				
//				for(i=0;i<list.size();i++) {
//					Music s = list.get(i);
//					if(s.getTitle().equals(find)) {
//						System.out.println(find+"의 가수명은 "+s.getSinger());
//						System.out.print("계속?");
//						answer = sc.next();
//						flag=true;
//					}
//				}//for
//				
//				if(flag==false){
//					System.out.println("찾는 제목이 없습니다.");
//					System.out.print("계속?");
//					answer = sc.next();
//				}
//				if(answer.equals("n")) { 
//					break;
//				}
//				continue;
//				}
//				
//				System.out.println("프로그램을 종료합니다.");
//}
//}




/*
제목:낙하
가수:악뮤
가격:1000
계속?y
제목:마시멜로
가수:아이유
가격:2000
계속?n
[낙하/악뮤/1000, 마시멜로/아이유/2000]
찾는 제목 입력:마시멜로
마시멜로의 가수명은 아이유
계속?y
찾는 제목 입력:단발머리
찾는 제목이 없습니다.
계속?n
프로그램을 종료합니다.
 */