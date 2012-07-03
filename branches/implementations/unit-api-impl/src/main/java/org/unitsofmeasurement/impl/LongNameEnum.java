package org.unitsofmeasurement.impl;

/**
 * This interface is used to provide a <code>longName()</code> method to enums.
 * @author Werner Keil
 */
public interface LongNameEnum<I extends LongNameEnum<I>> {
	String name(); // this is just a compatibility measure with the original enum
	String longName();
	LongNameEnum<I>[] iValues();
}
