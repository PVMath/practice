package org.SDET38_VIAJE_PRACTICE;

import java.time.LocalDateTime;

public class Time {

	public static void main(String[] args) {
		LocalDateTime date = LocalDateTime.now();
        int min = date.getMinute();
        int hour = date.getHour();
      
        String formate = hour+":"+min;
        System.out.println(formate);
	}

}
