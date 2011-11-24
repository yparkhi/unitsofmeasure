/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import org.unitsofmeasurement.quantity.Quantity;

/**
 * <p> This class represents the building blocks on top of which all others
 *     units are created. Base units are always unscaled metric units.</p>
 *
 * <p> When using the {@linkplain Dimensional.Model#STANDARD standard} model
 *     (default), all seven base units are dimensionally independent.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.8 ($Revision: 105 $), $Date: 2010-08-05 21:44:23 +0100 (Do, 05 Aug 2010) $
 * @see <a href="http://en.wikipedia.org/wiki/SI_base_unit">
 *       Wikipedia: SI base unit</a>
 */
class BaseUnit<Q extends Quantity<Q>> extends AbstractUnit<Q> {

    /** The serialVersionUID */
    private static final long serialVersionUID = 1234567654321265167L;

    /**
     * Creates a base unit having the specified symbol.
     *
     * @param symbol the symbol of this base unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public BaseUnit(String symbol, String name) {
        super(name);
        this.symbol = symbol;
    }

    /**
     * Creates a base unit having the specified symbol.
     *
     * @param symbol the symbol of this base unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public BaseUnit(String symbol) {
        this(symbol, null);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (!(that instanceof BaseUnit<?>))
            return false;
        BaseUnit<?> thatUnit = (BaseUnit<?>) that;
        return this.symbol.equals(thatUnit.symbol);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public Unit<Q> getSystemUnit() {
        return this;
    }
}
