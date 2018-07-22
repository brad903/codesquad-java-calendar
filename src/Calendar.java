public class Calendar {
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		boolean leap = false;
		// 기본적으로 100으로 나누어 떨어지면 false로 해두고
		// 400으로 나누어 떨어지면 true로 하여 OR연산되도록 한다
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

	/**
	 * 
	 * @param day
	 * @return Sunday: 0 ~ Saturday: 6
	 */
	public int ParseDay(String day) {
		switch (day) {
		case "SU":
			return 0;
		case "MO":
			return 1;
		case "TU":
			return 2;
		case "WE":
			return 3;
		case "TH":
			return 4;
		case "FR":
			return 5;
		case "SA":
			return 6;
		default:
			return 0;
		}
	}

	public void PrintHead(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
	}

	public void PrintCalendar(int year, int month, String day) {
		int MaxDay = getMaxDaysOfMonth(year, month);
		int Day_order = ParseDay(day);
		int Blank_num = 0;

		PrintHead(year, month);
		// print blank space
		for (int i = 0; i < Day_order; i++) {
			System.out.print("   ");
			Blank_num += 1;
		}
		for (int j = 1; j <= MaxDay; j++) {
			System.out.printf("%3d", j);
			Blank_num += 1;
			if (Blank_num % 7 == 0) {
				System.out.println();
				Blank_num = 0;
			}
		}
	}

}
