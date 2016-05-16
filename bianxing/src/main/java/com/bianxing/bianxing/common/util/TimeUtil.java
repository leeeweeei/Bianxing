package com.bianxing.bianxing.common.util;

import java.util.Calendar;

public class TimeUtil {
	public static long getCurrentSecond(){
		return Calendar.getInstance().getTimeInMillis() / 1000;
	}
}
