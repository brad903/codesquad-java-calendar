import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void PrintSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("-------------------");
		System.out.println("1  2  3  4  5  6  7");
		System.out.println("8  9  10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}

	public static void main(String[] args) {

		// 입력받은 월의 최대 일수 출력하기
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();
		String PROMPT = "cal> ";

		while (true) {
			System.out.println("출력받고 싶은 달을 입력하세요");
			System.out.print(PROMPT);
			int dal = scan.nextInt();
			if(dal == -1) {
				break;
			}
			if(dal < -1 || dal > 12 || dal == 0){
				continue;
			}
			System.out.printf("%d월은 %d일까지 있습니다\n", dal, cal.getMaxDaysOfMonth(dal));
		}

		System.out.print("Have a nice day!");
		scan.close();
	}

}
