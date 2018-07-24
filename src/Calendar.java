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

	private int leap_num(int year) {
		return year / 4 - year / 100 + year / 400;
	}

	public int ParseDay(int year, int month) {
		// 기준년도 정보와 해당년도 정보 변수 저장
		int syear = 1970, sday = 4;
		int eyear = year, emonth = month, eday = 0;

		int bwt_year = eyear - syear;
		int bwt_leap = leap_num(eyear - 1) - leap_num(syear - 1); // 두 연도간 윤년의 개수
		int bwt_normal = bwt_year - bwt_leap; // 두 연도간 평년의 개수
		int jump_day = (bwt_leap * 2 + bwt_normal) % 7;

		eday = (sday + jump_day) % 7; // 해당연도 1월 1일 요일

		int day_sum = 0;
		for (int i = 0; i < emonth - 1; i++) {
			if (isLeapYear(eyear)) {
				day_sum += LEAP_MAX_DAYS[i];
			} else {
				day_sum += MAX_DAYS[i];
			}
		}

		return (eday + day_sum) % 7;
	}

	public void PrintHead(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println(" --------------------");
	}

	public void PrintCalendar(int year, int month) {
		int MaxDay = getMaxDaysOfMonth(year, month);
		int Day_order = ParseDay(year, month);
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
		System.out.println();
		System.out.println();
	}

}
