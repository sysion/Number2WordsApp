package com.sysionng.number2wordsapp;

import java.lang.String;
import com.sysionng.number2wordsapp.Number2WordsUtility;

public class Number2Words {

	private long numInput;

	public Number2Words(long numInput) {
		this.numInput = numInput;
	}

	protected String ConvertNumber2Words() {
		String num2words;
		int numLength = String.valueOf(numInput).length();

		switch (numLength) {
			case 1:
				num2words = Number2WordsUtility.mNumberDict(numInput);
				break;
			case 2:
				num2words = TwoDigitsNumber(numInput);
				break;
			case 3:
				num2words = ThreeDigitsNumber(numInput);
				break;
			case 4:
			case 5:
			case 6:
				num2words = Four2SixDigitsNumber(numInput);
				break;
			case 7:
			case 8:
			case 9:
				num2words = Seven2NineDigitsNumber(numInput);
				break;
			case 10:
			case 11:
			case 12:
				num2words = Ten2TwelveDigitsNumber(numInput);
				break;
			/*case 13:
				num2words = Number2WordsUtility.mNumberDict(numInput);
				break;*/
			default:
				num2words = Number2WordsUtility.mNumberDict(numInput);
				break;
		}

		return num2words;
	}

	private String TwoDigitsNumber(long inputNum){	//10 - 99
		String number2words = "";
		long unitDigit = 0L;
		long tensDigit = 0L;

		if (inputNum == 0){
			number2words = "";
		}
		else if (inputNum >= 11L && inputNum <20L){
			number2words = Number2WordsUtility.mNumberDict(inputNum);
		}
		else if (inputNum == 10L || inputNum == 20L || inputNum == 30L || inputNum == 40L || inputNum == 50L || 
							inputNum == 60L || inputNum == 70L || inputNum == 80L || inputNum == 90L) {
				number2words = Number2WordsUtility.mNumberDict(inputNum);
		}
		else if (inputNum < 10L){
			number2words = Number2WordsUtility.mNumberDict(inputNum);
		}
		else {
			unitDigit = inputNum % 10L;
			tensDigit = inputNum / 10L;
			tensDigit = 10 * tensDigit;
			number2words = Number2WordsUtility.mNumberDict(tensDigit) + " " + Number2WordsUtility.mNumberDict(unitDigit);	
		}

		return number2words;
	}

	private String ThreeDigitsNumber(long inputNum){	//100 - 999
		String number2words = "";
		long hundred = 100L;
		String joinNumber = "and";
		long hundredDigit = 0L;
		long twoDigits = 0L;
		String wordTwoDigit = "";
		String wordHundredDigit = "";

		if (inputNum == 100L || inputNum == 200L || inputNum == 300L || inputNum == 400L || inputNum == 500L || 
							inputNum == 600L || inputNum == 700L || inputNum == 800L || inputNum == 900L) {
				hundredDigit = inputNum / hundred;
				number2words = Number2WordsUtility.mNumberDict(hundredDigit) + " " + Number2WordsUtility.mNumberDict(hundred);
		}
		else {
			hundredDigit = inputNum / hundred;
			twoDigits = inputNum % hundred;

			if (hundredDigit == 0){
				wordHundredDigit = "";
			}
			else {
				wordHundredDigit = Number2WordsUtility.mNumberDict(hundredDigit) + " " 
									+ Number2WordsUtility.mNumberDict(hundred) + " " ;
			}

			wordTwoDigit = " " + TwoDigitsNumber(twoDigits);

			if (hundredDigit == 0 && twoDigits == 0){
				number2words = "";
			}
			else {
				number2words =  wordHundredDigit + joinNumber + wordTwoDigit;
			}
		}

		return number2words;
	}

