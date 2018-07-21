import java.util.Scanner;

public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	public void PrintCalendar(int year, int month) {
		int MaxDay = getMaxDaysOfMonth(month);
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
		for(int j=1; j<=MaxDay; j++) {
			System.out.printf("%3d", j);
			if(j%7 == 0) System.out.println();
		}
	}

}
