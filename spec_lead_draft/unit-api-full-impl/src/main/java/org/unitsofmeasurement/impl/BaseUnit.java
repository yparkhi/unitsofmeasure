/*
 * JScience - Java(TM) Tools and Libraries for the Advancement of Sciences.
 * Copyright (C) 2010 - JScience (http://jscience.org/)
 * All rights reserved.
 *
 * Permission to use, copy, modify, and distribute this software is
 * freely granted, provided that this notice is preserved.
 */
package org.unitsofmeasurement.impl;

import java.util.Map;

import javax.measure.Quantity;
import javax.measure.function.UnitConverter;

import org.unitsofmeasurement.impl.function.AbstractConverter;
import org.unitsofmeasurement.impl.model.QuantityDimension;


/**
 * <p> This class represents the building blocks on top of which all others
 *     physical units are created. Base units are always unscaled SI units.</p>
 * 
 * <p> When using the {@link org.unitsofmeasurement.impl.model.StandardModel standard model},
 *     all seven {@link org.org.unitsofmeasurement.impl.system.SI SI} base units
 *     are dimensionally independent.</p>
 *
 * @see <a href="http://en.wikipedia.org/wiki/SI_base_unit">
 *       Wikipedia: SI base unit</a>
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 5.0, October 12, 2010
 */
public class BaseUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

    /**
     * Holds the symbol.
     */
    private final String symbol;

    /**
     * Holds the base unit dimension.
     */
    private final QuantityDimension dimension;

    /**
     * Creates a base unit having the specified symbol and dimension.
     *
     * @param symbol the symbol of this base unit.
     */
    public BaseUnit(String symbol, QuantityDimension dimension) {
        this.symbol = symbol;
        this.dimension = dimension;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public AbstractUnit<Q> toSI() {
        return this;
    }

    @Override
    public UnitConverter getConverterToSI() throws UnsupportedOperationException {
        return AbstractConverter.IDENTITY;
    }

    @Override
    public QuantityDimension getDimension() {
        return dimension;
    }

    @Override
    public final boolean equals(Object that) {
        if (this == that) return true;
        if (!(that instanceof BaseUnit)) return false;
        BaseUnit thatUnit = (BaseUnit) that;
        return this.symbol.equals(thatUnit.symbol) 
                && this.dimension.equals(thatUnit.dimension);
    }

    @Override
    public final int hashCode() {
        return symbol.hashCode();
    }

	@Override
	public Map<? extends AbstractUnit<Q>, Integer> getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}
}
