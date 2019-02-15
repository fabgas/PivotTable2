package org.myg.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberUtils {
	/**
	 * Add two numbers and get a double value
	 * @param number1
	 * @param number2
	 * @return Double
	 */
	public static Double addDouble(Number number1, Number number2) {
		if(number1 == null && number2 == null) {
			return null;
		}
		else if(number1 == null) {
			return number2.doubleValue();
		}
		else if(number2 == null) {
			return number1.doubleValue();
		}
		else {
			BigDecimal bdToAdd1 = new BigDecimal(number1.toString());
			BigDecimal bdToAdd2 = new BigDecimal(number2.toString());			
			BigDecimal bdResult = bdToAdd1.add(bdToAdd2);			
			return new Double(bdResult.doubleValue());			
		}
	}
	/**
	 * Adds two number and get an integer
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static Integer addInteger(Number number1, Number number2) {
		if(number1 == null && number2 == null) {
			return null;
		}
		else if(number1 == null) {
			return number2.intValue();
		}
		else if(number2 == null) {
			return number1.intValue();
		}
		else {
			BigInteger bdToAdd1 = new BigInteger(number1.toString());
			BigInteger bdToAdd2 = new BigInteger(number2.toString());			
			BigInteger bdResult = bdToAdd1.add(bdToAdd2);			
			return new Integer(bdResult.intValue());			
		}
	}
	public static Double divDouble(Double valeur1, Double valeur2) {
		if (valeur1 == null || valeur2 == null)
			return null;
		if (Math.abs(valeur2.doubleValue()) > 0.0) {
			return new Double(divide(valeur1.doubleValue(), valeur2.doubleValue()));
		}
		return null;
	}
	public static Double divDouble(Integer valeur1, Integer valeur2) {
		if (valeur1 == null || valeur2 == null)
			return null;
		if (Math.abs(valeur2.doubleValue()) > 0.0) {
			return new Double(divide(valeur1.doubleValue(), valeur2.doubleValue()));
		}
		return null;
	}
	public static final double divide(final double nbToDivide,final double divider) {
		BigDecimal bdToDivide = new BigDecimal(Double.toString(nbToDivide));
		BigDecimal bdDivider = new BigDecimal(Double.toString(divider));
		
		BigDecimal bdREsult = bdToDivide.divide(bdDivider,30,BigDecimal.ROUND_HALF_UP);
		double resultat = bdREsult.doubleValue();
		
		return resultat;
	}
}
