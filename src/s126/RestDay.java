package s126;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RestDay {

	// 토.일요일 구하기
	public static boolean isRest(Calendar tod) {
		boolean isRest = false;

		if (tod.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || tod.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			isRest = true;
		}

		return isRest;
	}

	// Calendar 를 문자열로
	public static String toYMD(Calendar dd) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dd.getTime());

	}

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for (int i = 1; i <= lastDay; i++) {
			cal.set(Calendar.DAY_OF_MONTH, i);
			if (isRest(cal)) {
				System.out.println(toYMD(cal) + "is RestDay.");
			}
		}

	}

}
