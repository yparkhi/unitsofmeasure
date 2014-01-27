/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import java.util.Set;

import javax.measure.function.Nameable;


/**
 * A system of units grouped together for historical or cultural reasons.
 * Nothing prevents a unit from belonging to several systems of units at the same time (for example
 * an {@code Imperial} system would have many of the units held by {@code USCustomary}).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2.2
 *
 */
public interface SystemOfUnits extends Nameable {

    /**
     * Returns the default unit for the specified quantity.
     *
     * @param  <Q> the compile-time quantity type.
     * @param  quantityType the quantity type.
     * @return the unit for the specified quantity.
     */
    <Q extends Quantity<Q>> Unit<Q> getUnit(Class<Q> quantityType);

    /**
     * Returns a read only view over the units defined in this system.
     *
     * @return the collection of units.
     */
    Set<? extends Unit<?>> getUnits();

    /**
     * Returns the units defined in this system having the specified dimension
     * (convenience method).
     *
     * @param  dimension the dimension of the units to be returned.
     * @return the collection of units of specified dimension.
     */
    Set<? extends Unit<?>> getUnits(Dimension dimension);
}