	private String Four2SixDigitsNumber(long inputNum){	//1,000 - 999,999
		String number2words = "";
		long thousand = 1000L;
		String joinNumber = "and";
		long thousandDigit = 0L;
		long threeDigit = 0L;
		int digitLen = 0;
		String wordThousandDigit = "";
		String wordThreeDigit = "";

		thousandDigit = inputNum / thousand;

		threeDigit = inputNum % thousand;
	
		if (thousandDigit == 0){
			wordThousandDigit = "";
		}
		else {
			digitLen = (int)Math.log10(thousandDigit) + 1;

			if (digitLen == 1){
				wordThousandDigit = Number2WordsUtility.mNumberDict(thousandDigit) + " " + Number2WordsUtility.mNumberDict(thousand);
			}
			else if (digitLen == 2){
				wordThousandDigit = TwoDigitsNumber(thousandDigit) + " " + Number2WordsUtility.mNumberDict(thousand);
			}
			else if (digitLen == 3){
				wordThousandDigit = ThreeDigitsNumber(thousandDigit) + " " + Number2WordsUtility.mNumberDict(thousand);
			}
		}
		
		if (threeDigit == 0){
			wordThreeDigit = "";
		}
		else {
			wordThreeDigit = ThreeDigitsNumber(threeDigit);
		}

		if (thousandDigit == 0 && threeDigit == 0){
			number2words = "";
		}
		else if (thousandDigit == 0){
			number2words = wordThreeDigit;
		}
		else if (threeDigit == 0){
			number2words = wordThousandDigit;
		}
		else {
			number2words = wordThousandDigit + ", " + wordThreeDigit;
		}

		return number2words;
	}

	private String Seven2NineDigitsNumber(long inputNum){	//1,000,000 - 999,999,999
		String number2words = "";
		long million = 1000000L;
		String joinNumber = "and";
		long millionDigit = 0L;
		long sixDigit = 0L;
		int digitLen = 0;
		String wordMillionDigit = "";
		String wordSixDigit = "";

		millionDigit = inputNum / million;
		sixDigit = inputNum % million;

		if (millionDigit == 0){
			wordMillionDigit = "";
		}
		else {
			digitLen = (int)Math.log10(millionDigit) + 1;

			if (digitLen == 1){
				wordMillionDigit = Number2WordsUtility.mNumberDict(millionDigit) + " " + Number2WordsUtility.mNumberDict(million);
			}
			else if (digitLen == 2){
				wordMillionDigit = TwoDigitsNumber(millionDigit) + " " + Number2WordsUtility.mNumberDict(million);
			}
			else if (digitLen == 3){
				wordMillionDigit = ThreeDigitsNumber(millionDigit) + " " + Number2WordsUtility.mNumberDict(million);
			}
		}

		if (sixDigit == 0){
			wordSixDigit = "";
		}
		else {
			wordSixDigit = Four2SixDigitsNumber(sixDigit);
		}

		if (millionDigit == 0 && sixDigit == 0){
			number2words = "";
		}
		else if (millionDigit == 0){
			number2words = wordSixDigit;
		}
		else if (sixDigit == 0){
			number2words = wordMillionDigit;
		}
		else {
			number2words = wordMillionDigit + ", " + wordSixDigit;
		}
		
		return number2words;
	}

	private String Ten2TwelveDigitsNumber(long inputNum){	//1,000,000,000 - 999,999,999,999
		String number2words = "";
		long billion = 1000000000L;
		String joinNumber = "and";
		long billionDigit = 0L;
		long nineDigit = 0L;
		int digitLen = 0;
		String wordBillionDigit = "";
		String wordMillionDigit = "";
		String wordNineDigit = "";

		billionDigit = inputNum / billion;
		nineDigit = inputNum % billion;

		digitLen = (int)Math.log10(billionDigit) + 1;

		if (digitLen == 1){
			wordBillionDigit = Number2WordsUtility.mNumberDict(billionDigit) + " " + Number2WordsUtility.mNumberDict(billion);
		}
		else if (digitLen == 2){
			wordBillionDigit = TwoDigitsNumber(billionDigit) + " " + Number2WordsUtility.mNumberDict(billion);
		}
		else if (digitLen == 3){
			wordBillionDigit = ThreeDigitsNumber(billionDigit) + " " + Number2WordsUtility.mNumberDict(billion);
		}

		if (nineDigit == 0){
			wordNineDigit = "";
			number2words = wordBillionDigit;
		}
		else {
			wordNineDigit = Seven2NineDigitsNumber(nineDigit);
			number2words = wordBillionDigit + ", " + wordNineDigit;
		}
		
		return number2words;
	}

}//