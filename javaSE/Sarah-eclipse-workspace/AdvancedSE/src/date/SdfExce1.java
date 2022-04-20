package date;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//练习1：“2019-12-09”转化为java.sql.date
public class SdfExce1 {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String str = "2019-12-09";
		Date d1 = sdf1.parse(str);
		java.sql.Date d = new java.sql.Date(d1.getTime());
		System.out.println(d);
		
//		System.out.println(sdf1.parse(str).getTime());
	}

}
