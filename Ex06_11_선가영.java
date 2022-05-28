//pdf 80p.
class Empl{
	private String empno; //사원번호
	private String name;
	private int pay;

	Empl(String empno, String name, int pay) {
		this.empno = empno;
		this.name = name;
		this.pay = pay;
	}

	void getMontyPay() {
	}

	void print() {
		System.out.println(getEmpno()+","+getName()+" "+getPay());
	}

	void setEmpno(String empno) {
		this.empno = empno;
	}

	String getEmpno() {
		return empno;
	}

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setPay(int pay) {
		this.pay = pay;
	}

	int getPay() {
		return pay;
	}
}//Empl

class FullTime extends Empl {
	double bonus;

	FullTime(String empno,String name,int pay, double bonus){
		super(empno,name,pay);
		this.bonus = bonus;
	}

	double bonus(double bonus) {
		this.bonus = bonus;
		bonus = (getPay()/(double)12) + (bonus/(double)12);
		return bonus;
	}

	void print() {
		System.out.print(getEmpno()+","+getName()+","+getPay()+", ");
	}

	void getMontyPay() {
		System.out.println((getPay()/(double)12) + (bonus/(double)12));
	}

}//FullTime

class Contract extends Empl{
	int hireyear;

	Contract(String empno,String name,int pay, int hireyear){
		super(empno,name,pay);
		this.hireyear = hireyear;
	}
	void print() {
		System.out.print(getEmpno()+","+getName()+","+getPay()+", ");
	}
	void getMontyPay() {
		System.out.println(getPay()/(double)12*hireyear);
	}
}//Contract

class PartTime extends Empl{
	int workday;

	PartTime(String empno,String name,int pay, int workday){
		super(empno,name,pay);
		this.workday = workday;
	}

	void print() {
		System.out.print(getEmpno()+","+getName()+","+getPay()+", ");
	}

	void getMontyPay() {
		System.out.println(getPay() * workday);
	}
}//PartTime

public class Ex06_11_선가영 {

	public static void main(String[] args) {
		Empl f = new FullTime("F03","윤아",400,200);
		Empl c = new Contract("C02","웬디",200,3);
		Empl p = new PartTime("P01","제니",30,7);

		f.print(); //"F03","윤아",400 출력
		f.getMontyPay();
		System.out.println();

		c.print(); //"C02","웬디",200 출력
		c.getMontyPay();
		System.out.println();

		p.print(); //"P01","제니",30 출력
		p.getMontyPay(); //계산된 급여.

		System.out.println("------------");

		Empl arr[] = new Empl[3];
		arr [0] = new FullTime("F03","윤아",400,200);
		arr [1] = new Contract("C02","웬디",200,3);
		arr [2] = new PartTime("P01","제니",30,7);

		for(int i=0;i<arr.length;i++) {
			arr[i].print();
			arr[i].getMontyPay();
		}
	}
}

