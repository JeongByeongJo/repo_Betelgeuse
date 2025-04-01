package com.bicycledoctors.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.bicycledoctors.common.base.BaseVo;

public class UtilDateTime {

	public static String addNowTimeString(String date) {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
		return date + " " + localDateTimeString;
	}
	
	public static String add00TimeString(String date) {
		return date + " 00:00:00";
	}
	
	public static String add59TimeString(String date) {
		return date + " 23:59:59";
	}
	

}
