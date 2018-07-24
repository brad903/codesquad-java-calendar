import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PlanItem {
	HashMap<Date, ArrayList<String>> CalSchedule = new HashMap<Date, ArrayList<String>>();
	
	public void RegisterDate(Date regisDate, String ScheduleData) {
		ArrayList<String> ScheduleList = CalSchedule.get(regisDate);

		// 해당 날짜에 일정이 없을 경우
		if (ScheduleList == null) {
			ScheduleList = new ArrayList<String>();
			ScheduleList.add(ScheduleData);
			CalSchedule.put(regisDate, ScheduleList);
			System.out.println("일정이 생성되었습니다.");
		}
		// 해당 날짜에 일정이 있을 경우
		else {
			ScheduleList.add(ScheduleData);
			System.out.println("일정이 추가되었습니다.");
		}
		
		// 파일에 데이터 저장
		try {
			FileOutputStream fos = new FileOutputStream("./src/PlanData.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(CalSchedule);
			oos.close();
			fos.close();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public void SearchDate(Date findDate) {
		ArrayList<String> ScheduleList = CalSchedule.get(findDate);

		// 해당 날짜에 일정이 없을 경우
		if (ScheduleList == null) {
			System.out.println("해당 날짜에 일정이 없습니다");
		}
		// 해당 날짜에 일정이 있을 경우
		else {
			int length = ScheduleList.size();
			System.out.printf("해당 날짜에 %d개의 일정이 있습니다\n", length);
			for (int i = 0; i < length; i++) {
				System.out.printf("%d. %s\n", i + 1, ScheduleList.get(i));
			}
		}

	}
}
