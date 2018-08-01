import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

	// 컴퓨터 중복되지 않는 3자리 수 뽑기
	public static int[] randomValue() {
		int[] value = new int[3];
		Random rd = new Random();
		
		for(int i=0; i<3; i++) {
			value[i] = rd.nextInt(9)+1;  // 1~9 중 랜덤값 설정
			for(int j=0; j<i; j++) {  // 중복 제거
				if(value[i] == value[j]) {
					i--;
				}
			}
		}
		return value;
	}
	
	// 플레이어로 입력받은 수를 정수형 배열에 넣기
	public static int[] valueParse(String playerInput) {
		int[] playerValue = new int[3];
		for(int i=0; i<3; i++) {
			playerValue[i] = Integer.parseInt(playerInput.split("")[i]);  
		}
		return playerValue;
	}
	
	// 스트라이크, 볼 판별
	public static int[] judgeResult(int i, int[] playerValue, int[] pcValue, int[] result) {
		for(int j=0; j<3; j++) {
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
		int[] pcValue = new int[3];
		pcValue = randomValue();
		
		while(true) {
			System.out.print("중복되지 않는 숫자 3자리를 입력해주세요 : ");
			int[] playerValue = new int[3];
			String playerInput = scan.next();
			playerValue = valueParse(playerInput);
			
			int result[] = new int[2];  // result[0] : strike, result[1] : ball
			
			
			for(int i=0; i<3; i++) {
				result = judgeResult(i, playerValue, pcValue, result);
			}
			
			printResult(result[0], result[1]);
			
			if(result[0] == 3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				scan.close();
				break;
			}
		}
	}

}
