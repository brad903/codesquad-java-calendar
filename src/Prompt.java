import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Prompt {

	public void printMenu() {
		System.out.println("+--------------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| h. 도움말, q. 종료");
		System.out.println("+--------------------+");
	}
	
	public Date StringToDate(String StrDate) {
		Date InputDate = null;
		try {
			InputDate = new SimpleDateFormat("yyyy-MM-dd").parse(StrDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return InputDate;
	}

	public void runPrompt() {
		// 입력받은 월의 최대 일수 출력하기
		Scanner scan = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Calendar cal = new Calendar();
		String PROMPT = "> ";
		boolean shutdown = false;

		while (true) {
			printMenu();
			System.out.println("명령(1, 2, 3, h, q)");
			System.out.print(PROMPT);
			String command = scan.next();
			
			switch (command) {
			case "1":
				System.out.println("[일정 등록] 날짜를 입력하세요(yyyy-MM-dd)");
				System.out.print(PROMPT);
				String RegisDate_str = scan.next();
				Date RegisDate = StringToDate(RegisDate_str);

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
				System.out.println("[일정 검색] 날짜를 입력하세요(yyyy-MM-dd)");
				System.out.print(PROMPT);
				String FindDate_str = scan.next();
				Date FindDate = StringToDate(FindDate_str);
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
				break;
			case "q":
				shutdown = true;
				System.out.print("Have a nice day!");
				scan.close();
				break;
			default:
				System.out.println("명령을 다시 입력해주세요!");
			}
			if (shutdown)
				break;
		}
	}

	public static void main(String[] args) {
		Prompt prom = new Prompt();
		prom.runPrompt();
	}
}
