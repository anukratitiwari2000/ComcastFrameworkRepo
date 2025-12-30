package com.comcast.generic.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	SimpleDateFormat sdf;
	public int getRandomNumber() {
		Random ranDom = new Random();
		int randomNo = ranDom.nextInt(2000);

		return randomNo;
	}

	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		
		return date;
	}
	
	public String getRequireDate(int days) {
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		
		return reqDate ;
		
	}
}
