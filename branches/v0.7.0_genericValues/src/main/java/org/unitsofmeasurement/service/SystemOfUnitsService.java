/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2012, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.service;

import org.unitsofmeasurement.unit.SystemOfUnits;

/**
 * <p>
 * This interface represents the service to obtain a {@link SystemOfUnits system
 * of units}.
 * </p>
 * 
 * <p>
 * Common system of units are "SI" (System International), "Imperial" (British),
 * "USCustomary".
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3.1 ($Revision$), $Date$
 */
public interface SystemOfUnitsService {

	/**
	 * Returns the default <a
	 * href=http://en.wikipedia.org/wiki/International_System_of_Units">
	 * International System of Units</a>.
	 * 
	 * @return <code>getSystemOfUnits("SI")</code>
	 */
	SystemOfUnits getSystemOfUnits();

    /**
     * Returns the system of units having the specified name or
     * <code>null</code> if none.
     *
     * @param name the system of unit name.
     * @return the system of units.
     */
	SystemOfUnits getSystemOfUnits(String name);

}
