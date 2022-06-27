import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class TasteMain {
	Scanner sc = new Scanner(System.in);
	TasteDao tdao = new TasteDao();
	TasteBean tb = new TasteBean();
	
	TasteMain(){
		init();
	}//TasteMain
	private void init() {
		
		while(true) {
			System.out.println("===�޴� ����===");
			System.out.println("1.��ü��ȸ");
			System.out.println("2.������ ��ȸ");
			System.out.println("3.���� ������ ��ȸ(������)");
			System.out.println("4.���� ����� ���� ã��");
			System.out.println("5.������ ���� ����");
			System.out.println("6.����Ʈ �߰�");
			System.out.println("7.����Ʈ ����");
			System.out.println("8.����Ʈ ����");
			System.out.println("9.���α׷� ����");
			System.out.print("�޴� ��ȣ ����>>");
			
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				ArrayList <TasteBean> lists = tdao.SelectAll();
				show(lists);
				break;
			case 2:
				SelectRegion();
				break;
			case 3:
				SelectByType();
				break;
			case 4:
				SelectByOpen();
				break;
			case 5:
				SelectByPrice();
				break;
			case 6:
				TasteAdd();
				break;
			case 7:
				TasteUpdate();
				break;
			case 8:
				TasteDelete();
				break;
			case 9:
				System.out.println("���α׷� ����");
				System.exit(0);
				break;
			default:
				System.out.println("1~7���� ���ڸ� �Է�");
				break;
			}//switch
		}//while
	}//init
	
	
	private void SelectByPrice() {
		String order = null;
		System.out.print("���� �Է�>>");
		String input=sc.next();
		
		System.out.print("���ݴ� 1.������ 2.������ ����>>");
		int no=sc.nextInt();
		
		switch(no) {
		case 1:
			order = "asc";
			break;
		case 2:
			order = "desc";
			break;
		default:
			System.out.println("1,2 �߿� ����");
			return;
		}//switch
		
		ArrayList <TasteBean> lists = tdao.SelectByPrice(input, order);
		show(lists);
		
		
	}//SelectByPrice
	
	private void SelectByOpen() {//���½ð� ����
		DateFormat dateFormat = new SimpleDateFormat("kk:mm");
		System.out.print("���� �Է�>>");
		String input=sc.next();
		String time = dateFormat.format(new Date()).toString();
//		System.out.println(time);
		int week = Calendar.DAY_OF_WEEK;
		
		String DayOfWeek = null;
		
		if(week == 6) {
			DayOfWeek = "��";
		}else if(week == 7) {
			DayOfWeek = "��";
		}else if(week == 1) {
			DayOfWeek = "ȭ";
		}else if(week == 2) {
			DayOfWeek = "��";
		}else if(week == 3) {
			DayOfWeek = "��";
		}else if(week == 4) {
			DayOfWeek = "��";
		}else if(week == 5) {
			DayOfWeek = "��";
		}
		
//		System.out.println(DayOfWeek);
		ArrayList <TasteBean> lists = tdao.SelectByOpen(input,time,DayOfWeek);
//		System.out.println(lists.size());
		show(lists);
		
	}//SelectByOpen

	private void SelectByType() { //������
		String order;
		System.out.print("���� ����(�ѽ�,�߽�,���,�ƽþ�,����Ʈ) �Է�>>");
		String type = sc.next();
		int star = 0;
		do {
			try {
				System.out.print("���� 1.������ 2.������ �Է�>>");
				star = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("1,2 �� �Է�");
				sc.next();
			}
		}while(true);
		if(star == 1) {
			order = "asc";
		}else {
			order = "desc";
		}
		
		ArrayList <TasteBean> lists = tdao.SelectByType(type, order);
		
		show(lists);
	}//SelectByType
	
	private void TasteDelete() {
		System.out.print("������ ��ȣ(no) �Է�>>");
		int no = sc.nextInt();
		
		int delete = tdao.TasteDelete(no);
		if(delete>0) {
			System.out.println("���� ����");
		}else if(delete == 0) {
			System.out.println("���� ��ȣ �Է�");
		}else {
			System.out.println("���� ����");
		}
	}//TasteDelete
	
	private void TasteUpdate() {
		String open;
		String close;
		int price = 0;
		System.out.print("������ ��ȣ(no) �Է�>>");
		int no=sc.nextInt();
		
		System.out.print("���� �Է�>>");
		String region=sc.next();
		System.out.print("���� ���� �Է�>>");
		String type=sc.next();
		System.out.print("�����̸� �Է�>>");
		String store = sc.next();
		System.out.print("��ǥ�޴� �Է�>>");
		String food = sc.next();
		do {
			try {
				System.out.print("���� �Է�>>");
				price = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է� ����.");
				sc.next();
			}
		}while(true); //���� ���ڸ� �Է� ������.
		
		do {
			try {
			System.out.print("�����ð� �Է�>>");
			open = sc.next();
			System.out.print("�����ð� �Է�>>");
			close = sc.next();
			SimpleDateFormat morn = new SimpleDateFormat("hh:mm", Locale.KOREA);
			SimpleDateFormat even = new SimpleDateFormat("hh:mm", Locale.KOREA);
			Date d1;
			Date d2;
			
			d1 = morn.parse(open);
			d2 = even.parse(close);
			long den = d1.getTime();
			long denx = d2.getTime();
			long diff = d1.getTime()-d2.getTime();
//			System.out.println(den);
//			System.out.println(denx);
//			System.out.println(diff);
			if(diff>=0) {
				System.out.println("������ �������� �������");
				continue;
			}else if(diff<0) {
				break;
			}//if
				
			} catch (ParseException e) {
				System.out.println("�ð��Է¿���");
			}
		}while(true);			
		System.out.print("�޹��� �Է�>>");
		String vacancy = sc.next();
		System.out.print("���� �Է�>>");
		double star = sc.nextDouble();
		
		TasteBean tb = new TasteBean();
		
		tb.setNo(no);
		tb.setRegion(region);
		tb.setType(type);
		tb.setStore(store);
		tb.setFood(food);
		tb.setPrice(price);
		tb.setOpen(open);
		tb.setClose(close);
		tb.setVacancy(vacancy);
		tb.setStar(star);
		
		int update = tdao.TasteUpdate(tb);
		
		if(update>0) {
			System.out.println("���� ����");
		}else if(update == 0) {
			System.out.println("���� ��ȣ �Է�");
		}else {
			System.out.println("���� ����");
		}
	}//TasteUpdate
	
	private void TasteAdd() {
		int insert;
		int price=0;
		String open;
		String close;
		System.out.print("���� �Է�>>");
		String region=sc.next();
		System.out.print("���� ���� �Է�>>");
		String type=sc.next();
		System.out.print("�����̸� �Է�>>");
		String store = sc.next();
		System.out.print("��ǥ�޴� �Է�>>");
		String food = sc.next();
		do {
			try {
				System.out.print("���� �Է�>>");
				price = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է� ����.");
				sc.next();
			}
		}while(true); //���� ���ڸ� �Է� ������.
		
		do {
			try {
			System.out.print("�����ð� �Է�>>");
			open = sc.next();
			System.out.print("�����ð� �Է�>>");
			close = sc.next();
			SimpleDateFormat morn = new SimpleDateFormat("hh:mm", Locale.KOREA);
			SimpleDateFormat even = new SimpleDateFormat("hh:mm", Locale.KOREA);
			Date d1;
			Date d2;
			
			d1 = morn.parse(open);
			d2 = even.parse(close);
//			long den = d1.getTime();
//			long denx = d2.getTime();
			long diff = d1.getTime()-d2.getTime();
//			System.out.println(den);
//			System.out.println(denx);
//			System.out.println(diff);
			if(diff>=0) {
				System.out.println("������ �������� �������");
				continue;
			}else if(diff<0) {
				break;
			}//if
				
			} catch (ParseException e) {
				System.out.println("�ð��Է¿���");
			}
		}while(true);			
		System.out.print("�޹��� �Է�>>");
		String vacancy = sc.next();
		System.out.print("���� �Է�>>");
		double star = sc.nextDouble();
		
		TasteBean tb = new TasteBean();
		
		tb.setRegion(region);
		tb.setType(type);
		tb.setStore(store);
		tb.setFood(food);
		tb.setPrice(price);
		tb.setOpen(open);
		tb.setClose(close);
		tb.setVacancy(vacancy);
		tb.setStar(star);
		
		insert = tdao.TasteAdd(tb);
		if(insert>0) {
			System.out.println("�߰� ����");
		}else {
			System.out.println("�߰�����");
		}
	}//TasteAdd
	
	private void SelectRegion() {
		System.out.print("���� �Է�>>");
		String region = sc.next();
		System.out.print("���� ����>>");
		String type = sc.next();
		ArrayList <TasteBean> lists = tdao.SelectRegion(region,type);

	show(lists);
	}//SelectRegion
	
	private void show(ArrayList<TasteBean> lists) {
		for(int i=0;i<lists.size();i++) {
			tb = lists.get(i);
			System.out.println(tb);
		}	
	}//show
	
	public static void main(String[] args) {
		new TasteMain();
	}//main
}
