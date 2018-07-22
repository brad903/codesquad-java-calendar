import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		boolean leap = false;
		// 기본적으로 100으로 나누어 떨어지면 false로 해두고 400으로 나누어 떨어지면 true로 하여 OR연산되도
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			leap = true;
		}
		return leap;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		boolean flag = isLeapYear(year);
		if (flag) {
			return LEAP_MAX_DAYS[month - 1];
		} else {
			return MAX_DAYS[month - 1];
		}
	}

	public void PrintCalendar(int year, int month) {
		int MaxDay = getMaxDaysOfMonth(year, month);
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		for (int j = 1; j <= MaxDay; j++) {
			System.out.printf("%3d", j);
			if (j % 7 == 0)
				System.out.println();
		}
	}

}
