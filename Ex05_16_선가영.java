class Music{
	private String title;
	private String singer;
	private String genre;
	private int price;

	Music(){
		title = "INVU";
		singer = "태연";
		genre = "발라드";
		price = 1000;
	}

	Music(String t){
		title = t;
		singer = "싸이";
		genre = "댄스";
		price = 2000;
	}

	Music(String title, String singer, String genre, int price){
		this.title = title;
		this.singer = singer;
		this.genre = genre;
		this.price = price;
	}

	void setTitle(String t) {
		title = t;
	}
	void setSinger(String s) {
		singer = s;
	}
	void setGenre(String g) {
		genre = g;
	}
	void setPrice(int p) {
		price = p;
	}

	String getTitle() {
		return title;
	}
	String getSinger() {
		return singer;
	}
	String getGenre() {
		return genre;
	}
	int getPrice() {
		return price;
	}

	void display(){
		System.out.println(title);
		System.out.println(singer);
		System.out.println(genre);
		System.out.println(price);
		
	}


}
public class Ex05_16_선가영 {

	public static void main(String[] args) {
		Music m1 = new Music();//생성자초기화
		Music m2 = new Music("that_that"); //생성자초기화
		Music m3 = new Music();//setter초기화("어머나","장윤정","트로트",3000)
		
//		m1은 하나씩 getter로 출력
//		m2,m3는 display 메소드에서 한번에 출력 show처럼
		m3.setTitle("어머나");
		m3.setSinger("장윤정");
		m3.setGenre("트로트");
		m3.setPrice(3000);
		
		System.out.println(m1.getTitle());
		System.out.println(m1.getSinger());
		System.out.println(m1.getGenre());
		System.out.println(m1.getPrice());
		
		System.out.println();
		m2.display();
		
		System.out.println();
		m3.display();
		
	}

}
