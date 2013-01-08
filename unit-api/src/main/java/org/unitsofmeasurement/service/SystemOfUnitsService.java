/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.service;

import org.unitsofmeasurement.unit.SystemOfUnits;


/**
 * The service to obtain a {@link SystemOfUnits} instances.
 * Instances are obtained from their name, for example {@code "SI"} (System International),
 * {@code "Imperial"} (British) or {@code "USCustomary"}.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2.2
 *
 * @since 0.6.0
 */
public interface SystemOfUnitsService {
    /**
     * Returns the default
     * <a href=http://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a>.
     *
     * @return {@code getSystemOfUnits("SI")}
     */
    SystemOfUnits getSystemOfUnits();

    /**
     * Returns the system of units having the specified name, or {@code null} if none.
     * Common system of units are {@code "SI"} (System International), {@code "Imperial"}
     * (British) and {@code "USCustomary"}.
     *
     * @param  name the system of unit name.
     * @return the system of units.
     */
    SystemOfUnits getSystemOfUnits(String name);
}
