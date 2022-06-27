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
			System.out.println("===메뉴 선택===");
			System.out.println("1.전체조회");
			System.out.println("2.지역별 조회");
			System.out.println("3.음식 종류별 조회(별점순)");
			System.out.println("4.현재 운영중인 가게 찾기");
			System.out.println("5.지역별 가격 정렬");
			System.out.println("6.리스트 추가");
			System.out.println("7.리스트 수정");
			System.out.println("8.리스트 삭제");
			System.out.println("9.프로그램 종료");
			System.out.print("메뉴 번호 선택>>");
			
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
				System.out.println("프로그램 종료");
				System.exit(0);
				break;
			default:
				System.out.println("1~7까지 숫자만 입력");
				break;
			}//switch
		}//while
	}//init
	
	
	private void SelectByPrice() {
		String order = null;
		System.out.print("지역 입력>>");
		String input=sc.next();
		
		System.out.print("가격대 1.낮은순 2.높은순 선택>>");
		int no=sc.nextInt();
		
		switch(no) {
		case 1:
			order = "asc";
			break;
		case 2:
			order = "desc";
			break;
		default:
			System.out.println("1,2 중에 선택");
			return;
		}//switch
		
		ArrayList <TasteBean> lists = tdao.SelectByPrice(input, order);
		show(lists);
		
		
	}//SelectByPrice
	
	private void SelectByOpen() {//오픈시간 폐점
		DateFormat dateFormat = new SimpleDateFormat("kk:mm");
		System.out.print("지역 입력>>");
		String input=sc.next();
		String time = dateFormat.format(new Date()).toString();
//		System.out.println(time);
		int week = Calendar.DAY_OF_WEEK;
		
		String DayOfWeek = null;
		
		if(week == 6) {
			DayOfWeek = "일";
		}else if(week == 7) {
			DayOfWeek = "월";
		}else if(week == 1) {
			DayOfWeek = "화";
		}else if(week == 2) {
			DayOfWeek = "수";
		}else if(week == 3) {
			DayOfWeek = "목";
		}else if(week == 4) {
			DayOfWeek = "금";
		}else if(week == 5) {
			DayOfWeek = "토";
		}
		
//		System.out.println(DayOfWeek);
		ArrayList <TasteBean> lists = tdao.SelectByOpen(input,time,DayOfWeek);
//		System.out.println(lists.size());
		show(lists);
		
	}//SelectByOpen

	private void SelectByType() { //별점순
		String order;
		System.out.print("음식 종류(한식,중식,양식,아시아,디저트) 입력>>");
		String type = sc.next();
		int star = 0;
		do {
			try {
				System.out.print("별점 1.낮은순 2.높은순 입력>>");
				star = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("1,2 중 입력");
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
		System.out.print("삭제할 번호(no) 입력>>");
		int no = sc.nextInt();
		
		int delete = tdao.TasteDelete(no);
		if(delete>0) {
			System.out.println("삭제 성공");
		}else if(delete == 0) {
			System.out.println("없는 번호 입력");
		}else {
			System.out.println("삭제 실패");
		}
	}//TasteDelete
	
	private void TasteUpdate() {
		String open;
		String close;
		int price = 0;
		System.out.print("변경할 번호(no) 입력>>");
		int no=sc.nextInt();
		
		System.out.print("지역 입력>>");
		String region=sc.next();
		System.out.print("음식 종류 입력>>");
		String type=sc.next();
		System.out.print("가게이름 입력>>");
		String store = sc.next();
		System.out.print("대표메뉴 입력>>");
		String food = sc.next();
		do {
			try {
				System.out.print("가격 입력>>");
				price = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("숫자만 입력 가능.");
				sc.next();
			}
		}while(true); //가격 숫자만 입력 가능함.
		
		do {
			try {
			System.out.print("개점시간 입력>>");
			open = sc.next();
			System.out.print("폐점시간 입력>>");
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
				System.out.println("개점은 폐점보다 빨라야함");
				continue;
			}else if(diff<0) {
				break;
			}//if
				
			} catch (ParseException e) {
				System.out.println("시간입력에러");
			}
		}while(true);			
		System.out.print("휴무일 입력>>");
		String vacancy = sc.next();
		System.out.print("별점 입력>>");
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
			System.out.println("수정 성공");
		}else if(update == 0) {
			System.out.println("없는 번호 입력");
		}else {
			System.out.println("수정 실패");
		}
	}//TasteUpdate
	
	private void TasteAdd() {
		int insert;
		int price=0;
		String open;
		String close;
		System.out.print("지역 입력>>");
		String region=sc.next();
		System.out.print("음식 종류 입력>>");
		String type=sc.next();
		System.out.print("가게이름 입력>>");
		String store = sc.next();
		System.out.print("대표메뉴 입력>>");
		String food = sc.next();
		do {
			try {
				System.out.print("가격 입력>>");
				price = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("숫자만 입력 가능.");
				sc.next();
			}
		}while(true); //가격 숫자만 입력 가능함.
		
		do {
			try {
			System.out.print("개점시간 입력>>");
			open = sc.next();
			System.out.print("폐점시간 입력>>");
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
				System.out.println("개점은 폐점보다 빨라야함");
				continue;
			}else if(diff<0) {
				break;
			}//if
				
			} catch (ParseException e) {
				System.out.println("시간입력에러");
			}
		}while(true);			
		System.out.print("휴무일 입력>>");
		String vacancy = sc.next();
		System.out.print("별점 입력>>");
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
			System.out.println("추가 성공");
		}else {
			System.out.println("추가실패");
		}
	}//TasteAdd
	
	private void SelectRegion() {
		System.out.print("지역 입력>>");
		String region = sc.next();
		System.out.print("음식 종류>>");
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
