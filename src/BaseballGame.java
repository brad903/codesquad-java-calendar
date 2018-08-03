import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	// 여러 곳에서 사용되고 있는 자리수를 상수 값으로 구현(피드백 반영)
	public static final int figures = 3;
	int[] playerValue = new int[figures];
	int[] pcValue = new int[figures];

	// 컴퓨터 중복되지 않는 3자리 수 뽑기
	public static int[] randomValue() {
		int[] values = new int[figures];
		Random rd = new Random();

		for (int i = 0; i < figures; i++) {
			values[i] = rd.nextInt(9) + 1; // 1~9 중 랜덤값 설정
			if (findDuplicate(i, values)) {
				i--; // 중복 제거
			}
		}
		return values;
	}

	// 컴퓨터 랜덤수 추출시 중복여부 조사 - randomValue()의 indent 3 넘는 코드 분리(피드백 반영)
	public static boolean findDuplicate(int i, int[] values) {
		for (int j = 0; j < i; j++) {
			if (values[i] == values[j]) {
				return true;
			}
		}
		return false;
	}

	// 플레이어로 입력받은 수를 정수형 배열에 넣기
	public static int[] valueParse(String playerInput) {
		int[] playerValue = new int[figures];
		for (int i = 0; i < figures; i++) {
			playerValue[i] = Integer.parseInt(playerInput.split("")[i]);
		}
		return playerValue;
	}

	// 예외처리 : 중복값 입력했을 경우(피드백 반영)
	public boolean duplicateException(int[] playerValue) {
		for (int i = 0; i < figures; i++) {
			if (findDuplicate(i, playerValue)) {
				return true;
			}
		}
		return false;
	}
	
	// 예외처리 : 입력값에 0이 포함되었을 경우(피드백 반영)
	public boolean zeroException(int[] playerValue) {
		for(int i=0; i<figures; i++) {
			if(playerValue[i] == 0) {
				return true;
			}
		}
		return false;
	}

	// 스트라이크, 볼 판별
	public int[] judgeResult(int i, int[] result) {
		for (int j = 0; j < figures; j++) {
			if (i == j && this.playerValue[i] == this.pcValue[j]) { // 스트라이크의 경우
				result[0]++;
			}
			if (i != j && this.playerValue[i] == this.pcValue[j]) { // 볼의 경우
				result[1]++;
			}
		} 
		return result;
	}

	// 결과값 출력
	public void printResult(int strike, int ball) {
		if (strike != 0) {
			System.out.printf("%d 스트라이크 ", strike);
		}
		if (ball != 0) {
			System.out.printf("%d 볼 ", ball);
		}
		if (strike == 0 && ball == 0) {
			System.out.printf("낫싱");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BaseballGame game = new BaseballGame();
		game.pcValue = randomValue();

		while (true) {
			System.out.print("중복되지 않는 숫자 " + figures + "자리를 입력해주세요 : ");
			String playerInput = scan.next();
			
			// 예외처리 : 자리 수보다 적게 입력하거나 많이 입력하였을 경우(피드백 반영)
			if(playerInput.length() != figures) {
				System.out.println("[오류]" + playerInput.length() + "자리의 수가 아닌 " + figures + "자리의 수를 입력해주세요!");
				continue;
			}
			
			// 예외처리 : 정수형이 아닌 값으로 입력받았을 경우(피드백 반영)
			try {
				game.playerValue = valueParse(playerInput);  // 입력값 배열로 정리
			}
			catch(NumberFormatException nfe) {
				System.out.println("[오류]정수형으로 다시 입력해주세요!");
				continue;
			}
			
			// 예외처리 : 중복값 입력했을 경우(피드백 반영)
			if (game.duplicateException(game.playerValue)) {
				System.out.println("[오류]수가 중복되지 않도록 다시 입력해주세요!");
				continue;
			}
			// 예외처리 : 0이 입력되었을 경우(피드백 반영)
			if(game.zeroException(game.playerValue)) {
				System.out.println("[오류]각 자리수에 0이 없도록 다시 입력해주세요!");
				continue;
			} 

			int result[] = new int[2]; // result[0] : strike, result[1] : ball

			for (int i = 0; i < figures; i++) {
				result = game.judgeResult(i, result);  // 객체화를 통해 judgeResult의 인자수를 줄임(피드백 반영) 
			}

			game.printResult(result[0], result[1]); 

			if (result[0] == figures) {
				System.out.println(figures + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
				scan.close();
				break;
			}
		}
	}

}
