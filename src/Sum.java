import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		
		// 입력 : 키보드로 두 수의 입력을 받는다
		Scanner scan = new Scanner(System.in); // System.in은 키보드를 의
		System.out.print("두 수를 입력하세요 : ");
		String str = scan.nextLine();
		String[] str_array = str.split(" ");
		int num1 = Integer.parseInt(str_array[0]);
		int num2 = Integer.parseInt(str_array[1]);
		
		// 출력 : 화면에 두 수의 합을 출력한다
		System.out.printf("두 수의 합은 %d 입니다", num1+num2);
	}
}
