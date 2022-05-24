class Music{
	private String title;
	private String singer;
	private String genre;
	private int price;

	Music(){
		title = "INVU";
		singer = "�¿�";
		genre = "�߶��";
		price = 1000;
	}

	Music(String t){
		title = t;
		singer = "����";
		genre = "��";
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
public class Ex05_16_������ {

	public static void main(String[] args) {
		Music m1 = new Music();//�������ʱ�ȭ
		Music m2 = new Music("that_that"); //�������ʱ�ȭ
		Music m3 = new Music();//setter�ʱ�ȭ("��ӳ�","������","Ʈ��Ʈ",3000)
		
//		m1�� �ϳ��� getter�� ���
//		m2,m3�� display �޼ҵ忡�� �ѹ��� ��� showó��
		m3.setTitle("��ӳ�");
		m3.setSinger("������");
		m3.setGenre("Ʈ��Ʈ");
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
