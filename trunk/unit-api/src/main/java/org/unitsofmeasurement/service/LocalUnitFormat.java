/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.service;

import java.util.Locale;
import org.unitsofmeasurement.unit.UnitFormat;

/**
 * <p> This interface provides methods for OSGi bundles to parse/format units
 *     using the local format.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.0
 */
public interface LocalUnitFormat extends UnitFormat {

    /**
     * Returns the specific geographical, political, or cultural region
     * of this unit format.
     */
    public Locale getLocale();

}
