import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08_06_Math_선가영 {

	public static void main(String[] args) {
		//		double d = Math.random(); //0포함, 1보다 작은 실수 난수(random) 발생
		//		System.out.println(d);
		//		
		//		int d = (int)(Math.random() * 45)+1; //1~11
		//		System.out.println(d);
		int i,j,count=0;
		int arr [] = new int[6];

		//내가 숫자 입력
		for(i=0;i<arr.length;i++) {
			Scanner sc = new Scanner(System.in);
//			<예제 빼먹고 한거>
			try {
				System.out.print("숫자 "+(i+1)+":");
				arr[i] = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("유효하지않은 값");
				i--;
				continue;
			}if(arr[i]>45 || arr[i]<1) {
				System.out.println("1~45사이 수만 가능");
				i--;
			}
			for(j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					System.out.print("숫자 중복, 다시 입력 :");
					arr[i] = sc.nextInt();
					j=-1;
				}
			}
		}
		//내가 입력한 숫자 출력
		System.out.println("내가 입력 : ");
		for(i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();

		System.out.println("--------------------------");

		//로또 번호 뽑기
		int lotto[] = new int[6];
		for(i = 0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45)+1;
			for(j=0;j<i;j++) { //lotto[i] 의 숫자가 겹치면 안되니까 . i가 0번방에 있을 땐 이 for문 돌지 않음.
				if(lotto[i]==lotto[j]) { //겹치면
					lotto[i] = (int)(Math.random() * 11)+1; //다시 돌아라
					j=-1; //증감식으로 가면서 j는 다시 0이됨. 다시 0부터 비교해서 한번 돌아서 중복 잡아냈던 앞방 번호들과 또 중복되지 않도록 함. 중복된게 없다면 for문 빠져나옴.
				}//if
			}//안쪽for

		}//바깥for

		//로또 번호 출력
		System.out.println("로또번호: ");

		for(i = 0; i<lotto.length; i++) {
			System.out.print(lotto[i]+" ");
		}System.out.println();		
		
		//맞은 개수 확인
		for(i=0;i<lotto.length;i++) {
			for(j=0;j<arr.length;j++) {
				if(arr[i]==lotto[j]) {
					count++;
				}
			}
		}
		//맞은 개수 출력
		System.out.println("맞은 개수 :"+count);
		switch(count) {
		case 6 :System.out.println("1등 당첨");
		break;
		case 5 :System.out.println("2등 당첨");
		break;
		case 4 :System.out.println("3등 당첨");
		break;
		default :System.out.println("꽝!!");
		}
	}

}
//내가 입력한 숫자 6개것도 중복처리 
/*
숫자1: 12
숫자2: 12
중복됨숫자2: 3
숫자3: 3
중복됨숫자3: 11
숫자4: 71
1~45사이의 수 입력하세요.
숫자4: q
유효하지 않은 값
숫자4: 12
중복됨숫자4: 7
숫자5: 5
숫자6: 33

컴이 발생시킨 로또 번호
21 41 39 37 2 27 

내가 선택한 로또 번호
12 3 11 7 5 33 

맞은 갯수 : 0
꽝!!
 */