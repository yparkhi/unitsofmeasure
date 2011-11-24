/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.unit;

import java.util.Set;
import org.unitsofmeasurement.quantity.Quantity;

/**
 * <p> This interface represents a system of units, it groups units together for
 *     historical or cultural reasons. Nothing prevents a unit from belonging to
 *     several systems of units at the same time (for example an
 *     <code>Imperial</code> system would have many of the units held by
 *     <code>USCustomary</code>).</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2.1 ($Revision: 111 $), $Date: 2010-09-13 18:42:10 +0200 (Mo, 13 Sep 2010) $
 */
public interface SystemOfUnits {

    /**
     * Returns the name of the system of unit.
     *
     * @return the system of unit name.
     */
    String getName();

    /**
     * Returns the default unit for the specified quantity.
     *
     * @param quantityType the quantity type.
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
     * @param dimension the dimension of the units to be returned.
     * @return the collection of units of specified dimension.
     */
    Set<? extends Unit<?>> getUnits(Dimension dimension);

}
