package com.sysionng.number2wordsapp;

import java.util.HashMap;
import java.lang.Long;


public class Number2WordsUtility {

	public static String mNumberDict(long numKey) {
		HashMap<Long, String> numberDict = new HashMap<Long, String>();

		numberDict.put(0L, "zero");
		numberDict.put(1L, "one"); 
		numberDict.put(2L, "two"); 
		numberDict.put(3L, "three"); 
		numberDict.put(4L, "four"); 
		numberDict.put(5L, "five"); 
		numberDict.put(6L, "six"); 
		numberDict.put(7L, "seven");
		numberDict.put(8L, "eight");
		numberDict.put(9L, "nine"); 
		numberDict.put(10L, "ten"); 
		numberDict.put(11L, "eleven"); 
		numberDict.put(12L, "twelve"); 
		numberDict.put(13L, "thirteen"); 
		numberDict.put(14L, "fourteen");
		numberDict.put(15L, "fifteen"); 
		numberDict.put(16L, "sixteen"); 
		numberDict.put(17L, "seventeen"); 
		numberDict.put(18L, "eighteen"); 
		numberDict.put(19L, "nineteen");
		numberDict.put(20L, "twenty"); 
		numberDict.put(30L, "thirty"); 
		numberDict.put(40L, "fourty"); 
		numberDict.put(50L, "fifty"); 
		numberDict.put(60L, "sixty"); 
		numberDict.put(70L, "seventy");
		numberDict.put(80L, "eighty"); 
		numberDict.put(90L, "ninety"); 
		numberDict.put(100L, "hundred"); 
		numberDict.put(1000L, "thousand"); 
		numberDict.put(1000000L, "million");
		numberDict.put(1000000000L, "billion");

		if (numberDict.containsKey(numKey))
			return numberDict.get(numKey);
		else
			return numKey + " is outside range of number for this application.";
	}

	public static long GetNumber(String textNumber) {
		long inpNumber = 0;

		try {
	        inpNumber = Long.parseLong(textNumber);
	    } catch (NumberFormatException e) {
	        inpNumber = -1;
	    }

	    return inpNumber;
	}


}
