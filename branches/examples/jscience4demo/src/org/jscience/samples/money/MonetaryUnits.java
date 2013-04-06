/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2006-2008 - JScience (http://jscience.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.jscience.samples.money;

import java.util.HashSet;
import java.util.Set;

import javax.measure.unit.SystemOfUnits;
import javax.measure.unit.Unit;

import org.jscience.economics.money.Currency;
import org.jscience.economics.money.Money;

/**
 * @author Werner Keil
 * @version 0.2, $Date: 2011-07-05 02:14:56 +0530 (Di, 05 Jul 2011) $
 */
public final class MonetaryUnits extends SystemOfUnits {
	
    /**
     * Holds collection of Monetary units.
     */
    private static HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

	// Use currency not defined as constant (Rupees).
	public static final Currency INR = new Currency("INR");;

    /**
     * Default constructor (prevents this class from being instantiated).
     */
    private MonetaryUnits() {
    }
	
    /**
     * Returns the unique instance of this class.
     *
     * @return the MonetaryUnits instance.
     */
    public static SystemOfUnits getInstance() {
        return INSTANCE;
    }
    private static final MonetaryUnits INSTANCE = new MonetaryUnits();

	/* (non-Javadoc)
	 * @see javax.measure.unit.SystemOfUnits#getUnits()
	 */
	@Override
	public Set<Unit<?>> getUnits() {
		return UNITS;
	}
	
	/**
     * Adds a new unit to the collection.
     *
     * @param  unit the unit being added.
     * @return <code>unit</code>.
     */
    private static <U extends Unit<?>> U monetary(U unit) {
        UNITS.add(unit);
        return unit;
    }
}
