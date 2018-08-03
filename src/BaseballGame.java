import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	public static final int figures = 3;

	// 컴퓨터 중복되지 않는 3자리 수 뽑기
	public static int[] randomValue() {
		int[] values = new int[figures];
		Random rd = new Random();
		
		for(int i=0; i<figures; i++) {
			values[i] = rd.nextInt(9)+1;  // 1~9 중 랜덤값 설정
			i = removeDuplicate(i, values); // 중복 제거
		}
		return values;
	}
	
	// 컴퓨터 랜덤수 추출시 중복되는 값 찾고 제거 - randomValue()의 indent 3 넘는 코드 분리(피드백 반영)
	public static int removeDuplicate(int i, int[] values) {
		for(int j=0; j<i; j++) {  
			if(values[i] == values[j]) {
				i--;
			}
		}
		return i;
	}
	
	// 플레이어로 입력받은 수를 정수형 배열에 넣기
	public static int[] valueParse(String playerInput) {
		int[] playerValue = new int[figures];
		for(int i=0; i<figures; i++) {
			playerValue[i] = Integer.parseInt(playerInput.split("")[i]);  
		}
		return playerValue;
	}
	
	// 스트라이크, 볼 판별
	public static int[] judgeResult(int i, int[] playerValue, int[] pcValue, int[] result) {
		for(int j=0; j<figures; j++) {
			if( i==j && playerValue[i] == pcValue[j] ) {  // 스트라이크의 경우
				result[0]++;
			} 
			if(i!=j && playerValue[i] == pcValue[j]){  // 볼의 경우
				result[1]++;
			}
		}
		return result;
	}
	
	// 결과값 출력
	public static void printResult(int strike, int ball) {
		if(strike != 0) { 
			System.out.printf("%d 스트라이크 ", strike);
		} 
		if(ball != 0) {
			System.out.printf("%d 볼 ", ball);
		} 
		if(strike == 0 && ball == 0) {
			System.out.printf("낫싱");
		}
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] pcValue = new int[figures];
		pcValue = randomValue();
		
		while(true) {
			System.out.print("중복되지 않는 숫자 " + figures + "자리를 입력해주세요 : ");
			int[] playerValue = new int[figures];
			String playerInput = scan.next();
			playerValue = valueParse(playerInput);
			
			int result[] = new int[2];  // result[0] : strike, result[1] : ball
			
			
			for(int i=0; i<figures; i++) {
				result = judgeResult(i, playerValue, pcValue, result);
			}
			
			printResult(result[0], result[1]);
			
			if(result[0] == figures) {
				System.out.println(figures + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
				scan.close();
				break;
			}
		}
	}

}
