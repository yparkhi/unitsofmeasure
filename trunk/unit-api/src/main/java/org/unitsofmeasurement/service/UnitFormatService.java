/**
 * Unit-API - Units of Measurement API for Java (http://unitsofmeasurement.org)
 * Copyright (c) 2005-2010, Unit-API contributors, JScience and others
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package org.unitsofmeasurement.service;

import java.util.Locale;
import java.util.Set;
import org.unitsofmeasurement.unit.UnitFormat;


/**
 * The service to obtain {@link UnitFormat} instances.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1
 *
 * @since 0.6.0
 */
public interface UnitFormatService {
    /**
     * Returns the default <a href="http://www.unitsofmeasure.org/">UCUM</a> unit format.
     *
     * @return {@code getUnitFormat("UCUM")}
     */
    UnitFormat getUnitFormat();

    /**
     * Returns the unit format having the specified name, or {@code null} if none.
     * The list of known names can be obtained by {@link #getUnitFormatNames()}.
     *
     * @param  name the name of the format.
     * @return the unit format for the given name, or {@code null} if none.
     */
    UnitFormat getUnitFormat(String name);

    /**
     * Returns the unit format for the specified locale, or {@code null} if none.
     *
     * @param  locale the locale for the format.
     * @return the unit format for the given locale, or {@code null} if none.
     */
    UnitFormat getUnitFormat(Locale locale);

    /**
     * Returns the names of all {@linkplain UnitFormat unit formats} known to this service.
     * The returned set typically contains at least the {@code "UCUM"} name.
     *
     * @return All unit formats known to this service.
     *
     * @since 0.6.2
     */
    Set<String> getUnitFormatNames();
}
