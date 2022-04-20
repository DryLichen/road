package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//三天打渔两天晒网，那么某天是在干嘛

public class SdfExcer2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入开始年份：");
		int startYear = scan.nextInt();
		System.out.println("请输入开始月份：");
		int startMonth = scan.nextInt();
		System.out.println("请输入开始日期：");
		int startDay = scan.nextInt();
		System.out.println("请输入目标年份：");
		int endYear = scan.nextInt();
		System.out.println("请输入目标月份：");
		int endMonth = scan.nextInt();
		System.out.println("请输入目标日期：");
		int endDay = scan.nextInt();

		scan.close();
		
		Date startDate = null;
		StringBuilder sb1 = new StringBuilder();
		sb1.append(startYear).append("-").append(startMonth).append("-").append(startDay);
		String str1 = sb1.toString();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			startDate = sdf1.parse(str1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Date endDate = null;
		StringBuilder sb2 = new StringBuilder();
		sb2.append(endYear).append("-").append(endMonth).append("-").append(endDay);
		String str2 = sb2.toString();
		try {
			endDate = sdf1.parse(str2);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SdfExcer2 s = new SdfExcer2();
		try {
			s.fishOrSleep(endDate, startDate);
		} catch (IncorrectTimeException e) {
			System.out.println(e.getMessage()); 
		}
	}

	public void fishOrSleep(Date date, Date start) throws IncorrectTimeException {
		if (gapDays(date, start) % 5 == 0 || gapDays(date, start) % 5 == 4) {
			System.out.printf("第%d天，她在晒网%n", gapDays(date, start));
		} else {
			System.out.printf("第%d天，她在打渔%n", gapDays(date, start));
		}
	}

	public int gapDays(Date date, Date start) throws IncorrectTimeException {
		int endYear = date.getYear() + 1900;
		int endMonth = date.getMonth() + 1;
		int endDate = date.getDate();
		int startYear = start.getYear() + 1900;
		int startMonth = start.getMonth() + 1;
		int startDate = start.getDate();

		int gapYear = endYear - startYear;
		int days = 0;

		if (gapYear < 0) {
			throw new IncorrectTimeException("Wrong Time!");
		} else if (gapYear == 0) {
			days = getDays(endYear, endMonth, endDate) - getDays(startYear, startMonth, startDate) + 1;
		} else {
			days = getYearDays(startYear) - getDays(startYear, startMonth, startDate) + 1;
			for (int i = startYear + 1; i < endYear; i++) {
				days += getYearDays(i);
			}
			days += getDays(endYear, endMonth, endDate);
		}

		return days;
	}

	public int getYearDays(int year) {
		if (isLeap(year)) {
			return 366;
		} else {
			return 365;
		}
	}

	public int getDays(int year, int month, int date) {
		int sumDays = 0;
		int dateIn2 = 0;

		// examine whether it's a leap year
		if (isLeap(year)) {
			dateIn2 = 29;
		} else {
			dateIn2 = 28;
		}

		// calculate the sum of days
		switch (month) {
		case 12:
			sumDays = sumDays + 30;
		case 11:
			sumDays = sumDays + 31;
		case 10:
			sumDays = sumDays + 30;
		case 9:
			sumDays = sumDays + 31;
		case 8:
			sumDays = sumDays + 31;
		case 7:
			sumDays = sumDays + 30;
		case 6:
			sumDays = sumDays + 31;
		case 5:
			sumDays = sumDays + 30;
		case 4:
			sumDays = sumDays + 31;
		case 3:
			sumDays = sumDays + dateIn2;
		case 2:
			sumDays = sumDays + 31;
		case 1:
			sumDays = sumDays + date;
		default:
			break;
		}

		return sumDays;
	}

	public boolean isLeap(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
		} else {
			if (year % 4 == 0) {
				return true;
			}
		}
		return false;
	}
}

class IncorrectTimeException extends Exception {
	static final long serialVersionUID = -937482934L;

	public IncorrectTimeException() {

	}

	public IncorrectTimeException(String msg) {
		super(msg);
	}
}
