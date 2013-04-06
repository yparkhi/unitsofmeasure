/*
 * JSR-275 - Measures and Units.
 * Copyright (C) 2006-2008 - Java Community Process (http://jcp.org/)
 * All rights reserved.
 * 
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package net.java.jsr275.samples.money;

import java.util.HashSet;
import java.util.Set;

import javax.measure.unit.SystemOfUnits;
import javax.measure.unit.Unit;

import org.jscience.economics.money.Money;

/**
 * @author Werner Keil
 * @version 0.2, $Date$
 */
public final class MonetaryUnits extends SystemOfUnits {
	
    /**
     * Holds collection of Monetary units.
     */
    private static HashSet<Unit<?>> UNITS = new HashSet<Unit<?>>();

	// Use currency not defined as constant (Rupees).
	public static final Unit<Money> INR = monetary(Money.BASE_UNIT);

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
