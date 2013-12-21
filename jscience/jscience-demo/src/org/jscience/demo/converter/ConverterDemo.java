/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010-2013 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.jscience.demo.converter;

import static org.jscience.physics.unit.system.SI.ELECTRON_VOLT;
import static org.jscience.physics.unit.system.SI.HOUR;
import static org.jscience.physics.unit.system.SI.METRE;
import static org.jscience.physics.unit.system.SI.MINUTE;
import static org.jscience.physics.unit.system.SI.REVOLUTION;
import static org.jscience.physics.unit.system.SI.WATT;
import static org.jscience.physics.unit.system.SIPrefix.KILO;
import static org.jscience.physics.unit.system.UCUM.MIL_INTERNATIONAL;

/**
 * @author Werner Keil
 *
 */
public class ConverterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   // Conversion between units.
	    System.out.println(KILO(METRE).getConverterTo(MIL_INTERNATIONAL).convert(10.0));
	    // Retrieval of the system unit (identifies the measurement type).
	    System.out.println(REVOLUTION.divide(MINUTE).getSystemUnit());
	    // Dimension checking (allows/disallows conversions)
	    System.out.println(ELECTRON_VOLT.isCompatible(WATT.multiply(HOUR)));
	    // Retrieval of the unit dimension (depends upon the current model).
	    System.out.println(ELECTRON_VOLT.getDimension());
	}

}
