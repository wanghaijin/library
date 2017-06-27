package text;

import java.sql.Date;
import java.util.Calendar;


public class text {
	public static void main(String[] args) {
		Date date=new Date(System.currentTimeMillis());
		String str="2017-01-02";
		Date date2=Date.valueOf(str);
		java.util.Date d1=new java.util.Date(date.getTime());
		System.out.println(d1);
		java.util.Date d2=new java.util.Date(date2.getTime());
		int days=(int)((d1.getTime()-d2.getTime())/(24*60*60*1000));
		
		System.out.println(days);
	}
}
