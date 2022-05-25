class Member{
	private String name;
	private int age;
	private double height;

	Member(){

	}

	Member(String name, int age, double height){
		this.name = name;
		this.age = age;
		this.height = height;
	}

	void setName(String name) {
		this.name = name;
	}
	void setAge(int age) {
		this.age = age;
	}
	void setHeight(double height) {
		this.height = height;
	}

	String getName(){
		return name;
	}
	int getAge(){
		return age;
	}
	double getHeight(){
		return height;
	}

	void show() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
	
}//class
public class Test03_������ {
	
	public static void main(String[] args) {
		Member m1 = new Member("�ڳ���",30,172.9);
		Member m2 = new Member(); //���缮 ,50, 162.3. setter�ʱ�ȭ

		m2.setName("���缮");
		m2.setAge(50);
		m2.setHeight(162.3);

		m1.show();
		
		System.out.println();
		//		m2.getter ���
		System.out.println(m2.getName());
		System.out.println(m2.getAge());
		System.out.println(m2.getHeight());
	}
}
