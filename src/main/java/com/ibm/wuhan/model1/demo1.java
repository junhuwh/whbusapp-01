package com.ibm.wuhan.model1;

import java.math.BigDecimal;

public class demo1 {
	public static void main(String[] args) {

		double a = 0.1;
		double b = 0.0007;
		System.out.println(a + b);

		BigDecimal c = new BigDecimal("0.1");
		BigDecimal d = new BigDecimal("0.0007");

		System.out.println(c.add(d).toString());
		System.out.println(c.multiply(d).toString());
		System.out.println(c.divide(d,10,BigDecimal.ROUND_HALF_UP).toString());

	}
}
