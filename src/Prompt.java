import java.util.Scanner;

public class Prompt {

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
				cal.PrintCalendar(2018, dal);
				System.out.println();
				System.out.println();
			}

			System.out.print("Have a nice day!");
			scan.close();
		}
	}
