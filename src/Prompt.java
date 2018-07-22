import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {

		// 입력받은 월의 최대 일수 출력하기
		Scanner scan = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("출력받고 싶은 년도를 입력하세요(exit: -1)");
			System.out.print("YEAR> ");
			int year = scan.nextInt();
			if (year == -1) {
				break;
			}
			System.out.println("출력받고 싶은 월을 입력하세요");
			System.out.print("MONTH> ");
			int month = scan.nextInt();
			if (month < -1 || month > 12 || month == 0) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			cal.PrintCalendar(year, month);
			System.out.println();
			System.out.println();
		}

		System.out.print("Have a nice day!");
		scan.close();
	}
}
