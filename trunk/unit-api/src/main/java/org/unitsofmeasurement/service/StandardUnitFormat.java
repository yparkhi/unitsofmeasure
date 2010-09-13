/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.service;

import org.unitsofmeasurement.unit.UnitFormat;

/**
 * <p> This interface provides methods for OSGi bundles to parse/format units
 *     as per an international standard (such as
 *     <a href="http://www.unitsofmeasure.org/">UCUM</a>)</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @see <a href="http://aurora.regenstrief.org/~ucum/ucum.html">UCUM Full Specification</a>
 * @version 1.0
 */
public interface StandardUnitFormat extends UnitFormat {
    /**
     * Returns the name of the standard (such as "UCUM").
     */
    public String getName();

}
