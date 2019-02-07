package com.vaahanmitra.service;

import java.text.DecimalFormat;

public class CurrencyFormate {
	public static String indianrupee(double value) {
	    if(value < 1000) {
	        return format("###", value);
	    } else {
	        double hundreds = value % 1000;
	        int other = (int) (value / 1000);
	        return format(",##", other) + ',' + format("000", hundreds);
	    }
	}

	private static String format(String pattern, Object value) {
	    return new DecimalFormat(pattern).format(value);
	}

}
