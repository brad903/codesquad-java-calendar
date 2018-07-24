import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Prompt {

	public static void main(String[] args) {

		// 입력받은 월의 최대 일수 출력하기
		Scanner scan = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Calendar cal = new Calendar();
		String PROMPT = "> ";
		boolean shutdown = false;

		while (true) {
			System.out.println("+--------------------+");
			System.out.println("| 1. 일정 등록");
			System.out.println("| 2. 일정 검색");
			System.out.println("| 3. 달력 보기");
			System.out.println("| h. 도움말, q. 종료");
			System.out.println("+--------------------+");
			System.out.println("명령(1, 2, 3, h, q)");
			System.out.print(PROMPT);
			String command = scan.next();
			switch (command) {
			case "1":
				System.out.println("[일정 등록] 날짜를 입력하세요");
				System.out.print(PROMPT);
				String RegisDate = scan.next();

				System.out.println("일정을 입력하세요");
				System.out.print(PROMPT);
				String Schedule = null;
				try {
					Schedule = in.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				cal.RegisterDate(RegisDate, Schedule); // 일정등록
				break;
			case "2":
				System.out.println("[일정 검색] 날짜를 입력하세요");
				System.out.print(PROMPT);
				String FindDate = scan.next();
				cal.SearchDate(FindDate);
				break;
			case "3":
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM");
				String date = sdf.format(new Date());
				String[] today = date.split(" ");
				int year = Integer.parseInt(today[0]);
				int month = Integer.parseInt(today[1]);
				System.out.println();
				cal.PrintCalendar(year, month);
				break;
			case "h":
				System.out.println("--- 도움말 ---");
				break;
			case "q":
				shutdown = true;
				System.out.print("Have a nice day!");
				scan.close();
			default:
				System.out.println("명령을 다시 입력해주세요!");
			}
			if(shutdown) break;
		}
	}
}
